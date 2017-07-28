package zookeeper.zookeeper.function.distributedlock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.ACL;
import org.apache.zookeeper.data.Stat;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * A base class for protocol implementations which provides a number of higher
 * level helper methods for working with ZooKeeper along with retrying synchronous
 * operations if the connection to ZooKeeper closes such as
 * {@link #retryOperation(ZooKeeperOperation)}
 */
class ProtocolSupport {
    private static final Logger LOG = LoggerFactory.getLogger(ProtocolSupport.class);

    protected final ZooKeeper zookeeper;
    private AtomicBoolean closed = new AtomicBoolean(false);
    private long retryDelay = 500L;// 毫秒
    private int retryCount = 10;
    private List<ACL> acl = ZooDefs.Ids.OPEN_ACL_UNSAFE;

    public ProtocolSupport(ZooKeeper zookeeper) {
        this.zookeeper = zookeeper;
    }

    public void close() {
        if (closed.compareAndSet(false, true)) {
            doClose();
        }
    }

    public ZooKeeper getZookeeper() {
        return zookeeper;
    }

    public List<ACL> getAcl() {
        return acl;
    }

    public void setAcl(List<ACL> acl) {
        this.acl = acl;
    }

    public long getRetryDelay() {
        return retryDelay;
    }

    public void setRetryDelay(long retryDelay) {
        this.retryDelay = retryDelay;
    }

    protected void doClose() {
    }


    /**
     * Perform the given operation, retrying if the connection fails
     *
     * @return object. it needs to be cast to the callee's expected
     * return type.
     */
    protected Object retryOperation(ZooKeeperOperation operation)
            throws KeeperException, InterruptedException {
        KeeperException exception = null;
        for (int i = 0; i < retryCount; i++) {
            try {
                return operation.execute();
            } catch (KeeperException.SessionExpiredException e) {
                LOG.warn("Session expired for: " + zookeeper + " so reconnecting due to: " + e, e);
                throw e;
            } catch (KeeperException.ConnectionLossException e) {
                if (exception == null) {
                    exception = e;
                }
                LOG.debug("Attempt " + i + " failed with connection loss so " +
                        "attempting to reconnect: " + e, e);
                retryDelay(i);
            }
        }
        throw exception;
    }

    /**
     * Ensures that the given path exists with no data, the current
     * ACL and no flags
     *
     * @param path
     */
    protected void ensurePathExists(String path) {
        ensureExists(path, null, acl, CreateMode.PERSISTENT);
    }

    /**
     * Ensures that the given path exists with the given data, ACL and flags
     *
     * @param path
     * @param acl
     * @param flags
     */
    protected void ensureExists(final String path, final byte[] data,
                                final List<ACL> acl, final CreateMode flags) {
        try {
            retryOperation(new ZooKeeperOperation() {
                public boolean execute() throws KeeperException, InterruptedException {
                    Stat stat = zookeeper.exists(path, false);
                    if (stat != null) {
                        return true;
                    }
                    zookeeper.create(path, data, acl, flags);
                    return true;
                }
            });
        } catch (KeeperException e) {
            LOG.warn("Caught: " + e, e);
        } catch (InterruptedException e) {
            LOG.warn("Caught: " + e, e);
        }
    }

    /**
     * Returns true if this protocol has been closed
     *
     * @return true if this protocol is closed
     */
    protected boolean isClosed() {
        return closed.get();
    }

    /**
     * Performs a retry delay if this is not the first attempt
     *
     * @param attemptCount the number of the attempts performed so far
     */
    protected void retryDelay(int attemptCount) {
        if (attemptCount > 0) {
            try {
                Thread.sleep(attemptCount * retryDelay);
            } catch (InterruptedException e) {
                LOG.debug("Failed to sleep: " + e, e);
            }
        }
    }
}

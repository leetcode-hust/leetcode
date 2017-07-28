package zookeeper.zookeeper.function.distributedlock;

/**
 * This class has two methods which are call
 * back methods when a lock is acquired and 
 * when the lock is released.
 *
 */
public interface LockListener {
    /**
     * call back called when the lock 
     * is acquired
     */
    public void lockAcquired();
    
    /**
     * call back called when the lock is 
     * released.
     */
    public void lockReleased();
}

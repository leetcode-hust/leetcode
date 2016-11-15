package thread2;


/**
 * SynchronizedInteger
 * <p/>
 * Thread-safe mutable integer holder
 *
 * @author Brian Goetz and Tim Peierls
 */
public class SynchronizedInteger {
    private int value;

    public synchronized int get() {
        return value;
    }

    public synchronized void set(int value) {
        this.value = value;
    }
}

package thread.uncaughtException;

/**
 * Created by louyuting on 2017/3/11.
 */
public class ExceptionThread2 implements Runnable {
    @Override
    public void run() {
        Thread t = Thread.currentThread();
        System.out.println("run by " + t.getName());
        System.out.println("Exception " + t.getUncaughtExceptionHandler());
        throw new RuntimeException();
    }
}

package thread.uncaughtException;

/**
 * Created by louyuting on 2017/3/11.
 */
public class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler{

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("\n [caugth:] " + e.toString());
    }

}

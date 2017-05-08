package thread.uncaughtException;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by louyuting on 2017/3/11.
 */
public class CaptureUncaughtException {
    public static void main(String[] args) {
        ExecutorService es = Executors.newCachedThreadPool(new HandlerThreadFactory());
        es.execute(new ExceptionThread2());
        es.execute(new ExceptionThread3());
    }
}

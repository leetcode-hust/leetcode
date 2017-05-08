package thread.uncaughtException;

import java.util.concurrent.ThreadFactory;

/**
 * Created by louyuting on 2017/3/11.
 */
public class HandlerThreadFactory implements ThreadFactory {

    @Override
    public Thread newThread(Runnable r) {
        System.out.println(this + "creating new thread");
        Thread t = new Thread(r);
        System.out.println("created" + t);
        //为每一个线程设置异常捕获器
        t.setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
        System.out.println("eh = " + t.getUncaughtExceptionHandler());
        return t;
    }
}

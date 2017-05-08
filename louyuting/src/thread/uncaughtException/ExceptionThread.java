package thread.uncaughtException;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by louyuting on 2017/3/11.
 */
public class ExceptionThread implements Runnable{

    @Override
    public void run() {
        System.out.println("准备抛出异常");
        throw new RuntimeException();
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new ExceptionThread());

        try {
            ExecutorService service = Executors.newCachedThreadPool();
            service.execute(thread);
        } catch (Exception e) {
            System.out.println("我捕捉到异常了");
            e.printStackTrace();
        }
    }
}

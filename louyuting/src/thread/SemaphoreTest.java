package thread;

import java.util.concurrent.Semaphore;

/**
 * Created by louyuting on 17/1/11.
 */
public class SemaphoreTest{
    public static void main(String[] args) {
        final Semaphore semaphore = new Semaphore(5);

        Runnable runnable = new Runnable(){
            public void run()
            {
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + "获得了信号量,时间为" + System.currentTimeMillis());
                    Thread.sleep(2000);
                    System.out.println(Thread.currentThread().getName() + "释放了信号量,时间为" + System.currentTimeMillis());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                }
            }
        };

        Thread[] threads = new Thread[10];
        for (int i = 0; i < threads.length; i++)
            threads[i] = new Thread(runnable);
        for (int i = 0; i < threads.length; i++)
            threads[i].start();
    }
}

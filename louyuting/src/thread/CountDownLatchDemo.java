package thread;
import java.util.concurrent.*;
import java.util.*;

/**
 * CountDownLatch的一个用法示例，
 * 在完成一组正在其他线程中执行的操作之前，
 * 它允许一个或多个线程一直等待
 */


/**
 * work线程
 */
class TaskPortion implements Runnable {
    private static int counter = 0;
    private final int id = counter++;//唯一id

    private static Random rand = new Random(47);
    private final CountDownLatch latch;

    TaskPortion(CountDownLatch latch) {
        this.latch = latch;
    }
    public void run() {
        try {
            doWork();
            latch.countDown();//递减锁存器的计数，如果计数到达零，则释放所有等待的线程
        } catch(InterruptedException ex) {
            // Acceptable way to exit
        }
    }
    private void doWork() throws InterruptedException {
        //做任务耗时
        TimeUnit.MILLISECONDS.sleep(rand.nextInt(2000));
        System.out.println(this + "completed");
    }
    public String toString() {
        return String.format("%1$-3d ", id);
    }
}

/**
 * 等待线程
 */
class WaitingTask implements Runnable {
    private static int counter = 0;
    private final int id = counter++;//唯一id
    private final CountDownLatch latch;
    WaitingTask(CountDownLatch latch) {
        this.latch = latch;
    }
    public void run() {
        try {
            latch.await();//使当前线程在锁存器倒计数至零之前一直等待，除非线程被中断。
            System.out.println("Latch barrier passed for " + this);
        } catch(InterruptedException ex) {
            System.out.println(this + " interrupted");
        }
    }
    public String toString() {
        return String.format("WaitingTask %1$-3d ", id);
    }
}


/**
 * main thread
 */
public class CountDownLatchDemo {
    static final int SIZE = 100;

    public static void main(String[] args) throws Exception {
        ExecutorService exec = Executors.newCachedThreadPool();
        // All must share a single CountDownLatch object:
        CountDownLatch latch = new CountDownLatch(SIZE);//构造一个用给定计数初始化的 CountDownLatch。
        //10个等待线程
        for(int i = 0; i < 10; i++){
            exec.execute(new WaitingTask(latch));
        }
        //100个计数线程
        for(int i = 0; i < 100; i++){
            exec.execute(new TaskPortion(latch));
        }
        System.out.println("Launched all tasks");
        exec.shutdown(); // Quit when all tasks complete
    }
}








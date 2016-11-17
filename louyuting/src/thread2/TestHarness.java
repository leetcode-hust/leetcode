package thread2;

import java.util.concurrent.CountDownLatch;

/**
 * TestHarness
 * <p/>
 * Using CountDownLatch for starting and stopping threads in timing tests
 *
 * @author Brian Goetz and Tim Peierls
 */

public class TestHarness {
    public class Task implements Runnable{
        @Override
        public void run() {
            System.out.println("task");
        }
    }

    public Task task = new Task();

    public static long timeTasks(int nThreads, final Runnable task) throws InterruptedException {
        final CountDownLatch startGate = new CountDownLatch(1);
        final CountDownLatch endGate = new CountDownLatch(nThreads);

        for (int i = 0; i < nThreads; i++) {
            Thread t = new Thread() {
                public void run() {
                    try {
                        startGate.await();//将所有线程都挂起，等待startGate.countDown()
                        try {
                            task.run();
                        } finally {
                            endGate.countDown();
                        }
                    } catch (InterruptedException ignored) {
                    }
                }
            };
            t.start();
        }

        long start = System.nanoTime();
        startGate.countDown();//让所有的线程通过，然后所有线程开始执行task.run()里面的
        endGate.await();//等待所有的task线程执行完，那么，门就会打开
        long end = System.nanoTime();
        return end - start;
    }



    public static void main(String[] args) {

    }
}

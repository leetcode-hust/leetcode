package thread2;

import org.junit.Test;

/**
 * NoVisibility
 * <p/>
 * Sharing variables without synchronization
 *
 * @author Brian Goetz and Tim Peierls
 */
public class NoVisibility {
    private static boolean ready;
    private static int number;

    private static class ReaderThread extends Thread {
        public void run() {
            while (!ready)
                Thread.yield();
            System.out.println(number);
        }
    }

    public static void hehe() {
        new ReaderThread().start();
        number = 42;
        ready = true;
    }

    @Test
    public void test(){
        for (int i=0; i<500; i++){
            hehe();
        }

    }
}

package JVM;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by louyuting on 17/1/3.
 */
public class VolatileTest {

    public static volatile int race=0;

    public static void increase(){
        race++;
    }

    private static final int THREAD_COUNT=20;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_COUNT);
        for(int i=0; i<THREAD_COUNT;i++){
            executorService.submit(new Thread(new Runnable() {
                @Override
                public void run() {
                    for(int j=0; j<10000; j++){
                        increase();
                    }
                }
            }));
        }

        executorService.shutdown();

        System.out.print(race);
    }


}

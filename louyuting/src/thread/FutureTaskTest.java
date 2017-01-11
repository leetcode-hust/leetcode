package thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2016/11/2.
 */
public class FutureTaskTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<String> ftask = new FutureTask<String>(
                new Callable() {
                    @Override
                    public Object call() throws Exception {
                        System.out.println("second ");
                        TimeUnit.SECONDS.sleep(4);//计算的过程，需要的时间设置成4秒
                        return "success";
                    }
                }
        );
        System.out.println("first ");
        ftask.run();//开始执行任务，内部会调用 Callable的call()方法
        System.out.println("third ");
        String result = ftask.get();
        System.out.println("four ");
        System.out.println(result);
    }
/**
 * output:
 * first
 * second
 * third
 * four
 * success
 */
}

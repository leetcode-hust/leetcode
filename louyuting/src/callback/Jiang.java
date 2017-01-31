package callback;

import java.util.concurrent.TimeUnit;

/**
 * Created by louyuting on 17/1/29.
 * 小蒋
 */
public class Jiang {
    /**
     * 相当于B类有参数为CallBack callBack的f()---->背景三
     * @param callBack
     * @param question 小娄的问题
     */
    public void executeMessage(CallBack callBack, String question){
        //模拟小李吃饭
        for(int i=0; i<10000;i++){
            try {
                TimeUnit.MILLISECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("小蒋吃完了饭,然后取完快递给李老师了");

        String result = "小蒋已经把快递给了老师!";

        /**
         * 于是就打电话告诉小娄，调用小娄中的方法
         * 这就相当于B类反过来调用A的方法 d
         */
        callBack.solve(result);
    }
}

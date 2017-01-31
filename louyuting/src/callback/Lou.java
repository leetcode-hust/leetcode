package callback;

/**
 * Created by louyuting on 17/1/29.
 *  这个是小娄
 *  实现了一个回调接口CallBack，相当于----->背景一
 */
public class Lou implements CallBack {

    //包含一个小蒋的引用----背景2
    private Jiang jiang;

    public Lou(Jiang jiang) {
        this.jiang = jiang;
    }


    /**
     * 小娄通过这个方法给小蒋布置任务.
     * @param question
     */
    public void askQuestion(final String question){

        System.out.println("小娄问的问题--->" + question);

        //这里用一个线程就是异步回调了，
        new Thread(new Runnable() {
            @Override
            public void run() {
                /**
                 * 小娄调用小李中的方法，在这里注册回调接口
                 * 这就相当于A类调用B的方法c
                 */
                jiang.executeMessage(Lou.this, question);
            }
        }).start();

        //小娄说了task就去做自己的事了
        play();
    }

    public void play(){
        System.out.println("小娄给小蒋交代了任务就去做自己的事了.");
    }

    @Override
    public void solve(String result) {
        System.out.println("小蒋告诉小娄的回信--->" + result);
    }
}

package test;

/**
 * Created by louyuting on 2017/2/27.
 */
public class ThreadTest {
    public static class ThreadTe extends Thread{
        private String name;
        private ThreadTe next;
        public ThreadTe(String name) {
            this.name = name;
        }
        public ThreadTe(ThreadTe next, String name) {
            this.next = next;
            this.name = name;
        }
        @Override
        public void run(){

            int i=0;
            byte y = (byte)i;
            System.out.println(this.name + "start");
            try {
                if(next != null){
                    next.run();
                    next.join();
                }
                sleep(1000);
            } catch (Exception e){
                e.printStackTrace();
            }
            System.out.println(this.name + "finished");
        }
    }
    public static void main(String[] args) throws Exception{
        ThreadTe C  = new ThreadTe("C");
        ThreadTe B  = new ThreadTe(C,"B");
        ThreadTe A  = new ThreadTe(B,"A");
        A.run();
    }
}

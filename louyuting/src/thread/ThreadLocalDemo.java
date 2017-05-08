package thread;

/**
 * Created by louyuting on 2017/2/14.
 */
public class ThreadLocalDemo {

    //创建一个ThreadLocal变量, 然后通过构造器传入 包含 这个属性的对象ThreadLocalDemo
    private static ThreadLocal<String> stringThreadLocal = new ThreadLocal<String>(){
        @Override
        protected String initialValue() {
            return "init->";
        }
    };

    /**
     * 设置值并返回设置之后的新值
     * @param string
     * @return
     */
    public String addString(String string){

        stringThreadLocal.set(string);

        return stringThreadLocal.get();
    }

    /**
     * 获取ThreadLocal中的值
     * @return
     */
    public String getString(){

        return stringThreadLocal.get();
    }


    public static void main(String[] args) {

        ThreadLocalDemo demo = new ThreadLocalDemo();

        //这里有3个线程, 每个线程都传入包含ThreadLocal变量的对象, 然后对 ThreadLocal类型的变量stringThreadLocal 操作
        TestThread thread1 = new TestThread(demo);
        TestThread thread2 = new TestThread(demo);
        TestThread thread3 = new TestThread(demo);

        thread1.start();
        thread2.start();
        thread3.start();
    }

    private static class TestThread extends Thread{
        private ThreadLocalDemo threadLocalDemo;

        public TestThread(ThreadLocalDemo threadLocalDemo) {
            this.threadLocalDemo = threadLocalDemo;
        }

        @Override
        public void run() {

            for(int i=0; i<3; i++){
                //在线程私有的副本里面 改变ThreadLocal变量的值
                System.out.println("thread[" + Thread.currentThread().getName() + "]--->threadlocaldemo["
                        + threadLocalDemo.addString( threadLocalDemo.getString() + "[local" + i +"]-" ) );
            }
        }
    }
}
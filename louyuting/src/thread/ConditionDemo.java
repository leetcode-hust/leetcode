package thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionDemo {
    private static Lock lock = new ReentrantLock();
    private static Condition condition = lock.newCondition();
    public static void main(String[] args) {
        Thread thread1 = new Thread(new Runnable(){

            @Override
            public void run() {
                lock.lock();
                System.out.println(Thread.currentThread().getName()+"正在运行。。。。");
                try {
                    Thread.sleep(2000);
                    System.out.println(Thread.currentThread().getName()+"停止运行，等待一个signal");
                    condition.await();//等待 并且会释放锁
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"获得一个signal，继续执行");
                lock.unlock();
            }

        },"waitThread");
        thread1.start();

        try {
            Thread.sleep(1000);//保证线程1先执行，否则线程1将一直等待signal信号
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
        Thread thread2 = new Thread(new Runnable(){

            @Override
            public void run() {
                lock.lock();//获取锁
                System.out.println(Thread.currentThread().getName()+"正在运行。。。。");
                condition.signal();//发送信号，唤醒其它线程
                System.out.println(Thread.currentThread().getName()+"发送一个signal");
                System.out.println(Thread.currentThread().getName()+"发送一个signal后，结束");
                lock.unlock();//释放锁之后,thread1再执行
            }

        },"signalThread");
        thread2.start();

    }

}
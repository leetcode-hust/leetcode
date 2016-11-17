package thread;
import java.util.concurrent.*;
import static thread.Print.*;

class Car {
    //表示涂蜡抛光的处理状态
  private boolean waxOn = false;
    /**
     * 涂完了
     */
  public synchronized void waxed() {
    waxOn = true; // Ready to buff
    notifyAll();
  }
    /**
     * 抛光
     */
  public synchronized void buffed() {
    waxOn = false; // Ready for another coat of wax
    notifyAll();
  }
  public synchronized void waitForWaxing() throws InterruptedException {
    while(waxOn == false)
      wait();
  }
  public synchronized void waitForBuffing() throws InterruptedException {
    while(waxOn == true)
      wait();
  }
}
/**
 * 涂蜡任务
 */
class WaxOn implements Runnable {
  private Car car;
  public WaxOn(Car c) { this.car = c; }
  public void run() {
    try {
      while(!Thread.interrupted()) {
        print("Wax On! ");
          //涂蜡的过程
        TimeUnit.MILLISECONDS.sleep(200);
          //蜡涂完了，唤醒所有wait()的线程
        car.waxed();
          //等待抛光，wait()
        car.waitForBuffing();
      }
    } catch(InterruptedException e) {
      print("Exiting via interrupt");
    }
    print("Ending Wax On task");
  }
}

class WaxOff implements Runnable {
  private Car car;
  public WaxOff(Car c) { this.car = c; }
  public void run() {
    try {
      while(!Thread.interrupted()) {
          //等待涂蜡
        car.waitForWaxing();
          //涂完了
        print("Wax Off! ");
          //抛光
        TimeUnit.MILLISECONDS.sleep(200);
          //等待再涂蜡
        car.buffed();
      }
    } catch(InterruptedException e) {
      print("Exiting via interrupt");
    }
    print("Ending Wax Off task");
  }
}

public class WaxOMatic {
  public static void main(String[] args) throws Exception {
    Car car = new Car();
    ExecutorService exec = Executors.newCachedThreadPool();
    exec.execute(new WaxOff(car));
    exec.execute(new WaxOn(car));
    TimeUnit.SECONDS.sleep(5); // Run for a while...
    exec.shutdownNow(); // Interrupt all tasks
  }
} /* Output: (95% match)
Wax On! Wax Off! Wax On! Wax Off! Wax On! Wax Off! Wax On! Wax Off! Wax On! Wax Off! Wax On! Wax Off! Wax On! Wax Off! Wax On! Wax Off! Wax On! Wax Off! Wax On! Wax Off! Wax On! Wax Off! Wax On! Wax Off! Wax On! Exiting via interrupt
Ending Wax On task
Exiting via interrupt
Ending Wax Off task
*///:~

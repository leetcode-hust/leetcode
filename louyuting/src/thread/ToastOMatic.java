package thread;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.*;
import java.util.*;
import static thread.Print.*;

/***
 * BlockingQueue例子：一台机器有三个任务，
 * A制作吐司，B给吐司抹黄油，C给吐司末果酱，
 * 制作的顺序必须是A-》B-》C
 * 阻塞队列里面保存的应该是吐司对象
 */
class Toast {
    /**
     * 枚举表示吐司制作的几个过程
     */
  public enum Status {
      DRY, BUTTERED, JAMMED
  }
    //设置初试状态
  private Status status = Status.DRY;
    //设置每个吐司的唯一id
  private final int id;
  public Toast(int idn) {
      this.id = idn;
  }
    //涂黄油
  public void butter() {
      this.status = Status.BUTTERED;
  }
    //涂果酱
  public void jam() {
      status = Status.JAMMED;
  }
    //获取当前吐司的状态
  public Status getStatus() {
      return status;
  }
    //获取当前吐司的id
  public int getId() {
      return id;
  }
  public String toString() {
    return "Toast " + id + ": " + status;
  }
}

/**
 * 吐司的阻塞队列,队列里面的元素对象就是吐司对象，三个任务之间维护的就是吐司
 */
class ToastQueue extends LinkedBlockingQueue<Toast> {

}

/**
 * 制作吐司的线程
 * 这个线程只需要与已做好的吐司队列这一个队列交互
 * 将做好的吐司存放在吐司队列中，
 * 通过构造器传入队列
 */
class Toaster implements Runnable {
  private ToastQueue toastQueue;//构造器将会传入的阻塞队列对象
  private int count = 0;//
  private Random rand = new Random(47);
  public Toaster(ToastQueue tq) {
      this.toastQueue = tq;
  }

    @Override
  public void run() {
    try {
      while(!Thread.interrupted()) {
          //制作吐司的时间消耗
        //TimeUnit.MILLISECONDS.sleep(100 + rand.nextInt(100));
          TimeUnit.MILLISECONDS.sleep(2);
        //创建吐司对象
        Toast t = new Toast(count++);
        print(t);
        //将新建的吐司放在队列中
        toastQueue.put(t);
      }
    } catch(InterruptedException e) {
      print("Toaster interrupted");
    }
    print("Toaster off");
  }
}

/**
 * 给吐司抹黄油的线程
 * 这个任务设计到两个队列，首先从吐司队列中能取出吐司，然后再抹黄油。
 */
class Butterer implements Runnable {
  private ToastQueue dryQueue, butteredQueue;
  public Butterer(ToastQueue dry, ToastQueue buttered) {
    this.dryQueue = dry;
    this.butteredQueue = buttered;
  }
  public void run() {
    try {
      while(!Thread.interrupted()) {
        //阻塞等待吐司队列中有可以抹黄油的吐司对象
        Toast t = dryQueue.take();
          //抹黄油 500ms
          TimeUnit.MILLISECONDS.sleep(10);
        t.butter();
        print(t);
        butteredQueue.put(t);
      }
    } catch(InterruptedException e) {
      print("Butterer interrupted");
    }
    print("Butterer off");
  }
}

//给吐司抹上果酱的线程
//这个任务设计到两个队列，首先从黄油队列中取出，然后抹果酱，加入果酱队列(也就是成品了)。
class Jammer implements Runnable {
  private ToastQueue butteredQueue, finishedQueue;
  public Jammer(ToastQueue buttered, ToastQueue finished) {
    this.butteredQueue = buttered;
      this.finishedQueue = finished;
  }
  public void run() {
    try {
      while(!Thread.interrupted()) {
        // Blocks until next piece of toast is available:
        Toast t = butteredQueue.take();
          //抹果酱 500ms
          TimeUnit.MILLISECONDS.sleep(10);
        t.jam();
        print(t);
        finishedQueue.put(t);
      }
    } catch(InterruptedException e) {
      print("Jammer interrupted");
    }
    print("Jammer off");
  }
}

//最后的吃吐司的线程，字设计到
class Eater implements Runnable {

  private ToastQueue finishedQueue,eatedQueue;
  private int counter = 0;
  public Eater(ToastQueue finished, ToastQueue eated) {
    finishedQueue = finished;
      this.eatedQueue = eated;
  }
  public void run() {
    try {
      while(!Thread.interrupted()) {
        // Blocks until next piece of toast is available:
        Toast t = finishedQueue.take();
          TimeUnit.MILLISECONDS.sleep(100);//吃
          eatedQueue.put(t);//装入吃完了的队列
        // Verify that the toast is coming in order,
        // and that all pieces are getting jammed:
        if(t.getId() != counter++ ||
           t.getStatus() != Toast.Status.JAMMED) {
          print(">>>> Error: " + t);
          System.exit(1);
        } else
          print("Chomp! " + t);
      }
    } catch(InterruptedException e) {
      print("Eater interrupted");
    }
    print("Eater off");
  }
}


/**
 * 最后的main主线程
 */
public class ToastOMatic {
    public static void main(String[] args) throws Exception {

        //这里定义了三个阻塞队列
        //A是制作吐司的队列
        //B是抹黄油的队列
        //C是摸果酱的队列
        ToastQueue dryQueue = new ToastQueue();
        ToastQueue butteredQueue = new ToastQueue();
        ToastQueue finishedQueue = new ToastQueue();
        ToastQueue eatedQueue = new ToastQueue();
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new Toaster(dryQueue));
        exec.execute(new Toaster(dryQueue));
        exec.execute(new Toaster(dryQueue));//三个人做吐司

        exec.execute(new Butterer(dryQueue, butteredQueue));
        exec.execute(new Jammer(butteredQueue, finishedQueue));
        //三个人吃
        exec.execute(new Eater(finishedQueue,eatedQueue));
        exec.execute(new Eater(finishedQueue,eatedQueue));
        exec.execute(new Eater(finishedQueue,eatedQueue));
        TimeUnit.SECONDS.sleep(5);

        exec.shutdownNow();
        //最后统计三个队列中的信息
        print("=============================================");
        print("【吐司队列还有】"+dryQueue.size());
        print("【黄油队列还有】"+butteredQueue.size());
        print("【果酱队列还有】"+finishedQueue.size());
        print("【吃完队列有】"+eatedQueue.size());
  }
}

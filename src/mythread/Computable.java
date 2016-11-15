package mythread;

/**
 * Created by Administrator on 2016/11/2.
 */
public interface Computable <A, V>{
    V compute(A arg) throws InterruptedException;
}

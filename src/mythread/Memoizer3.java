package mythread;

import java.util.Map;
import java.util.concurrent.*;

/**
 * 使用并发ConcurrentHashMap代替HashMap
 * 缺陷：当两个线程同时调用compute计算一个没有缓存的结果时，会导致计算相同的值，如果这个计算是非常耗时间的
 * 那么将严重影响系统的性能。
 * 解决：当有一个线程在计算时，让别的计算同一个值的线程等待计算结果再从缓存中获取：
 *      通过FutureTask实现
 */
public class Memoizer3<A, V> implements Computable<A, V> {

    private final Map<A,Future<V> > cache = new ConcurrentHashMap<A,Future<V>>();
    private final Computable<A,V> c;

    public Memoizer3(Computable<A, V> c) {
        this.c = c;
    }
    @Override
    public V compute(A arg) throws InterruptedException {
        Future<V> future = cache.get(arg);
        //如果map中没有缓存结果，就执行计算
        if(future == null){
            //一个有返回值线程
            Callable<V> eval = new Callable<V>() {
                @Override
                public V call() throws Exception {
                    return c.compute(arg);
                }
            };
            //创建一个FutureTask，
            FutureTask<V> ft = new FutureTask<V>(eval);
            future = ft;
            cache.putIfAbsent(arg, ft);
            ft.run();
        }
        try {
            //返回结果或则等待计算结束再返回结果
            return future.get();
        } catch (ExecutionException e) {
            return null;
        }
    }
}

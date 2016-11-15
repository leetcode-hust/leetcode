package mythread;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 使用并发ConcurrentHashMap代替HashMap
 * 缺陷：当两个线程同时调用compute计算一个没有缓存的结果时，会导致计算相同的值，如果这个计算是非常耗时间的
 * 那么将严重影响系统的性能。
 * 解决：当有一个线程在计算时，让别的计算同一个值的线程等待计算结果再从缓存中获取：
 *      通过FutureTask实现
 */
public class Memoizer2<A, V> implements Computable<A, V> {

    private final Map<A,V> cache = new ConcurrentHashMap<A,V>();
    private final Computable<A,V> c;

    public Memoizer2(Computable<A, V> c) {
        this.c = c;
    }
    @Override
    public V compute(A arg) throws InterruptedException {
        V result = cache.get(arg);
        if(result == null){
            result = c.compute(arg);
            cache.put(arg,result);
        }

        return result;
    }
}

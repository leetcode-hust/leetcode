package mythread;

import java.util.HashMap;
import java.util.Map;

/**
 * 糟糕的同步实现，每次计算都获取对象锁，所以计算是串行的。
 */
public class Memoizer<A, V> implements Computable<A, V> {

    private final Map<A,V> cache = new HashMap<A,V>();
    private final Computable<A,V> c;

    public Memoizer(Computable<A, V> c) {
        this.c = c;
    }
    @Override
    public synchronized V compute(A arg) throws InterruptedException {
        V result = cache.get(arg);
        if(result == null){
            result = c.compute(arg);
            cache.put(arg,result);
        }
        return result;
    }
}

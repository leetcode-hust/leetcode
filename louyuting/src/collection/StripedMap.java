package collection;

import java.util.Map;

/**
 * Created by louyuting on 17/1/10.
 */
public class StripedMap {
    //同步策略: buckets[n]由 locks[n%N_LOCKS] 来保护

    private static final int N_LOCKS = 16;//分段锁的个数
    private final Node[] buckets;
    private final Object[] locks;

    /**
     * 结点
     * @param <K>
     * @param <V>
     */
    private static class Node<K,V> implements Map.Entry<K,V>{
        final K key;//key
        V value;//value
        Node<K,V> next;//指向下一个结点的指针
        int hash;//hash值

        //构造器，传入Entry的四个属性
        Node(int h, K k, V v, Node<K,V> n) {
            value = v;
            next = n;//该Entry的后继
            key = k;
            hash = h;
        }

        public final K getKey() {
            return key;
        }

        public final V getValue() {
            return value;
        }

        public final V setValue(V newValue) {
            V oldValue = value;
            value = newValue;
            return oldValue;
        }

    }

    /**
     * 构造器: 初始化散列桶和分段锁数组
     * @param numBuckets
     */
    public StripedMap(int numBuckets) {
        buckets = new Node[numBuckets];
        locks = new Object[N_LOCKS];

        for(int i=0; i<N_LOCKS; i++){
            locks[i] = new Object();
        }

    }

    /**
     * 返回散列之后在散列桶之中的定位
     * @param key
     * @return
     */
    private final int hash(Object key){
        return Math.abs(key.hashCode() % N_LOCKS);
    }


    /**
     * 分段锁实现的get
     * @param key
     * @return
     */
    public Object get(Object key){
        int hash = hash(key);//计算hash值

        //获取分段锁中的某一把锁
        synchronized (locks[hash% N_LOCKS]){
            for(Node m=buckets[hash]; m!=null; m=m.next){
                if(m.key.equals(key)){
                    return m.value;
                }
            }
        }

        return null;
    }

    /**
     * 清除整个map
     */
    public void clear() {
        for(int i=0; i<buckets.length; i++){
            synchronized (locks[i%N_LOCKS]){
                buckets[i] = null;
            }
        }
    }

}

































package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author louyuting
 * @create 2017-05-11-下午7:44
 *
 * 460. LFU Cache
 */
public class Question460_LFUCache {
    public static class Node{
        public Node(Integer value, Node pre, Node next) {
            this.value = value;
            this.pre = pre;
            this.next = next;
        }
        public Integer value=0;
        public Integer frequent=0;// 当前节点的使用频率，节点初始化时候都是0；
        public Node pre;// 前驱
        public Node next;// 后继
    }
    private int MAX_CAPACITY;// 最大容量
    private int size=0;// 当前使用的容量
    private Map<Integer, Node> hash = new HashMap<Integer, Node>(); // cache 的数据结构
    private Node head = new Node(0,null,null);
    private Node tail = new Node(0,null,null);

    public Question460_LFUCache(int capacity){
        this.MAX_CAPACITY = capacity;
    }

    /**
     * 获取cache
     */
    public int get(int key) {
        if(size == 0) // 首先判断当前缓存的长度,如果size=0， 表明缓存为空
            return -1;
        //1. 查询缓存是否存在，如果不存在，就直接返回-1；
        //2. 如果缓存存在，就取出缓存，并将当前加点删除然后插入到 tail
        Node node = hash.get(key);
        if(node == null) {
            //如果缓存不存在，就直接返回 -1
            return -1;
        } else {
            logicMoveNode(node);// 如果缓存存在， 就要从逻辑上将当前结点移动到tail后面
            node.frequent++;// 使用频率自加一次。
        }
        return node.value;
    }

    /**
     * 插入cache
     */
    public void put(int key, int value){
        if(MAX_CAPACITY == 0)
            return;

        //判断当前 key是否已经存在
        Node node = hash.get(key);
        if(node != null){
            node.value = value;// key 已经存在， 只需要更新value， 然后将node插入到双向链表的末尾
            logicMoveNode(node);
            node.frequent++;// 使用频率自加
            return;
        } else {
            //当前key不存在，就要判断cache是否满了
            if(size < MAX_CAPACITY){
                if(size == 0){ //Cache还没满， 可以直接插入
                    //还有空间，且缓存为空，直接插入在tail
                    node = new Node(value, null, null);
                    head = tail = node;
                    hash.put(key, node);//存入缓存
                    node.frequent = 1;//使用频率自加
                    size++;// 使用容量自加
                    return;
                } else {
                    //还有空间，缓存不为空，直接插入在tail
                    node = new Node(value, tail, null);
                    tail.next = node;
                    tail = tail.next;
                    node.frequent = 1;// 使用频率zijia
                    hash.put(key, node);//存入缓存
                    size++;
                    return;
                }
            } else if(size == MAX_CAPACITY){
                if(size == 1){//缓存已满， 先删除head，再插入
                    hash.clear();//当前 Cache的最大容量是1,
                    Node val = new Node(value, null, null);
                    val.frequent = 1;
                    hash.put(key, val);
                    tail = head = val;
                    return;
                } else {
                    // key 不存在， size >= 2, 且缓存满了。 这时候的策略是:首先找到最频繁使用的节点， 也就是 node.frequent 最大的节点，
                    // 如果  node.frequent 最大的节点有多个，然后在frequent最大的多个节点中删除根据 LRU 策略 判定的节点。
                    //遍历一轮，先找到最大的频率，
                    Node point = head;
                    int minFrequ = point.frequent;
                    while (point != null){
                        if(point.frequent < minFrequ){
                            minFrequ = point.frequent;
                        }
                        point = point.next;
                    }
                    // 再遍历一轮找到最大频率对应的节点, 由于双向链表本身就是按照最近最少使用来排列的， head 是最近最少使用的， tail是刚刚使用的， 所以遇到的第一个节点就是要删除的节点
                    point = head;
                    while (point != null){
                        if(point.frequent == minFrequ){
                            // 找到要删除的节点了，就是point
                            if(point == head){// 如果删除节点是 head
                                //如果是链表的首节点
                                //删除链表
                                head = head.next;
                                head.pre = null;
                                // 删除hash表
                                findAndRemove(point);
                                // 插入新节点
                                Node val = new Node(value, tail, null);
                                val.frequent = 1;
                                tail.next = val;
                                tail = tail.next;
                                hash.put(key, val);
                                return;
                            } else if(point == tail){
                                //如果是链表的尾节点
                                // 从hash 中删除，
                                findAndRemove(point);
                                //从链表删除
                                tail.value = value;
                                tail.frequent = 1;
                                // hash表插入新的节点
                                hash.put(key, tail);
                                return;
                            } else {
                                // point 是中间节点
                                //链表删除节点
                                point.pre.next = point.next;
                                point.next.pre = point.pre;
                                //hash 删除节点
                                // 删除hash表
                                findAndRemove(point);
                                //插入新节点到tail
                                // 插入新节点
                                Node val = new Node(value, tail, null);
                                val.frequent = 1;
                                tail.next = val;
                                tail = tail.next;
                                hash.put(key, val);
                                return;
                            }
                        }
                        point = point.next;
                    }
                }
            } else {
                System.out.println("cache 异常，已经超过内存");
            }
        }
    }

    private void findAndRemove(Node point) {
        int kkey = 0;
        //现在hash 中找到某一个 key 的 value 是 point, 然后从hash 中删除
        for(Integer k : hash.keySet()){
            if(hash.get(k) == point){
                kkey = k;
                break;
            }
        }
        hash.remove(kkey);
    }
    /**
     * 逻辑移动已存在的节点 node 节点到 tail 后面
     */
    private void logicMoveNode(Node node){
        if(size == 1){
            //什么都不做
        }else if(size == 2 ){
            if(node == head){
                // 当访问的是head结点，就要将head 和 tail 交换
                Node temp;
                temp = head;
                head = tail;
                tail = temp;
                head.next = tail;
                head.pre = null;
                tail.pre = head;
                tail.next= null;
            } else {
                //当访问的是tail结点，就什么都不用做。
            }
        } else {
            if(node == head){
                //当前缓存值大于3
                //把头结点插入到tail
                //head后移一位
                Node temp = head;
                head = head.next;// head后移动
                head.pre = null;
                //把原来的head 插入到tail后面
                tail.next = temp;
                temp.pre = tail;
                temp.next = null;
                tail = tail.next;
            } else if(node == tail){
                //什么也不做
            } else {
                //逻辑删除node
                node.pre.next = node.next;
                node.next.pre = node.pre;
                //node插入到链表尾部
                tail.next = node;
                node.pre = tail;
                node.next=null;
                tail = tail.next;
            }
        }
    }

    public static void main(String[] args) {
        Question460_LFUCache cache = new Question460_LFUCache(0);
        cache.put(0,0);

        System.out.println( cache.get(0) );
        /*cache.put(1, 1);
        cache.put(2, 2);
        System.out.println( cache.get(1) );
        cache.put(3, 3);
        System.out.println( cache.get(2) );
        System.out.println( cache.get(3) );
        cache.put(4, 4);
        System.out.println( cache.get(1) );
        System.out.println( cache.get(3) );
        System.out.println( cache.get(4) );*/
    }

}

package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author louyuting
 * @create 2017-05-11-下午7:44
 *
 * 146. LRU Cache
 */
public class LRUCache {
    /**
     * Map的value 数据结构, 实际是一个双向链表；
     * LRU 维护一个双向链表的表头和表尾，head指向最久不实用节点， tail指向最近刚实用节点
     */
    public static class Node{
        public Node(Integer value, Node pre, Node next) {
            this.value = value;
            this.pre = pre;
            this.next = next;
        }
        public Integer value;
        // 前驱
        public Node pre;
        // 后继
        public Node next;
    }
    // 最大容量
    private int MAX_CAPACITY;
    //当前使用的容量
    private int size=0;
    // cache 的数据结构
    private Map<Integer, Node> hash = new HashMap<Integer, Node>();

    private Node head = new Node(0,null,null);;
    private Node tail = new Node(0,null,null);;

    public LRUCache(int capacity) {
        this.MAX_CAPACITY = capacity;
    }

    /**
     * 获取cache
     * @param key
     * @return
     */
    public int get(int key) {
        // 首先判断当前缓存的长度,如果size=0， 表明缓存为空
        if(size == 0){
            return -1;
        }

        //1. 查询缓存是否存在，如果不存在，就直接返回-1；
        //2. 如果缓存存在，就取出缓存，并将当前加点删除然后插入到 tail
        Node node = hash.get(key);
        if(node == null) {
            return -1;
        } else {
            logicMoveNode(node);
        }
        return node.value;
    }

    /**
     * 插入cache
     * @param key
     * @param value
     */
    public void put(int key, int value) {

        //判断当前 key是否已经存在
        Node node = hash.get(key);
        if(node != null){
            // key 已经存在， 只需要更新value， 然后将node插入到双向链表的末尾
            node.value = value;
            logicMoveNode(node);
        } else {
            //当前key 不存在， 就要判断cache是否满了
            if(size < MAX_CAPACITY){
                //还有空间，直接插入在tail
                node = new Node(value, tail, null);
                tail.next = node;
                tail = tail.next;
                //存入缓存
                hash.put(key, node);
                size++;
            } else if(size == MAX_CAPACITY){
                //已满， 先删除head，再插入
                Node head_h = head;
                head_h = null;
                head = head.next;
                head.pre = null;

                // 插入
                node = new Node(value, tail, null);
                tail.next = node;
                tail = tail.next;
                hash.put(key, node);
            } else {
                try {
                    throw new Exception("cache 异常，已经超过内存");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 逻辑移动已存在的节点 node 节点到 tail 后面
     * @param node
     */
    private void logicMoveNode(Node node){
        if(size == 1){
            //什么都不做
        }else if(size == 2 ){
            if(node == head){
                // 只有两个节点，交换head 和tail
                Node temp;
                temp = head;
                head = tail;
                tail = temp;
            } else {
                //什么都不做
            }
        } else if(node == head){
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
        }
    }

}

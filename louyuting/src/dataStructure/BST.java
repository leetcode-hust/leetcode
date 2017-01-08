package dataStructure;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by louyuting on 17/1/7.
 * 二叉查找树的Java实现:整个实现都是用递归实现的.
 */
public class BST<Key extends Comparable<Key>, Value> {

    private Node root;//二叉查找树的根节点

    //二叉树的结点
    private class Node{
        private Key key;//键
        private Value value;//值
        private Node left, right;//指向子树的链接:左子树和右子树.
        private int N;//以该节点为根的子树中的结点总数

        public Node(Key key, Value value, int N) {
            this.key = key;
            this.value = value;
            this.N = N;
        }
    }

    /**
     * 获取整个二叉查找树的大小
     * @return
     */
    public int size(){
        return size(root);
    }
    /**
     * 获取某一个结点为根结点的二叉查找树的大小
     * @param x
     * @return
     */
    private int size(Node x){
        if(x == null){
            return 0;
        } else {
            return x.N;
        }
    }

    /**
     * 通过key获取value
     * @param key
     * @return
     */
    public Value get(Key key){
        return get(root, key);
    }
    /**
     * 在以 x 为根节点的子树中查找并返回Key所对应的值,如果找不到就返回null
     * 递归实现
     * @param x
     * @param key
     * @return
     */
    private Value get(Node x, Key key){
        if(x == null){
            return null;
        }

        int cmp = key.compareTo(x.key);
        if(cmp<0){
            return get(x.left, key);
        }else if(cmp>0){
            return get(x.right, key);
        } else{
            return x.value;
        }
    }


    /**
     * 设置键值对
     * @param key
     * @param value
     */
    public void put(Key key, Value value){
        root = put(root, key, value);
    }
    /**
     * key如果存在以 x 为根节点的子树中,则更新它的值;
     * 否则将key与value键值对插入并创建一个新的结点.
     * @param x
     * @param key
     * @param value
     * @return
     */
    private Node put(Node x, Key key, Value value){
        if( x==null ){
            new Node(key, value, 1);
        }
        int cmp = key.compareTo(x.key);
        if(cmp<0){
            x.left = put(x.left, key, value);
        }else if(cmp>0){
            x.right = put(x.right, key, value);
        } else{
            x.value=value;//更新value的值
        }
        x.N = size(x.left) + size(x.right) + 1;

        return x;
    }

    /**
     * 最小键
     */
    public Key min(){
        return min(root).key;
    }
    /**
     * 返回结点x为root的二叉排序树中最小key值的Node
     * @param x
     * @return 返回树的最小key的结点
     */
    private Node min(Node x){
        if(x.left == null){
            return x;
        }else{
            return min(x.left);
        }
    }

    /**
     * 最大键
     */
    public Key max(){
        return max(root).key;
    }
    /**
     * 返回结点x为root的二叉排序树中最大key值的Node
     * @param x
     * @return
     */
    private Node max(Node x){
        if(x.right == null){//右子树为空,则根节点是最大的
            return x;
        }else{
            return max(x.right);
        }
    }

    /**
     * key向下取整
     */
    public Key floor(Key key){
        Node x = floor(root, key);
        if(x == null){
            return null;
        }
        return x.key;
    }
    /**
     * 以x 为根节点的二叉排序树,查找以参数key的向下取整的Node
     * @param x
     * @param key
     * @return
     */
    private Node floor(Node x, Key key){
        if(x == null){
            return null;
        }

        int cmp = key.compareTo(x.key);
        if(cmp == 0){
            return x;
        }
        if(cmp < 0){//说明key参数小于x结点的key,所以向下取整结点在左子树
            return floor(x.left, key);
        }
        //向下取整在右子树,
        Node t = floor(x.right, key);
        if( t!= null){
            return t;
        }else {
            return x;
        }
    }

    /**
     * key向上取整
     */
    public Key ceiling(Key key){
        Node x = ceiling(root, key);
        if(x == null){
            return null;
        }
        return x.key;
    }
    /**
     * 以x 为根节点的二叉排序树,查找以参数key的向上取整的Node
     * @param x
     * @param key
     * @return
     */
    private Node ceiling(Node x, Key key){
        if(x == null){
            return null;
        }

        int cmp = key.compareTo(x.key);
        if(cmp == 0){
            return x;
        }
        if(cmp > 0){//说明key参数大于x结点的key,所以向上取整结点在右子树
            return ceiling(x.right, key);
        }
        //向上取整在左子树,
        Node t = ceiling(x.left, key);
        if( t!= null){
            return t;
        }else {
            return x;
        }
    }

    /**
     * 排名为k的结点的key
     */
    public Key select(int k){
        return select(root, k).key;
    }
    /**
     * 返回排名为k的结点
     * @param x 根节点
     * @param k 排名
     * @return
     */
    private Node select(Node x, int k){
        if(x == null){
            return null;
        }
        int t = size(x.left);//获取左子树的节点数
        if(t>k){//排名k的结点在左子树
            return select(x.left, k);
        }else if(t<k){
            //排名k的在右子树
            return select(x.right, k-t-1);
        } else{
            return x;
        }
    }

    /**
     * 返回给定键key的排名
     */
    public int rank(Key key){
        return rank(root, key);
    }
    /**
     * 在二叉排序树x上返回key的排名
     * @param x
     * @param key
     * @return
     */
    private int rank(Node x, Key key){
        if(x == null){
            return 0;
        }
        int cmp = key.compareTo(x.key);
        if(cmp < 0){
            //key键小于root的key,所以key在左子树中
            return rank(x.left, key);
        } else if(cmp>0){
            //key大于root的key,所以key在右子树中
            return 1+size(x.left)+rank(x.right, key);
        } else{
            return size(x.left);
        }
    }

    /**
     * 删除键值最小结点
     */
    public void deleteMin(){
        //删除root二叉查找树中的最小key的结点,其实也就是最左边的结点
        root = deleteMin(root);
    }
    /**
     * 删除键值最小结点
     * @param x
     * @return 返回新的二叉查找树的根节点
     */
    private Node deleteMin(Node x){
        if(x.left == null){
            return x.right;//删除根节点,这时返回的是新的二叉查找树的根节点
        }
        x.left = deleteMin(x.left);
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    /**
     * 删除:键值最大结点
     */
    public void deleteMax(){
        //删除root二叉查找树中的最小key的结点,其实也就是最左边的结点
        root = deleteMax(root);
    }
    /**
     * 删除
     * @param x
     * @return 返回新的二叉查找树的根节点
     */
    private Node deleteMax(Node x){
        if(x.right == null){//右子树为空
            return x.left;//删除根节点,这时返回的是新的二叉查找树的根节点
        }
        x.right = deleteMin(x.right);
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }


    /**
     * 删除键key结点.
     * @param key
     */
    public void delete(Key key){
        root = delete(root, key);
    }
    /**
     * 删除以x为根结点的二叉查找树的key键的结点
     * @param x
     * @param key
     * @return 新的二叉查找树的根节点
     */
    private Node delete(Node x, Key key){
        if( x == null ){
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            x.left = delete(x.left, key);
        } else if(cmp > 0){
            x.right = delete(x.right, key);
        } else {//这时删除根节点x
            if(x.left == null){
                return x.right;
            }
            if(x.right == null){
                return x.left;
            }
            //根节点有左右子树
            Node t = x;
            //1. 先求出x的右子树中最小键值的结点并让x指向它.
            x = min(t.right);
            //2. 将t的右子树删除最小的结点之后的根节点返回
            x.right = deleteMin(t.right);
            //3. 将t的左子树给x的左子树
            x.left = t.right;
        }
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    /**
     * 范围查找
     */
    public Iterator<Key> keys(){
        return keys(min(), max());
    }

    public Iterator<Key> keys(Key lo, Key hi){
        Queue<Key> queue = new Queue<Key>();
        keys(root, queue, lo, hi);
        return queue.iterator();
    }

    private void keys(Node x, Queue<Key> queue, Key lo, Key hi){
        if(x == null){
            return;
        }
        int cmplo = lo.compareTo(x.key);
        int cmphi = hi.compareTo(x.key);
        if(cmplo < 0){
            keys(x.left, queue, lo, hi);
        }
        if(cmplo <=0 && cmphi>=0){
            queue.enqueue(x.key);
        }
        if(cmphi > 0){
            keys(x.right, queue, lo, hi);
        }
    }

}

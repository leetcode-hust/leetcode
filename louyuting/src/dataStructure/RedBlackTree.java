package dataStructure;

/**
 * Created by louyuting on 17/1/9.
 * 红黑树
 */
public class RedBlackTree <Key extends Comparable<Key>, Value>{

    private static final boolean RED = true;
    private static final boolean BLACK = false;
    private Node root;//二叉查找树的根节点

    private class Node{
        private Key key;//键
        private Value value;//值
        private Node left, right;//指向子树的链接:左子树和右子树.
        private int N;//以该节点为根的子树中的结点总数
        boolean color;//由其父结点指向它的链接的颜色.

        public Node(Key key, Value value, int N, boolean color) {
            this.key = key;
            this.value = value;
            this.N = N;
            this.color = color;
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
    private boolean isRed(Node x){
        if(x == null){
            return false;
        }
        return x.color == RED;
    }

    /**
     * 左旋转
     * @param h
     * @return
     */
    private Node rotateLeft(Node h){
        Node x = h.right;
        h.right = x.left;
        x.left = h;

        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = 1+ size(h.left) + size(h.right);

        return x;
    }

    /**
     * 右旋转
     * @param h
     * @return
     */
    private Node rotateRight(Node h){
        Node x = h.left;
        h.left = x.right;
        x.right = h;

        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = 1+ size(h.left) + size(h.right);
        return x;
    }

    /**
     * 颜色转换
     * @param h
     */
    private void flipColors(Node h){
        h.color = RED;//父结点颜色变红
        h.left.color = BLACK;//子结点颜色变黑
        h.right.color = BLACK;//子结点颜色变黑
    }


    /**
     * 插入操作
     * @param key
     * @param value
     */
    public void put(Key key, Value value){
        //查找key, 找到则更新其值,否则为它新建一个结点
        root = put(root, key, value);
        root.color = BLACK;
    }

    private Node put(Node h, Key key, Value value){
        if( h == null){//标准的插入操作,和父结点用红链接相连
            return new Node(key, value, 1, RED);
        }

        int cmp = key.compareTo(h.key);
        if(cmp<0){
            h.left = put(h.left, key, value);
        } else if(cmp>0){
            h.right = put(h.right, key, value);
        } else{
            h.value = value;
        }
        
        if(isRed(h.right) && !isRed(h.left)){
            h = rotateLeft(h);//左旋转
        }
        if(isRed(h.left) && !isRed(h.right)){
            h = rotateRight(h);//右旋转
        }
        if(isRed(h.right) && isRed(h.left)){
            flipColors(h);//颜色转换
        }

        h.N = size(h.left) + size(h.right) + 1;
        return h;
    }

}

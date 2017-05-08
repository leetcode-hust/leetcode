package algorithm.meituan;

/**
 * Created by louyuting on 2017/3/9.
 */
public class Main {

    public static class Node{

        public Node(Integer value) {
            this.value = value;
            this.next = null;
        }

        public Node(Integer value, Node next) {
            this.value = value;
            this.next = next;
        }

        public Integer value;

        public Node next;
    }

    //链表的头结点
    private Node head;

    //在链表尾加入新元素
    public Node addLast(Integer num){

        if(head == null){
            head = new Node(num);
            return head;
        } else {
            Node p = head;
            //找到结点尾
            while (p.next != null){
                p = p.next;
            }
            //插入在尾结点
            Node node = new Node(num);
            p.next = node;
            return head;
        }
    }

    //在指定索引号位置加入新元素
    public Node addIndex(int index, Integer num){

        if(index < 0 ){
            try {
                throw new Exception("参数不合法");
            } catch (Exception e) {
                e.printStackTrace();
            }
            return head;
        }

        Node p = head;
        //index位置
        for(int i=0; i<=index; i++){
            if(p.next != null)
                p = p.next;
            else {
                try {
                    throw new Exception("参数不合法");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return head;
            }
        }
        //元素加载index后面
        Node node = new Node(num);
        node.next = p.next;
        p.next = node;
        return head;
    }

    //.删除指定索引号位置元素
    public Node deleteIndex(int index){

        if(index < 0 ){
            try {
                throw new Exception("参数不合法");
            } catch (Exception e) {
                e.printStackTrace();
            }
            return head;
        }

        Node p = head;
        //index位置
        for(int i=0; i<=index; i++){
            if(p.next != null)
                p = p.next;
            else {
                try {
                    throw new Exception("参数不合法");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return head;
            }
        }
        //删除index位置元素
        int value = p.next.value;//保存index后面元素值,删除index后面元素,然后将后面元素值放在index位置
        p.next = p.next.next;
        p.value = value;

        return head;
    }

    //打印当前链表(使用空格分隔)
    public void printList(){
        if(head == null)
            return;
        else {
            Node p = head;
            while (p.next != null){
                System.out.print(p.value + " ");
            }
        }
    }

    public static void main(String[] args) {

    }
}

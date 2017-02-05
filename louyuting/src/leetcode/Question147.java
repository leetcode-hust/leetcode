package leetcode;

import leetcode.common.ListNode;

/**
 * Created by louyuting on 17/2/5.
 */
public class Question147 {
    /**
     * 超时
     * @param head
     * @return
     */
    public static ListNode insertionSortList(ListNode head) {
        //空链表
        if(head == null){
            return null;
        }
        ListNode h = new ListNode(head.val);//h是新链表的头结点,
        ListNode hp = h;//hp是新链表的遍历指针

        ListNode p = head.next;// 原来链表的遍历指针

        //链表只有一个元素
        if(p == null){
            return head;
        }

        //链表元素多于两个.
        while (p != null){
            //将p 结点插入新链表中:

            //1. 新结点值小于头结点,将新节点插入在新链表的头部
            if( p.val< h.val ){
                ListNode temp = p;//保存当前的p
                //p后移
                p = p.next;
                temp.next = null;
                //新链表的头结点赋值给新节点的next
                temp.next = h;
                h = temp;
                hp = h;//hp归位
            } else {
            //2. 新结点值大于等于头结点, 按顺序插入

                ListNode hp_last= h;

                while(hp != null && p.val > hp.val ){
                    hp_last = hp;//保存hp的前结点
                    hp = hp.next;//新链表后移
                }
                //插入在hp_last的后面
                ListNode temp = new ListNode(p.val);
                p = p.next;
                temp.next=null;
                temp.next = hp;
                hp_last.next = temp;
                hp = h;//hp归位
            }
        }

        return h;
    }


    /**
     * 核心思想是在head前面构造一个helper结点
     * @param head
     * @return
     */
    public static ListNode insertionSortList2(ListNode head) {
        if( head == null ){
            return head;
        }

        ListNode helper = new ListNode(0); //构造一个结点, 该节点不算入实际的数据链表中,仅仅把其next指向最后的head
        ListNode cur = head; //将插入的结点
        ListNode pre = helper; //在pre和pre.next之间插入结点
        ListNode next = null; //下一个将被插入的结点

        //遍历原链表
        while( cur != null ){
            //保存下一个结点
            next = cur.next;

            //find the right place to insert
            while( pre.next != null && pre.next.val < cur.val ){
                pre = pre.next;
            }
            //将cur插入在pre 和 pre.next之间
            cur.next = pre.next;
            pre.next = cur;

            //pre归位helper
            pre = helper;
            //cur后移
            cur = next;
        }
        return helper.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(4);
        ListNode n3 = new ListNode(1);
        ListNode n4 = new ListNode(3);
        head.next = n1;
        n1.next = n2;
        n2.next=n3;
        n3.next=n4;

        ListNode h =  insertionSortList2(head);

        while (h!=null){
            System.out.print(h.val + ",");
            h = h.next;
        }

    }

}

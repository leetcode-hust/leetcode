package leetcode;

import leetcode.common.ListNode;

/**
 * Created by louyuting on 17/2/5.
 */
public class Question21 {

    /**
     *
     * @param l1 链表1的头结点
     * @param l2 链2的头结点
     * @return
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null ){
            return l2;
        }

        if(l2 == null){
            return l1;
        }

        if(l1==null && l2 == null){
            return null;
        }

        /** l1和l2均非空 */
        ListNode p1 = l1;
        ListNode p2 = l2;
        //先找出l1和l2的头结点中 较小的结点作为新链表的head
        ListNode head=null;
        if(l1.val<l2.val){
            head = l1;
            p1 = p1.next;
        }else {
            head = l2;
            p2 = p2.next;
        }
        //新链表的p指针
        ListNode p = head;

        //当p1和p2都不为空时
        while (p1!=null && p2 !=null){
            if(p1.val < p2.val){
                p.next = p1;
                p = p.next;//p指针后移
                p1 = p1.next;
            } else {
                p.next = p2;
                p = p.next;//p指针后移
                p2 = p2.next;
            }
        }

        if(p1 == null && p2 == null){
            return head;
        }else if(p1 == null && p2 != null){
            p.next = p2;
        }else if(p2 == null && p1 != null){
            p.next = p1;
        }

        return head;
    }


    public static void main(String[] args) {

    }

}

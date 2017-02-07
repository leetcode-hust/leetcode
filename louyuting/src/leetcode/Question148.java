package leetcode;

import leetcode.common.ListNode;

/**
 * Created by louyuting on 17/2/5.
 *
 * 二路归并 来对链表排序. 时间复杂度是O(nlogn)
 */
public class Question148 {
    /**
     * 合并两个有序链表
     * @param l1
     * @param l2
     * @return
     */
    private static ListNode merge(ListNode l1, ListNode l2) {
        ListNode l = new ListNode(0), p = l;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }

        if (l1 != null)
            p.next = l1;

        if (l2 != null)
            p.next = l2;

        return l.next;
    }

    /**
     * 链表的二路归并排序
     * @param head
     * @return
     */
    public static ListNode sortList(ListNode head) {
        //空链表或则只有一个结点,直接返回head
        if(head == null || head.next==null){
            return head;
        }

        //1. 将list 切分为两个部分
        ListNode prev=null, slow=head, fast=head;

        while (fast !=null && fast.next !=null){
            prev = slow;
            slow = slow.next;//slow指针后移一个数据
            fast = fast.next.next;//fast指针后移两个数据
        }

        prev.next = null;//将链表切断

        //分别排序前后两个部分
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);

        return merge(l1, l2);
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
        n3.next =n4;

        ListNode h =  sortList(head);

        while (h!=null){
            System.out.print(h.val + ",");
            h = h.next;
        }

    }

}

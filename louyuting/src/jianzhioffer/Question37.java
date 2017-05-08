package jianzhioffer;

import leetcode.common.ListNode;

/**
 * Created by louyuting on 2017/2/22.
 *
 * Question:
 */
public class Question37 {

    public static ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2){

        if(pHead1 == null || pHead2==null){
            return null;
        }

        ListNode p1=pHead1, p2=pHead2;

        //先统计 两个链表的长度
        int l1=0,l2=0;
        while (p1 != null){
            l1++;
            p1 = p1.next;
        }
        while (p2 != null){
            l2++;
            p2 = p2.next;
        }

        p1=pHead1;
        p2=pHead2;

        if(l1 > l2){
            int c = l1-l2;
            for(int i=0; i<c; i++)
                p1 = p1.next;
        }else {
            int c = l2-l1;
            for(int i=0; i<c; i++)
                p2 = p2.next;
        }

        while (p1!=null  && p2!= null){
            if(p1 == p2){
                return p1;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        return null;
    }


    public static void main(String[] args) {

    }
}

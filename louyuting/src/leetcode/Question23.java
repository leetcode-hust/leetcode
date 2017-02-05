package leetcode;

import leetcode.common.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 *
 */
public class Question23 {
    /**
     * 这是由Java的PriorityQueue来维护有序性.
     * @param lists 链表头结点数组
     * @return
     */
    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists==null || lists.length==0)
            return null;

        //队列中的元素是按照从小到大排序的
        PriorityQueue<ListNode> queue= new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>(){
            @Override
            public int compare(ListNode o1,ListNode o2){
                if (o1.val<o2.val)
                    return -1;
                else if (o1.val==o2.val)
                    return 0;
                else
                    return 1;
            }
        });

        //头结点
        ListNode dummy = new ListNode(0);
        ListNode tail=dummy;

        //将每个链表的头结点放入队列
        for (ListNode node:lists)
            if (node!=null)
                queue.add(node);

        while (!queue.isEmpty()){
            tail.next=queue.poll();//获取并移除此队列的头，如果此队列为空，则返回 null。
            tail=tail.next;

            if (tail.next!=null)
                queue.add(tail.next);
        }
        return dummy.next;
    }


    public static void main(String[] args) {

    }

}

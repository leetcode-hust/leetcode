package collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by louyuting on 17/1/6.
 */
public class ArrayListAndLinkedList {

    public static void main(String[] args) {

        List<String> arrayList = new ArrayList<String>();
        List<String> linkedList = new LinkedList<String>();

        for(long i=0; i<1000000; i++){
            arrayList.add(""+i);
            linkedList.add(""+i);
        }

/** 测试foreach循环 */
        long ayyaybefore = System.currentTimeMillis();
        for(String ii : arrayList){
        }
        long ayyayafter = System.currentTimeMillis();
        System.out.println("arraylist使用foreach遍历的时间是:"+(ayyayafter-ayyaybefore)+"ms");

        ayyaybefore = System.currentTimeMillis();
        for(String ii : linkedList){
        }
        ayyayafter = System.currentTimeMillis();
        System.out.println("linkedlist使用foreach遍历的时间是:"+(ayyayafter-ayyaybefore)+"ms");

/** 测试 iterator 循环 */
        Iterator aiterator = arrayList.iterator();
        ayyaybefore = System.currentTimeMillis();
        while (aiterator.hasNext()){
            aiterator.next();
        }
        ayyayafter = System.currentTimeMillis();
        System.out.println("arraylist使用iterator遍历的时间是:"+(ayyayafter-ayyaybefore)+"ms");

        Iterator literator = linkedList.iterator();
        ayyaybefore = System.currentTimeMillis();
        while (literator.hasNext()){
            literator.next();
        }
        ayyayafter = System.currentTimeMillis();
        System.out.println("linkedList使用iterator遍历的时间是:"+(ayyayafter-ayyaybefore)+"ms");

/** 测试for循环 */
        ayyaybefore = System.currentTimeMillis();
        for(int ii=0; ii<arrayList.size(); ii++){
            arrayList.get(ii);
        }
        ayyayafter = System.currentTimeMillis();
        System.out.println("arrayList使用for遍历的时间是:"+(ayyayafter-ayyaybefore)+"ms");

        ayyaybefore = System.currentTimeMillis();
        for(int ii=0; ii<linkedList.size(); ii++){
            linkedList.get(ii);
        }
        ayyayafter = System.currentTimeMillis();
        System.out.println("linkedlist使用for遍历的时间是:"+(ayyayafter-ayyaybefore)+"ms");

    }

}

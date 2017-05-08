package collection;

import java.util.TreeMap;

/**
 * Created by louyuting on 2017/2/15.
 */
public class TreeMapTest {


    public static void main(String[] args) {

        TreeMap<Integer, String> treeMap = new TreeMap<>();

        treeMap.put(4, "4");
        treeMap.put(5, "5");
        treeMap.put(1, "1");
        treeMap.put(18, "18");
        treeMap.put(9, "9");
        treeMap.put(21, "21");
        treeMap.put(11, "11");
        treeMap.put(12, "12");
        treeMap.put(22, "22");
        treeMap.put(29, "29");
        treeMap.put(50, "50");
        treeMap.put(33, "33");

        //int firstkey = treeMap.firstKey();
        //int last = treeMap.lastKey();
        int temp1=44;
        int temp2 = 90;
        func(temp1, treeMap);
        func(temp2, treeMap);


        System.out.println(treeMap.lastKey());
    }


    public static void func(int temp, TreeMap<Integer, String> treeMap){
        int max = treeMap.lastKey();//获取键的最大值

        if(max > temp){
            //删除max 插入temp
            treeMap.remove(max);
            treeMap.put(temp, String.valueOf(temp));
        }else{
            return;
        }
    }

}

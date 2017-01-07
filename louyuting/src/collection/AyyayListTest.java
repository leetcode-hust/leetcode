package collection;

import org.junit.Test;

import java.util.*;

/**
 * Created by louyuting on 16/12/20.
 */
public class AyyayListTest {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.set(5, 20);

        Iterator<Integer> it = list.iterator();
        while (it.hasNext()){
            Integer i = it.next();
            System.out.println(i);

        }
    }

    @Test
    public void testMap(){
        //无序
        Map<String, String> map = new HashMap<>();
        map.put("1","1");
        map.put("2","2");
        map.put("3","3");
        map.put("4","4");
        map.put("5","5");

        Set<Map.Entry<String,String>> set = map.entrySet();
        Iterator<Map.Entry<String,String>> it = set.iterator();

        while (it.hasNext()){
            System.out.println(it.next());
        }

    }

    @Test
    public void testMapLinked(){
        //有序
        Map<String, String> map = new LinkedHashMap<String,String>();
        map.put("1","1");
        map.put("2","2");
        map.put("3","3");
        map.put("4","4");
        map.put("5","5");

        Set<Map.Entry<String,String>> set = map.entrySet();
        Iterator<Map.Entry<String,String>> it = set.iterator();

        while (it.hasNext()){
            System.out.println(it.next());
        }

    }


}

package collection;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by louyuting on 17/1/6.
 */
public class CollectionsTest {


    public static void main(String[] args) {

        Map<String, String> map = new TreeMap<>();

        map.put("1","1");
        map.put("2","2");
        map.put("3","3");
        map.put("4","4");
        map.put("5","5");
        map.put("6","6");
        map.put("7","7");
        map.put("8","8");

        Collection<String> re = map.values();

        Iterator<String> it = re.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }

    }

}

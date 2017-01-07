package JVM;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by louyuting on 17/1/1.
 */
public class HeapOOM {

    public static void main(String[] args) {
        List<HeapOOM> list = new ArrayList<>();

        while (true){
            list.add(new HeapOOM());
        }
    }
}

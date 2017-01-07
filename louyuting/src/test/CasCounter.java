package test;

/**
 * Created by louyuting on 16/12/29.
 */
public class CasCounter {

    private SimulatedCAS value;

    public int getValue(){
        return value.get();
    }


    public int increment() {
        int v;
        do{
            v = value.get();//期望值
        }
        while( v!= value.compareAndSwap(v, v+1));//如果原值与期望值不同,就一直执行.

        return v+1;
    }


}

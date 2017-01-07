package test;

/**
 * Created by louyuting on 16/12/29.
 */
public class SimulatedCAS {

    private int value;

    public SimulatedCAS(int value) {
        this.value = value;
    }

    public synchronized int get(){
        return value;
    }

    public synchronized int compareAndSwap(int expectedValue, int newValue){
        int oldValue = value;//获取旧值
        if(oldValue == expectedValue){//如果期望值与当前V位置的值相同就给予新值
            value = newValue;
        }

        return oldValue;//返回V位置原有的值
    }

    public synchronized boolean compareAndSet(int expectedValue, int newValue){

        return ( expectedValue == compareAndSwap(expectedValue, newValue));
    }

    public static void main(String[] args) {
        SimulatedCAS cas = new SimulatedCAS(10);
        cas.compareAndSet(10, 20);

        System.out.print(cas.get());

    }
}

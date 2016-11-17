package mythread;

import java.math.BigInteger;

/**
 * Created by Administrator on 2016/11/2.
 */
public class ExpensiveFunction implements Computable<String, BigInteger>{
    @Override
    public BigInteger compute(String arg) throws InterruptedException {
        //经过长时间的计算后
        return new BigInteger(arg);
    }
}

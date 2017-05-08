package algorithm;

import java.util.TreeMap;

/**
 * Created by louyuting on 2017/2/16.
 */
public class Test {

    public static void main(String[] args) {
        int[] a = {-3, 1, 1, -3, 5};

        int[] ress = func(a);

        for(int iii=0; iii<ress.length; iii++){
            System.out.println(ress[iii]);
        }
    }

    /**
     * function
     * @param a
     * @return
     */
    public static int[] func(int[] a){

        //鲁棒性
        if(a == null || a.length==0){
            new Exception("数组格式异常");
            return null;
        }

        TreeMap<Integer, Node> sorted = new TreeMap<>();

        int n = a.length;

        for(int i=1; i<n; i++){//每轮的数据区间大小

            //i 表示每轮的数组区间大小
            for(int j=0; j<=a.length-i; j++){
                //求 a[j, j+i] 的和
                int sum=0;
                for(int k=j; k<=j+i-1;k++){
                    sum += a[k];
                }
                //存入Map
                sorted.put(sum, new Node(j, j+i-1));
            }
        }

        //获取最接近0的 key
        Node result;

        Integer lower = sorted.lowerKey(1);
        Integer higher = sorted.higherKey(0);

        int lowerabs = Math.abs(lower);
        int higherabs = Math.abs(higher);

        if(lowerabs<higherabs){
            result = sorted.get(lower);
        }else {
            result = sorted.get(higher);
        }

        int start = result.start;
        int end = result.end;

        int[] res = new int[end- start+1];
        int jj=0;
        for(int ii = start; ii<=end; ii++){
            res[jj++] = a[ii];
        }

        return res;
    }

    /**
     * 静态内部类
     */
    private static class Node{
        public Node(int end, int start) {
            this.end = end;
            this.start = start;
        }

        public int start;
        public int end;
    }


    @org.junit.Test
    public void test(){
        int i=0;

        i = i++;
        i = i++;

        System.out.println(i);

    }
}

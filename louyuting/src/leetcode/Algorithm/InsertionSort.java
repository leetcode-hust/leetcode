package leetcode.Algorithm;

/**
 * Created by louyuting on 17/2/6.
 * 直接插入排序
 */
public class InsertionSort {


    public static void insertSort1(int [] a, int n){
        int i, j;

        for(i =1; i<n; i++){//依次把a[1]到a[n-1]插入到前面
            //找到插入点
            for(j =0; j<i; j++){
                if(a[j] > a[i]){
                    break;//跳出内层循环
                }
            }

            /**将元素a[i]插入在a[j]位置*/
            int temp = a[i];//这里需要保存a[i], 不然下面的移动操作会覆盖掉a[i]的数据
            //将a[j]开始的元素后移
            for(int k=i-1; k>=j; k--){
                a[k+1] = a[k];
            }
            a[j] = temp;
        }
    }

    /**
     * 优化第一步:边比较和移动合并,这时候需要从大到小比较
     * @param a
     * @param n
     */
    public static void insertSort2(int [] a, int n){
        int i, j;

        for(i =1; i<n; i++){//依次把a[1]到a[n-1]插入到前面
            if(a[i] < a[i-1]){
                int temp = a[i];//这里需要保存a[i], 不然下面的移动操作会覆盖掉a[i]的数据
                //找到插入点
                for(j =i-1; j>=0 && a[j]>temp; j--){
                    a[j + 1] = a[j];
                }
                a[j+1] = temp;
            }
        }
    }

    public static void insertSort3(int [] a, int n){
        int i, j;

        for(i =1; i<n; i++) {//依次把a[1]到a[n-1]插入到前面

            for(j = i-1; j>=0 && a[j]>a[j+1]; j--){
                int temp;
                temp = a[j];
                a[j] = a[j+1];
                a[j+1]=temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,1,2,0,9,3,12, 7, 8, 3, 4, 65, 22};

        InsertionSort.insertSort3(arr, arr.length);

        for(int i:arr){
            System.out.print(i+",");
        }
    }



}

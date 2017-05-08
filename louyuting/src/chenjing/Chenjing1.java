package chenjing;


public class Chenjing1 {
    /**
     *
     * @param a
     * @return
     */
//    直接插入排序的核心思想就是：将数组中的所有元素依次跟前面已经排好的元素相比较，如果选择的元素比已排序的元素小，则交换，直到全部元素都比较过。
//    因此，从上面的描述中我们可以发现，直接插入排序可以用两个循环完成：
//
//    第一层循环：遍历待比较的所有数组元素
//    第二层循环：将本轮选择的元素(selected)与已经排好序的元素(ordered)相比较。
//    如果：selected > ordered，那么将二者交换
    public static int[] insertSort(int[] a){
        int count = a.length;

        for(int i=1;i<count;i++){
            for(int j=i-1;j>=0;j--){
                if(a[j+1]<a[j]){
                    int temp = a[j+1];
                    a[j+1] = a[j];
                    a[j] = temp;
                }
            }
        }


        return a;
    }

//    希尔排序的算法思想：将待排序数组按照步长gap进行分组，然后将每组的元素利用直接插入排序的方法进行排序；每次将gap折半减小，循环上述操作；当gap=1时，利用直接插入，完成排序。
//    同样的：从上面的描述中我们可以发现：希尔排序的总体实现应该由三个循环完成：
//
//    第一层循环：将gap依次折半，对序列进行分组，直到gap=1
//    第二、三层循环：也即直接插入排序所需要的两次循环。具体描述见上。
    public static int[] insertShell(int[] a){

        int count = a.length;
        int gap = count/2;
        while(gap>=1){
            for(int i=gap;i<count;i++){
                for(int j=i-gap;j-gap>=0;j-=gap){
                    if(a[j]<a[j-gap]){
                        int temp = a[j];
                        a[j] = a[j-gap];
                        a[j-gap] = temp;
                    }
                }
            }
            gap = gap/2;
        }
        return a;
    }

    public static int[] selectSort(int[] a){
        int count  = a.length;
        for(int i=0;i<count;i++){
            int min = a[i];
            for (int j=i+1;j<count;j++){
                if(a[j]<min){
                    int temp = a[j];
                    a[j] = min;
                    min = temp;
                }
            }
            a[i] = min;
        }
        return a;
    }


    public static void main(String[] args) {
        int[] test= {3,5,7,4,0,2,6,4,7};
        int[] sort = Chenjing1.selectSort(test);
        for(int x:sort){
            System.out.println(x);
        }
    }


}

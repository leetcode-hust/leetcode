package jianzhioffer;

/**
 * Created by louyuting on 2017/2/22.
 *
 * Question29: 数组中出现次数超过一半的数字
 */
public class Question29 {

    //解决方案一, 以牺牲空间换区时间, 用hash表存储每个值之后的hash值,统计重复命中的值是超过一半的, 时间复杂度是O(n), 空间复杂度也是O(n)
    //解决方案2,

    public static int MoreThanHalfNum_Solution(int [] array){
        if(array==null || array.length==0){
            return 0;
        }
        //i 表示遍历时的每个数字
        int i=array[0];
        int count=1;//记录次数,初始是1

        for(int j=1; j<array.length; j++){
            if(array[j] == i){
                count++;
                continue;
            }else {
                count--;
                //当到了最后一个元素时, 刚好是count从1减到0 就说明不存在.直接返回0
                if(j== array.length-1 && count==0){
                    return 0;
                }
                if(count==0){
                    i=array[j];
                    count=1;
                }
            }
        }
        return i;
    }


    public static void main(String[] args) {

    }
}

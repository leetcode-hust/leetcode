package leetcode;

/**
 * Created by louyuting on 17/2/5.
 */
public class Question88 {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        int index = m+n-1;//合并后最后一个元素的索引
        int ia = m-1;
        int ib = n-1;

        while(index >= 0){
            //num1已经遍历完了.将num2剩余数据存入num1中
            if(ia < 0){
                for(int i= ib; i>=0; i--){
                    nums1[index--] = nums2[ib--];
                }
                return;
            }
            //num2已经遍历完了.将num1剩余数据存入num1中
            if(ib < 0){
                //其实什么都不用做,直接return
                return;
            }

            //将较大的数字存储在最后.
            if(nums1[ia] > nums2[ib]){
                nums1[index--] = nums1[ia];
                ia--;
            }else {
                nums1[index--] = nums2[ib];
                ib--;
            }
        }
    }


    public static void main(String[] args) {
        int[] n1 = {1,2,3,4,5,6,7,8};
        int[] n2 = {2,3,4,7,9,11};

        Question88.merge(n1, n1.length, n2, n2.length);

        for(int i: n1){
            System.out.println(""+i);
        }
    }



}

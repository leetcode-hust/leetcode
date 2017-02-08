package leetcode;

/**
 * Created by louyuting on 17/2/8.
 */
public class Question34 {

    private static int[] result = new int[2];

    /**
     * 非递归方式查找
     * @param nums
     * @param target
     * @return 查找到的索引值
     */
    public static int[] binarySearch1(int[] nums, int target){
        int lo=0, hi=nums.length-1;

        int mid;//中间索引

        int[] re = new int[2];

        while (lo <= hi){
            mid = (lo+hi)/2;

            if(nums[mid] == target){
                //然后再当前mid的前后找
                int low , high;
                low = high = mid;
                while (low >=0 && nums[low] == nums[mid]){
                    low--;
                }
                while (high <=nums.length-1 && nums[high] == nums[mid]){
                    high++;
                }
                re[0] = low+1;
                re[1] = high-1;
                return re;
            } else if(nums[mid] < target){
                lo = mid+1;
            }else{
                hi = mid-1;
            }
        }
        re[0] = -1;
        re[1] = -1;
        return re;
    }

    /**
     * 递归方式查找
     * @param array
     * @param a
     * @return
     */
    public static int binarySearch2(int[] array, int a, int lo, int hi){
        if(lo <= hi){
            int mid = (lo+hi)/2 ;

            if( a == array[mid] ){
                return mid;
            } else if(a > array[mid]){
                return binarySearch2(array, a, mid+1, hi);
            } else {
                return binarySearch2(array, a, lo, mid-1);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 1, 2, 3, 3, 4, 7, 8, 9, 12, 22,65};

        result = Question34.binarySearch1(arr, 3);

        //result = Question34.binarySearch2(arr, 3, 0, (arr.length - 1));

        System.out.print(result[0] + " " + result[1]);
    }

}

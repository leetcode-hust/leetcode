package leetcode;

/**
 *
 * Created by louyuting on 17/2/8.
 *
 */
public class Question74 {


    /**
     * 先找列, 遍历. 找行用二分查找
     * @param matrix
     * @param target
     * @return
     */
    public static boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length==0 || matrix[0].length==0){
            return false;
        }

        int rows = matrix.length;//总行数
        int columns = matrix[0].length;//总列数
        int row=0;//比较的行数
        int i=0;
        //找到比较行
        for(i=0; i<rows; i++){
            if( (matrix[i][0] <= target) && (i < rows-1) && (matrix[i+1][0] > target)){
                row = i;
                break;
            }
            if( (matrix[i][0] <= target) && ( i == rows-1)){
                row = i;
                break;
            }
        }

        //二分查找找到对应的位置,找不到返回false
        int lo=0, hi=matrix[row].length-1;
        int mid;//中间索引

        while (lo <= hi){
            mid = (lo+hi)/2;

            if(matrix[row][mid] == target){
                return true;
            } else if(matrix[row][mid] < target){
                lo = mid+1;
            }else{
                hi = mid-1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] arr = {
                {0, 1, 2, 3},
                {4, 7, 8, 9},
                {12, 22, 65,77}
        };
        int[][] arr1 ={{}};

        System.out.print(Question74.searchMatrix(arr1, 3));
    }

}

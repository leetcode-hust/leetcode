package algorithm;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by louyuting on 2017/2/17.
 */
public class Test1 {

    /**
     * 内部静类用于保存 数组序列中的前 i 项的和是sum
     */
    public static class Node{
        int sum;//前n项的和
        int index;

        public Node(int index, int sum){
            this.index = index;
            this.sum = sum;
        }
    }

    /**
     * 解决方案:
     * @param nums
     * @return
     */
    public static int[] subArrayMin(int[] nums){
        //1. 首先求出从0 到 i 的和sum[i];
        //2. 然后对sum[]进行排序,
        //3. 找出有序的sum[] 中相邻最小的差值的Node
        //4. 求出结果

        //鲁棒性
        if(nums==null || nums.length==0){
            return new int[]{0, 0};
        }

        //创建nums.length + 1 个元素的数组, 分别保存前0到前n 个元素的和
        Node[] nSum = new Node[nums.length+1];
        nSum[0] = new Node(0, 0);//前0项的和是0
        int preSum=0;//保存i-1想的和,计算优化使用.

        //保存前1到前n项的和
        for(int i=0; i<nums.length; i++){
            nSum[i+1] = new Node(i+1, preSum + nums[i]);
            preSum = nSum[i+1].sum;
        }
        //保存最近进0的数据
        int closest = Integer.MAX_VALUE;

        //将sum进行排序
        Arrays.sort(nSum, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.sum-o2.sum;
            }
        });

        //保存下标结果
        int[] result = new int[2];

        //找出有序的sum[] 中相邻最小的差值的Node, 这里的差值肯定是非负的.
        for (int i = 1; i < nSum.length; i++){
            if (closest > (nSum[i].sum - nSum[i - 1].sum)){
                closest = nSum[i].sum - nSum[i - 1].sum;

                int[] temp = new int[]{nSum[i].index - 1,  nSum[i - 1].index - 1};
                Arrays.sort(temp);
                result[0] = temp[0] + 1;
                result[1] = temp[1];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] ss = {-3, 1, 1, -3, 5};

        int[] res = subArrayMin(ss);

        System.out.println(res[0] + "  " +res[1]);
    }



}

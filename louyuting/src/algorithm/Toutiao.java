package algorithm;

/**
 * Created by louyuting on 2017/2/23.
 */
public class Toutiao {


    /**
     * 将一个整形字符串转换成数据
     *  int类型最大数据是 2147483647 长度是10
     * @param str
     * @return 如果字符串为null 或则 "" 就返回 null
     */
    public static Integer stringToInt(String str){

        if(str == null || str.length() == 0)
            return null;

        //根据整数的范围,判断是否
        char[] nums = str.toCharArray();

        //首先判断字符串的合法性, 字符串必须只能是数字 0-9 和表示负数的-
        for(int i=0; i<nums.length; i++){
            //如果字符不属于 合法字符,抛出异常,返回
            if( !((nums[i] > '0' && nums[i] < '9') || nums[i]=='-') ){
                new Exception("字符串不合法");
                return null;
            }
        }

        Integer result = 0;
        if(nums[0] == '-'){
            //判断字符长度的合法性 整数是10位, 负数是11位
            if(nums.length>11){
                new Exception("超过负数表示最大值");
                return null;
            }else {
                //生成负数
                //1. 获取数字长度
                int length =  nums.length-2;

                for(int i=1; i<nums.length; i++){
                    result += (nums[i]-'0') * tenPow(length);
                    length--;
                }
                return result.intValue();
            }
        }else{
            if(nums.length>10){
                new Exception("超过正数表示最大值");
                return null;
            }else{
                int length =  nums.length-1;

                //每位数字一次乘以对应的10的次方
                for(int i=1; i<nums.length; i++){
                    result += (nums[i]-'0') * tenPow(length);
                    length--;
                }
                return result;
            }
        }
    }

    //求10的len次方
    public static int tenPow(int len){
        int result = 1;

        while (len>0){
            result *= 10;
            len--;
        }

        return result;
    }






    public static void main(String[] args) {

    }

}

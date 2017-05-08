package jianzhioffer;

/**
 * Created by louyuting on 2017/2/20.
 * 面试题4-- 替换空格
 *      将字符串中每个空格替换成 %20 例如输入We are happy  就输出We%20are%20happy
 */
public class Question4 {

    /**
     * @param str
     * @return
     */
    public static String func(StringBuffer str){

        String str1 = str.toString();

        if(str1==null){
            return null;
        }else if(str1.length()==0)
            return "";

        char[] strc = str1.toCharArray();

        //1. 首先找到空格有多少个
        int count=0;
        for(int i = 0; i<strc.length; i++){
            if(strc[i] == ' '){
                count++;
            }
        }

        //2. 最后的数据是要后移 3*count;
        int j = strc.length-1+2*count;
        char[] res = new char[j+1];
        for(int i=strc.length-1; i>=0; i--){
            if(strc[i] == ' '){
                //将' '替换成 %20
                res[j--] = '0';
                res[j--] = '2';
                res[j--] = '%';
            }else{
                res[j--] = strc[i];
            }
        }


        return new String(res);
    }


    public static void main(String[] args) {


        String flag = func(new StringBuffer("we are happy"));
        System.out.println(flag);
    }
}

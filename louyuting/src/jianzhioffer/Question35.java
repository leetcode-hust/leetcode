package jianzhioffer;

import java.util.HashMap;

/**
 * Created by louyuting on 2017/2/22.
 *
 * Question: 第一个只出现一次的字符
 */
public class Question35 {

    //1. 思路一, 直接两轮迭代, 就可以找出来第一个只出现一次的字符, 时间复杂度是O(n^2), 不过肯定可以优化;

    //2. 优化我们一般从两个角度看, 一个是优化的算法, 一个就是空间换时间了, 空间换时间,首选哈希表.

    public static Character FirstNotRepeatingChar(String str){
        if(str == null || str.length() == 0){
            return null;
        }

        char[] chars = str.toCharArray();

        HashMap<Character, Integer> map = new HashMap();
        for(int i=0; i<chars.length; i++){
            //取出value 自加之后再放入.
            Integer count = map.get(chars[i]);
            if(count == null){
                count=1;
            }else {
                count++;
            }
            map.put(chars[i], count);
        }

        for(int i=0; i<map.size(); i++){
            int count = map.get(chars[i]);
            if(count == 1){
                return chars[i];
            }
        }
        return null;
    }


    public static void main(String[] args) {
        System.out.println(FirstNotRepeatingChar("anasnlkndalnffa"));
    }
}

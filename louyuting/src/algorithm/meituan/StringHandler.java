package algorithm.meituan;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by louyuting on 2017/2/15.
 * 对字符串的处理，分别统计出任意一个字符串中所出现的字符的个数
 *
 * 解决思路: 比如字符串"Phylogenetic community spatial structure has been increasingly used to make inferences about community assembly processes"
 *          统计这个字符串中出现过的字符的个数.
 *
 *          这里每个字符与该字符的个数是对应的,我们可直接通过Java的Map来实现, key使用 char, value使用Integer
 */
public class StringHandler {

    public static Map<Character, Integer> func(String str){

        //鲁棒性
        if(str == null || str.length()==0){
            return null;
        }

        Map<Character, Integer> map = new HashMap<>();

        //首先将字符串分解成 字符数组;
        char[] ss = str.toCharArray();

        for(int i=0; i<ss.length; i++){
            char c  = ss[i];
            Integer value = map.get(c);
            if(value == null){//当前key还不存在
                map.put(c, 1);
            }else {//当前key已经存在
                map.put(c, value+1);
            }
        }
        return map;
    }

    public static void main(String[] args) {
        Map map = func("Phylogenetic community spatial structure has been increasingly used to make inferences about community assembly");
        System.out.println(map);
    }
}


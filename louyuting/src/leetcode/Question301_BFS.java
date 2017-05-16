package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

import com.vr.po.SysBusiness;

import sun.tools.jstat.Literal;

/**
 * @author louyuting
 * @create 2017-05-13-上午10:40
 *
 * BFS 肯定是用队列
 *
 * 优化记录：
 *      1)字符串的拼接由 +  换成了 stringBuilder， 时间由2K毫秒标称了十量级的速度。
 *      2)用一个set 保存已经校验过的字符串，较少校验次数，大大提升速度。有数十毫秒级别到个位数毫秒级别。
 */
public class Question301_BFS {
    public List<String> removeInvalidParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        List<String> res = new LinkedList<>();//保存返回结果
        Set<String> visited = new HashSet<>();//保存已判断的结果
        Queue<String> queue = new LinkedList<>();// 队列实现 BFS
        if(s==null)
            return res;
        queue.add(s);
        visited.add(s);
        //BFS
        while (!queue.isEmpty()){
            int size = queue.size();// 获取某一层的宽度
            for(int i=0; i<size; i++){
                String str = queue.poll();//出队
                if ( isVaild(str) ){
                    //找到有效的了，直接遍历queue，然后return
                    res.add(str);
                    // 将剩余的当前宽度的字符串依次判断。
                    i++;
                    for(; i<size; i++){
                        String s2 = queue.poll();
                        if(isVaild(s2))
                            res.add(s2);
                    }
                    return res;
                } else {
                    for( int j=0; j<str.length(); j++){
                        if( j == 0 && !visited.contains(str.substring(1, str.length())) ){
                            visited.add(str.substring(1, str.length()));
                            queue.add(str.substring(1, str.length()));
                        }
                        else if (j== str.length()-1 && !visited.contains(str.substring(0, str.length()-1))){
                            visited.add(str.substring(0, str.length()-1));
                            queue.add(str.substring(0, str.length()-1));
                        }
                        else{
                            sb.append(str.substring(0, j)).append(str.substring(j+1, str.length()));
                            if(!visited.contains(sb.toString())){
                                queue.add(sb.toString());
                                visited.add(sb.toString());
                            }
                            sb.setLength(0);
                        }
                    }
                }
            }// end of for
            if(res.size()>0){
                return res;
            }
        }
        return res;
    }

    // 判断一个字符串是否是合法的符号
    private boolean isVaild(String str){
        int count = 0;
        // 如果字符串为空，或则字符串长度为1，肯定不是合法的字符串
        if( str == null ){
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '(') count++;
            if (c == ')' && count-- == 0) return false;
        }
        return count == 0;
    }

    /**
     * main test
     * @param args
     */
    public static void main(String[] args) {
        Question301_BFS q = new Question301_BFS();
        System.nanoTime();
        long start = System.currentTimeMillis();
        List<String> list = q.removeInvalidParentheses("()(((((()");
        long last = System.currentTimeMillis() - start;
        System.out.println("last:"+ last);

        for(String string : list){
            System.out.println(string);
        }
    }


}

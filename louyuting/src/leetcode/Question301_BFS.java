package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

import com.vr.po.SysBusiness;

/**
 * @author louyuting
 * @create 2017-05-13-上午10:40
 *
 * BFS 肯定是用队列
 */
public class Question301_BFS {

    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new LinkedList<>();//保存返回结果
        Set<String> set = new HashSet<>();//保存不重复的结果
        Queue<String> queue = new LinkedList<>();// 队列实现 BFS
        if(s==null)
            return res;
        queue.add(s);
        //BFS
        while (!queue.isEmpty()){
            int size = queue.size();// 获取某一层的宽度
            for(int i=0; i<size; i++){
                String str = queue.poll();//出队
                if ( isVaild(str) ){
                    //找到有效的了，直接遍历queue，然后return
                    set.add(str);
                    // 将剩余的当前宽度的字符串依次判断。
                    for(; i<size; i++){
                        String s2 = queue.poll();
                        if(isVaild(s2))
                            set.add(s2);
                    }
                    res.addAll(set);
                    return res;
                } else {
                    for( int j=0; j<str.length(); j++){
                        if(j == 0)
                            queue.add(str.substring(1, str.length()));
                        else if (j== str.length()-1)
                            queue.add(str.substring(0, str.length()-1));
                        else
                            queue.add(str.substring(0, j) + str.substring(j+1, str.length()));
                    }
                }
            }// end of for
            if(set.size()>0){
                res.addAll(set);
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
        for (char c : str.toCharArray()){
            if( c == '(' )
                count++;
            else if(c == ')')
                count--;
            if(count > (str.length()/2))
                return false;
            if(count < 0){
                return false;
            }
        }
        return count == 0;
    }

    public static void main(String[] args) {
        Question301_BFS q = new Question301_BFS();

        for(String string : q.removeInvalidParentheses("(a")){
            System.out.println(string);
        }
    }


}

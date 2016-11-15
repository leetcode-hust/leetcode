package leetcode;

import utils.InputUtil;
import utils.LogUtil;

/**
 * Created by louyuting on 16/11/15.
 * 344 - Reverse String
 * Write a function that takes a string as input and returns the string reversed.
 *
 * Example:
  Given s = "hello", return "olleh".
 */
public class Question344 {

    public static  String reverseString(String s) {

        char[] schar = new char[s.length()];
        char temp;
        schar = s.toCharArray();

        int i = 0;
        int j = s.length()-1;
        while (i<=j){
            temp = schar[i];
            schar[i] = schar[j];
            schar[j] = temp;
            i++;
            j--;
        }
        return new String(schar);
    }

    public static void main(String[] args) {

        String s = InputUtil.inputString("please input str:");

        String result = reverseString(s);

        LogUtil.log_debug(result);

    }
}

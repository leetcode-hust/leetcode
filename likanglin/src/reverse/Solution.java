package reverse;

public class Solution {
	public int reverse(int x) {  //还是忍不住看了解答,自己的思路往字符串方面想，题目没仔细读，但没想到这种方式哈，jdk自带的reverse方法
	    
	    String str = new StringBuilder(x+"").reverse().toString();      //reverse 方法将一个 Array 对象中的元素位置进行反转
	        if(!Character.isDigit(str.charAt(str.length()-1))){      //Character.isDigit方法判断指定字符是否是一个数字
	        	str = str.charAt(str.length()-1)+str.substring(0, str.length()-1);
	        }
	        long num = Long.parseLong(str);                            //单独解析是0的情况，注意理解Integer.MAX_VALUE和Integer.MIN_VALUE的值的范围
	        if(num > Integer.MAX_VALUE || num < Integer.MIN_VALUE)  
	        	return 0;
	        return Integer.parseInt(str);
	    }
}

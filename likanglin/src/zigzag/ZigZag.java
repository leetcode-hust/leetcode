package zigzag;
/**
 * @author ALKL
 * @description 
 * 2016/11/22
 * 刚开始入手，没明白题目交代的意思，通过discuss中查看别人的解法，才明白了其中的数学链式规则，以下为论坛中一位大神的解法
 * 3个公式：
 *  1 之字形行数为nRows,那么每次重复样出现前的间隔字符为zigSpan = nRows*2-2;
 *  2 第一行和最尾一行都是存放一个字符的，所以存储的字符为间隔为zigSpan的字符
 *  3 中间行是需要额外存储多一个字符的，存储的字符位置是： zigSpan + j - 2*i（其中i为行数，j为该行的字符位置）
 * 0123456789
 * 0   4   8
 * 1 3 5 7 9  //通过条件语句区分开中间行，单独考虑首行和尾行
 * 2   6
 */
public class ZigZag {
	public String convert(String s,int numRows){
		
		if (numRows <= 1) {
	        return s;  //刚开始忽略了numRows小于等于1的情况，参照了discuss里大神的解法
	    }
	    int n = s.length();
	    int zigSpan = 2 * numRows - 2;     
	    StringBuilder sb = new StringBuilder();
	    for (int i = 0; i < numRows; i++) {
	        for (int j = i; j < n; j += zigSpan) {
	    //append为字符拼接方法，而charAt为返回当前位置的字符
	            sb.append(s.charAt(j));
	            //注意区分首行和尾行的间隔数，中间行中，需要明白j表示的是该行的字符位置，从而，吗，明白中间行的运算规则，中间行的存储的字符位置：zigSpan + j- 2*i，此时zigspan为一确定的常数值
	            if (i != 0 && i != numRows - 1 && j + zigSpan - 2 * i < n) {
	                sb.append(s.charAt(j + zigSpan - 2 * i));  //首行和尾行作为一种情况，而中间行作为另外一种情况
	            }
	        }
	    }
	    return sb.toString();
		
		
		
	}

}

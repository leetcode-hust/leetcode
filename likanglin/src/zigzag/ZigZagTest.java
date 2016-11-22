package zigzag;

/**
 * @author ALKL
 * @description 
 */
public class ZigZagTest {
	public static void main(String[] args) {
		String str="0123456789";
		int numRows=4;
		String result;
		ZigZag zigzag= new ZigZag();
		result=zigzag.convert(str, numRows);
		System.out.println(result);	

	}
}

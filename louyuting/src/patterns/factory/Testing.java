package patterns.factory;

import java.io.IOException;
import java.util.Scanner;

public class Testing {

	public static void main(String[] args) throws IOException {
		double A = 0.0;
		double B = 0.0;
		//输入A和B
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		String read = null;
		if (scan.hasNextLine()){
			 read = scan.nextLine();
		}
		A = Double.parseDouble(read);
		System.out.println("A=" + A);
		
		if (scan.hasNextLine()){
			 read = scan.nextLine();
		}
		B = Double.parseDouble(read);
		System.out.println("B=" + B);
		//输入操作符
		System.out.println("请输入操作符：");
		char op;
		op = (char)System.in.read();
		
		//运算
		double result= 0.0;
		if(op == '+'){
			result = A+B;
		}else if (op == '-'){
			result = A-B;
		}else if (op == '*'){
			result = A*B;
		}else if (op == '/'){
			if(B != 0.0)
				result = A/B;
			else {
				try {
					throw new Exception("除数不能为0");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		System.out.println("结果是："+ result);
	}
}

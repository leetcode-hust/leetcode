package com.simplefactory;

/**
 * 客户端代码
 * @author Administrator
 *
 */
public class Client {
	
	public static void main(String[] args) {

		Operation operation = null;
		operation = SimpleFactory.createOperation("-");
		
		operation.numberA = 1.1;
		operation.numberB = 2.2;
		
		double result = operation.getResult();
		System.out.println(result);
	}

}

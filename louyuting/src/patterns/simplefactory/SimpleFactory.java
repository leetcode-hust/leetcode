package com.simplefactory;

/**
 * 简单工厂模式
 * @author Administrator
 */
public class SimpleFactory {
	
	public static Operation createOperation(String operstr) {
		Operation operation = null;
		int value = 0;
		
		if(operstr.equals("+"))
			value =1;
		else if(operstr.equals("-"))
			value = 2;
		else if(operstr.equals("*"))
			value = 3;
		else if(operstr.equals("/"))
			value = 4;
		
		switch (value) {
			case 1:
				operation = new OperationAdd();
				break;
			case 2:
				operation = new OperationSub();
				break;
			case 3:
				operation = new OperationMul();
				break;
			case 4:
				operation = new OperationDiv();
				break;
			default:
				break;
		}//end of switch
		
		return operation;
	}

}

package com.simplefactory;

public class OperationSub extends Operation{

	/**
	 * 重写计算方法
	 */
	@Override
	public double getResult() {
		double result = 0.0;
		result = numberA - numberB;
		return result;
	}
	
}

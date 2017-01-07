package com.strategy;


//打折收费子类
public class CashDiscount extends CashSuper {
	
	//打折的折率
	private double moneyDiscount = 1d;
	
	public CashDiscount(String moneyDiscount) {
		//将传入的折率字符串转换成数字
		this.moneyDiscount = Double.parseDouble(moneyDiscount);
	}
	
	@Override
	public double acceptCash(double money) {
		
		return money * moneyDiscount;
	}

}

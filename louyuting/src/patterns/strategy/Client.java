package com.strategy;

public class Client {
	
	
	public static void main(String[] args) {
		//打八折  正常收费
		String  type = "满300减100";
		double money = 666.6;
		CashSuper cs = CashFactory.createCashAccept(type);
		
		double result = cs.acceptCash(money);
		
		System.out.println(result);
	}
	
	
	
	
}

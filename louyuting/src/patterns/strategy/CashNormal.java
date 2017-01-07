package com.strategy;

//现金正常收取
public class CashNormal extends CashSuper{

	@Override
	public double acceptCash(double money) {
		
		return money;
	}

}

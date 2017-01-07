package com.strategy;

//现金收费工厂类
public class CashFactory {

	//现金收取工厂
	public static CashSuper createCashAccept(String type) {
		
		CashSuper cs = null;
		
		switch (type) 
		{
			case "正常收费":
				cs = new CashNormal();
				break;
				
			case "满300减100":
				cs = new CashReturn("300", "100");
				break;
				
			case "打八折":
				cs = new CashDiscount("0.8");
				break;
			default:
				cs = new CashNormal();
				break;
		}
		return cs;
	}
	
	
}

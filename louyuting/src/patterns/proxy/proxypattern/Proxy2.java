package com.proxy.proxypattern;

import com.proxy.SchoolGirl;

public class Proxy2 implements IgiveGift{
	Pursuit2 gg;//定义代理的对象
	
	public Proxy2(SchoolGirl mm) {
		this.gg = new Pursuit2(mm);
	}
	
	public void giveDolls() {
		gg.giveDolls();
	}
	
	public void giveFlowers() {
		gg.giveFlowers();
	}
	
	public void giveChocolate() {
		gg.giveChocolate();
	}
}

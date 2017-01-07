package com.proxy.noproxy;

import com.proxy.SchoolGirl;

/**
 * 这个类是没有代理实现的
 * @author Lou
 *
 */
public class Pursuit1 {
	SchoolGirl mm;//定义要追求的对象
	
	public Pursuit1() {
	}
	
	public Pursuit1(SchoolGirl mm) {
		this.mm = mm;
	}
	
	public void giveDolls() {
		System.out.println(mm.getName() + "：送你洋娃娃");
	}
	
	public void giveFlowers() {
		System.out.println(mm.getName() + "：送你鲜花");
	}
	
	public void giveChocolate() {
		System.out.println(mm.getName() + "：送你巧克力");
	}
	
}








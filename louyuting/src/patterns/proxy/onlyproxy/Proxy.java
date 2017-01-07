package com.proxy.onlyproxy;

import com.proxy.SchoolGirl;

public class Proxy {
	SchoolGirl mm;//定义要追求的对象
	
	public Proxy() {
	}
	
	public Proxy(SchoolGirl mm) {
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

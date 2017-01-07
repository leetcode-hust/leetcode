package com.proxy;

import org.junit.Test;

import com.proxy.noproxy.Pursuit1;
import com.proxy.onlyproxy.Proxy;
import com.proxy.proxypattern.Proxy2;

/**
 * 代理设计模式
 * @author Administrator
 *
 */
public class Client {
	
	//这个实例没有代理
	@Test
	public void test1() {
		
		SchoolGirl jj = new SchoolGirl();
		jj.setName("李娇娇");
		
		Pursuit1 zhangsan = new Pursuit1(jj);//娇娇并不认识张三，所以此处没有代理
		zhangsan.giveDolls();
		zhangsan.giveFlowers();
		zhangsan.giveChocolate();
	}
	
	
	//这个测试只有代理，而没有张三。
	@Test
	public void test2() {
		
		SchoolGirl jj = new SchoolGirl();
		jj.setName("李娇娇");
		
		Proxy daili = new Proxy(jj);//这里只有代理，就不存在张三了
		daili.giveDolls();
		daili.giveFlowers();
		daili.giveChocolate();
	}
	
	//这个测试代理模式
	@Test
	public void test3() {
		
		SchoolGirl jj = new SchoolGirl();
		jj.setName("李娇娇");
		
		Proxy2 daili = new Proxy2(jj);//这里只有代理，就不存在张三了
		daili.giveDolls();
		daili.giveFlowers();
		daili.giveChocolate();
	}
	
}

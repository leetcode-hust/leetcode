package com.Singleton;

import org.junit.Test;

public class Client {
	
	@Test
	public void test1() {
		
		//获取两个实例
		Singleton instance1= Singleton.getInstance();
		Singleton instance2= Singleton.getInstance();
		
		if(instance1 == instance2)
			System.out.println("两个引用指向一个地址，所以是一个实例");
		else
			System.out.println("两个引用指向不同地址，所以是二个实例");
	}
	//~~~~output：
	//两个引用指向一个地址，所以是一个实例
}

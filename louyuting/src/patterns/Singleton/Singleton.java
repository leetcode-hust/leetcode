package com.Singleton;

public class Singleton {
	
	private static Singleton instance;
	
	//内部私有的构造方法
	private Singleton() {
		
	}
	
	//静态方法获取实例
	public static Singleton getInstance() {
		
		if(instance == null) {
			instance = new Singleton();
		}
		
		return instance;
	}
}

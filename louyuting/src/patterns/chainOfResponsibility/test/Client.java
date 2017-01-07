package com.chainOfResponsibility.test;


//客户端
public class Client {
	public static void main(String[] args) {
		Handler h1 = new ConcreteHandler1("h1");
		Handler h2 = new ConcreteHandler2("h2");
		Handler h3 = new ConcreteHandler3("h3");
		
		h1.setSuccessor(h2);
		h2.setSuccessor(h3);
		
		int[] requests = {2,5,14,22,18,4,27,20,40};
		
		for (int request : requests) {
			h1.handleRequest(request);
		}
		
		System.out.println("over");
	}
}

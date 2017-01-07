package com.chainOfResponsibility.test;

public class ConcreteHandler3 extends Handler{
	private String handleName;
	
	public ConcreteHandler3() {
		super();
	}
	
	public ConcreteHandler3(String handleName) {
		super();
		this.handleName = handleName;
	}
	
	public String getHandleName() {
		return handleName;
	}

	public void setHandleName(String handleName) {
		this.handleName = handleName;
	}

	//request：请求参数
	@Override
	public void handleRequest(int request) {
		if(request >=20 && request<30){
			System.out.println(this.getHandleName() + " 处理请求："+ request);
		} else if(successor != null){
			successor.handleRequest(request);
		}
	}
	
}

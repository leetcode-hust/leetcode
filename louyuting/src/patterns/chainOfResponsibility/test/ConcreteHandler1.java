package com.chainOfResponsibility.test;

public class ConcreteHandler1 extends Handler{
	private String handleName;
	
	public ConcreteHandler1() {
		super();
	}
	
	public ConcreteHandler1(String handleName) {
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
		if(request >=0 && request<10){
			System.out.println(this.getHandleName() + " 处理请求："+ request);
		} else if(successor != null){
			successor.handleRequest(request);
		}
	}
	
}

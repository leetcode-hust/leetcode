package com.chainOfResponsibility.test;

//处理请求的接口
abstract class Handler {
	protected Handler successor;//继承者

	//设置继承者,successor代表继任者
	public void setSuccessor(Handler successor) {
		this.successor = successor;
	}
	//处理请求的抽象方法
	public abstract void handleRequest(int request);

}

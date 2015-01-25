package com.liuyu.EasyQueue.Exception;
//声明队列失败
public class DeclareQueueFailException extends Exception {
	private static final long serialVersionUID = 6327009025407919539L;
	public DeclareQueueFailException() {
		super();
	}
	public DeclareQueueFailException(String message) {
		super(message);
	}
	
}

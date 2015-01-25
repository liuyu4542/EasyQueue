package com.liuyu.EasyQueue.Exception;
/**消息服务器连接异常*/
public class BrokerConnectFailedException extends Exception {
	private static final long serialVersionUID = 5478226475434961522L;

	public BrokerConnectFailedException() {
		super();
	}
	public BrokerConnectFailedException(String message) {
		super(message);
	}
    
}

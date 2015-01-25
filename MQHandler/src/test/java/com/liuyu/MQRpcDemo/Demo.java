package com.liuyu.MQRpcDemo;
import java.util.HashMap;
import org.junit.Test;
import com.liuyu.MQRpcDemo.Factory.Adapter.JSONAdapter;
import com.liuyu.MQRpcDemo.MessageProducer.MessageProducer;
import com.liuyu.MQRpcDemo.MessageConsumer.MessageConsumer;
public class Demo {
	//@Test
	public void testSend(){
		HashMap<String,Object> map=new HashMap<String,Object>();
		map.put("id", "yyy");
		MessageProducer.sendMessage(JSONAdapter.parseHashMapType(map)); 
	}
	//@Test
	public void testRecv(){
		String str=MessageConsumer.recvMessage();
		System.out.println(str);
	}
}

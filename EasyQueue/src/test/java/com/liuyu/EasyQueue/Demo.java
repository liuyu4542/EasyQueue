package com.liuyu.EasyQueue;
import java.util.HashMap;
import org.junit.Test;
import com.liuyu.EasyQueue.Adapter.JSONAdapter;
import com.liuyu.EasyQueue.MessageProducer.MessageProducer;
import com.liuyu.EasyQueue.MessageCunsumer.MessageConsumer;
public class Demo {
	@Test
	public void testSend(){
		HashMap<String,Object> map=new HashMap<String,Object>();
		map.put("id", "67");
		map.put("name", "sss");
		MessageProducer.sendMessage(JSONAdapter.parseHashMapType(map));
	}
	//@Test
	public void testRecv(){
		String str=MessageConsumer.recvMessage();
		System.out.println(str);
	}
}

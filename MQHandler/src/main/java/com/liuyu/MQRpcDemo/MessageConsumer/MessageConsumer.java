package com.liuyu.MQRpcDemo.MessageConsumer;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.liuyu.MQRpcDemo.Factory.AMQPFactory;
import com.liuyu.service.HelloServiceI;
public class MessageConsumer {
	@Autowired
	private HelloServiceI service;
	@SuppressWarnings("resource")
	public void recvMessage() {
		ApplicationContext context = new AnnotationConfigApplicationContext(AMQPFactory.class);
		AmqpTemplate amqpTemplate = context.getBean(AmqpTemplate.class);
		String str=amqpTemplate.receiveAndConvert().toString();
	}
}

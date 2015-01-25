package com.liuyu.MQRpcDemo.MessageProducer;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.liuyu.MQRpcDemo.Factory.AMQPFactory;
/**消息发送*/
public class MessageProducer {
	@SuppressWarnings("resource")
	public static void sendMessage(String message){
		ApplicationContext context = new AnnotationConfigApplicationContext(AMQPFactory.class);
		AmqpTemplate amqpTemplate = context.getBean(AmqpTemplate.class);
		amqpTemplate.convertAndSend(message);
	}
}

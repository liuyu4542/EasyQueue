package com.liuyu.MQRpcDemo.MessageConsumer;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.liuyu.MQRpcDemo.Factory.AMQPFactory;
public class MessageConsumer {
	@SuppressWarnings("resource")
	public void recvMessage() {
		ApplicationContext context = new AnnotationConfigApplicationContext(AMQPFactory.class);
		AmqpTemplate amqpTemplate = context.getBean(AmqpTemplate.class);
		String str=amqpTemplate.receiveAndConvert().toString();
	}
}

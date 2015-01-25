package com.liuyu.EasyQueue.MessageCunsumer;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.liuyu.EasyQueue.Config.client.RabbitClientConfiguration;
public class MessageConsumer {
	@SuppressWarnings("resource")
	public static String recvMessage() {
		ApplicationContext context = new AnnotationConfigApplicationContext(RabbitClientConfiguration.class);
		AmqpTemplate amqpTemplate = context.getBean(AmqpTemplate.class);
		return amqpTemplate.receive().toString();
	}
}

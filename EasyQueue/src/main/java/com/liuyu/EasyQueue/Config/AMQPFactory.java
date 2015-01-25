package com.liuyu.EasyQueue.Config;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class AMQPFactory {
	protected static String DATA_EXCHANGE_NAME = "demo.queue";
	protected static String REQUEST_QUEUE_NAME = "demo.queue";
	protected static String REQUEST_ROUTING_KEY = "demo.queue";
	/**消息服务器连接配置*/
	@Bean
	public ConnectionFactory connectionFactory() {
		CachingConnectionFactory connectionFactory = new CachingConnectionFactory("10.160.29.7",5672);
		connectionFactory.setUsername("liuyu");
		connectionFactory.setPassword("33@6a+");
		return connectionFactory;
	}
	/**委托配置*/
	@Bean
	public AmqpAdmin amqpAdmin() {
		return new RabbitAdmin(connectionFactory());
	}
	/**模板配置*/
	@Bean
	public RabbitTemplate rabbitTemplate() {
		RabbitTemplate template = new RabbitTemplate(connectionFactory());
		template.setRoutingKey(REQUEST_ROUTING_KEY);
		template.setQueue(REQUEST_QUEUE_NAME);
		return template;
	}
	/**获取队列*/
	@Bean
	public Queue getQueue() {
		return new Queue(REQUEST_QUEUE_NAME);
	}
	@Bean 
	public SimpleMessageListenerContainer messageListenerContainer() {
		SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(connectionFactory());		
		container.setQueueNames(REQUEST_QUEUE_NAME);
		container.setMessageListener(messageListenerAdapter());
		return container;
	}
	@Bean 
	public MessageListenerAdapter messageListenerAdapter() {
	    Object listener = new Object() {
			@SuppressWarnings("unused")
			public void handleMessage(String message) {
	        	System.out.println(message);
	        }
	    };
	    MessageListenerAdapter adapter = new MessageListenerAdapter(listener);
		return adapter;
	}
}

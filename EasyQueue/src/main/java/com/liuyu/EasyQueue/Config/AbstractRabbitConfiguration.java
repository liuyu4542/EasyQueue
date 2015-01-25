package com.liuyu.EasyQueue.Config;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public abstract class AbstractRabbitConfiguration {
	protected static String DATA_EXCHANGE_NAME = "hello.world.queue";
	protected static String REQUEST_QUEUE_NAME = "hello.world.queue";
	protected static String REQUEST_ROUTING_KEY = REQUEST_QUEUE_NAME;
	@Bean
	public ConnectionFactory connectionFactory() {
		CachingConnectionFactory connectionFactory = new CachingConnectionFactory("10.160.29.7");
		connectionFactory.setUsername("liuyu");
		connectionFactory.setPassword("33@6a+");
		connectionFactory.setPort(5672);
		return connectionFactory;
	}

	/**模板配置*/
	@Bean
	public RabbitTemplate rabbitTemplate() {
		RabbitTemplate template = new RabbitTemplate(connectionFactory());
		template.setRoutingKey(REQUEST_ROUTING_KEY);
		template.setQueue(REQUEST_QUEUE_NAME);
		return template;
	}
	/**委托配置*/
	@Bean
	public AmqpAdmin amqpAdmin() {
		RabbitAdmin rabbitAdmin = new RabbitAdmin(connectionFactory());
		return rabbitAdmin ;
	}
	@Bean
	public TopicExchange setDataExchange() {
		return new TopicExchange(DATA_EXCHANGE_NAME);
	}
}

package com.liuyu.MQRpcDemo.Factory;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.liuyu.MQRpcDemo.Const.AMQPConfig;
@Configuration
public class AMQPFactory {
	/**消息服务器连接配置*/
	@Bean
	public ConnectionFactory connectionFactory() {
		CachingConnectionFactory connectionFactory = new CachingConnectionFactory(AMQPConfig.QUEUE_NAME,AMQPConfig.PORT);
		connectionFactory.setUsername(AMQPConfig.USER_NAME);
		connectionFactory.setPassword(AMQPConfig.PASSWD);
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
		template.setRoutingKey(AMQPConfig.QUEUE_NAME);
		template.setQueue(AMQPConfig.QUEUE_NAME);
		return template;
	}
	/**获取队列*/
	@Bean
	public Queue getQueue() {
		return new Queue(AMQPConfig.QUEUE_NAME);
	}
	/**获取转发器*/
	@Bean
	public TopicExchange getTopicExchange() {
		return new TopicExchange(AMQPConfig.EXCHANGE_NAME);
	}
}

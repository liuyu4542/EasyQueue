package com.liuyu.EasyQueue.Config.client;
import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.liuyu.EasyQueue.Config.AbstractRabbitConfiguration;
@Configuration
public class RabbitClientConfiguration extends AbstractRabbitConfiguration {
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
	@Bean
	public AmqpAdmin rabbitAdmin() {
		return new RabbitAdmin(connectionFactory());
	}
	@Bean
	public Queue getRequestQueue() {		
		return new Queue(REQUEST_QUEUE_NAME);	
	}
	@Bean
	public Binding marketDataBinding() {		
		return BindingBuilder.bind(getRequestQueue()).to(setDataExchange()).with(REQUEST_ROUTING_KEY);
	}
}

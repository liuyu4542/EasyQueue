package com.liuyu.EasyQueue.Config.server;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.liuyu.EasyQueue.Config.AbstractRabbitConfiguration;
@Configuration
public class RabbitServerConfiguration extends AbstractRabbitConfiguration  {
	@Bean
	public Queue getRequestQueue() {		
		return new Queue(REQUEST_QUEUE_NAME);	
	}

}

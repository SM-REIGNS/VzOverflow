package com.verizon.lambda.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class Config {

	@Bean
	Queue queue() {
		return new Queue("userManagerQueue",true);
	}



	@Bean
	DirectExchange exchange() {
		return new DirectExchange("competencyPortalExchange");
	}

	@Bean
	Binding binding(Queue queue,DirectExchange exchange) {
		return BindingBuilder.bind(queue).to(exchange).with("userManagerKey");
	}

}

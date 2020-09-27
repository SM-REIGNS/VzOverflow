package com.verizon.lambda.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class Config2 {

	@Bean
	Queue queue2() {
		return new Queue("invitationsQueue",true);
	}


	@Bean
	Binding binding2(Queue queue2,DirectExchange exchange) {
		return BindingBuilder.bind(queue2).to(exchange).with("invitationKey");
	}
}

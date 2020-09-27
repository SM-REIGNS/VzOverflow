package com.verizon.competency.notificationservice.config;


import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.core.Queue;

@Configuration
public class AMQPConfiguration {

    private String queueName="notificationServiceQueue";

    private String exchange="competencyPortalExchange";

    private static String routingKey="notificationServiceKey";

    public static void setRoutingKey(String routingKey1) {
        routingKey = routingKey1;
    }

    @Bean
    Queue queue() {
        return new Queue(queueName,true);
    }

    @Bean
    DirectExchange exchange() {
        return new DirectExchange(exchange);
    }

    @Bean
    Binding binding(Queue queue, DirectExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(routingKey);
    }

}

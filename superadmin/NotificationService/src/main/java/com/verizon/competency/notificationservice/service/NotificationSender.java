package com.verizon.competency.notificationservice.service;

import com.verizon.competency.notificationservice.NotificationserviceApplication;
import com.verizon.competency.notificationservice.config.AMQPConfiguration;
import com.verizon.competency.notificationservice.model.Notification;
import com.verizon.competency.notificationservice.model.Users;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;



    private String exchange="competencyPortalExchange";


//    public void send(Notification notificationDetails) {
//
//        rabbitTemplate.convertAndSend(exchange,notificationDetails.getRoutingKey(),notificationDetails.getMessage());
//        System.out.println("Message sent successfully to "+notificationDetails.getRoutingKey());
//    }

}

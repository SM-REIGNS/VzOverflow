package com.verizon.competency.notificationservice.service;


import com.google.gson.Gson;
import com.verizon.competency.notificationservice.model.InviteBody;
import com.verizon.competency.notificationservice.model.ResetPasswordBody;
import com.verizon.competency.notificationservice.model.ResetPasswordRequest;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;

@Service
public class NotificationReceiver {
    @Autowired
    IEmailService emailServiceImpl;

    @Autowired
    AmqpTemplate rabbitTemplate;

    @Autowired
    DirectExchange directExchange;

    @RabbitListener(queues = "invitationsQueue")
    public void handleInvitationRequest(Message message) throws MessagingException {
        byte[] data = message.getBody();
//        Notification notification = new Notification(data);
        String messageElements = new String(data);

        System.out.println("Received Message is : "+messageElements);
        Gson gson = new Gson();
        System.out.println("helooooo------------");
        InviteBody inviteBody = gson.fromJson(messageElements,InviteBody.class);
        System.out.println(inviteBody.getEmail()+" "+inviteBody.getPassword()+" "+inviteBody.getFirstName());

        emailServiceImpl.sendEmailInvitation(inviteBody);


//        return inviteBody;
    }

    @RabbitListener(queues = "userManagerQueue")
    public void receivePasswordResetRequest(Message message) throws MessagingException{
        byte[] data = message.getBody();
//        Notification notification = new Notification(data);
        String messageElements = new String(data);

        System.out.println("Received Message is : "+messageElements);

        Gson gson = new Gson();
        System.out.println("helooooo------------");
        ResetPasswordRequest resetPasswordRequest = gson.fromJson(messageElements,ResetPasswordRequest.class);
        System.out.println(resetPasswordRequest.getEmail()+" "+resetPasswordRequest.getToken());
        rabbitTemplate.convertAndSend(directExchange.getName(),"notificationServiceKey",resetPasswordRequest.getToken());
        emailServiceImpl.sendEmailPasswordReset(resetPasswordRequest);

//        return resetPasswordBody;
    }
}

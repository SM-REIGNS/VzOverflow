package com.verizon.competency.notificationservice.controller;


import com.verizon.competency.notificationservice.model.Notification;
import com.verizon.competency.notificationservice.service.EmailServiceImpl;
import com.verizon.competency.notificationservice.service.NotificationReceiver;
import com.verizon.competency.notificationservice.service.NotificationSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AMQPWebController {
    @Autowired
    NotificationSender sender;

    @Autowired
    NotificationReceiver receiver;

    @Autowired
    EmailServiceImpl emailServiceImpl;


//    @PostMapping(value = "/sendnotification")
//    public String sendNotification(@RequestBody Notification notification) {
//        sender.send(notification);
//        return "Message sent successfully.";
//
//    }

//    @GetMapping(value = "/receivenotification")
//    public String receiveNotification() throws MessagingException {
//        Message message = null;
//        String received= receiver.receiveInvitationRequest(message);
//        System.out.println("Message"+received+" successfully");
//
////        InviteBody inviteBody ;
//        Gson gson = new Gson();
//        System.out.println("helooooo------------");
//        InviteBody inviteBody = gson.fromJson(received,InviteBody.class);
//        System.out.println(inviteBody.getEmail()+" "+inviteBody.getPassword()+" "+inviteBody.getFirstName());
//        emailServiceImpl.sendEmailInvitation(inviteBody);
//        return "mail sent successfully";
//    }
}

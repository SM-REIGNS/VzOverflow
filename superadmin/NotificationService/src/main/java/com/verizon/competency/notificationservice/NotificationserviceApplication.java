package com.verizon.competency.notificationservice;

import com.verizon.competency.notificationservice.model.Address;
import com.verizon.competency.notificationservice.model.Contact;
import com.verizon.competency.notificationservice.model.Notification;
import com.verizon.competency.notificationservice.model.Users;
import com.verizon.competency.notificationservice.service.NotificationReceiver;
import com.verizon.competency.notificationservice.service.NotificationSender;
import com.verizon.competency.notificationservice.service.UserServiceInterface;
import org.springframework.amqp.rabbit.core.RabbitMessageOperations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories("com.verizon")
public class NotificationserviceApplication {



	public static void main(String[] args) {

		ConfigurableApplicationContext context = SpringApplication.run(NotificationserviceApplication.class);

//		UserServiceInterface userService = context.getBean(UserServiceInterface.class);
//
		Notification notification = new Notification("userManagerKey","Hello Receiver");
//
		NotificationSender sender = context.getBean(NotificationSender.class);
		NotificationReceiver receiver = context.getBean(NotificationReceiver.class);

//
//		sender.send(notification);

//		Users user = userService.findUserById("2633290");
//
//		System.out.println("User : "+user);
	}

}

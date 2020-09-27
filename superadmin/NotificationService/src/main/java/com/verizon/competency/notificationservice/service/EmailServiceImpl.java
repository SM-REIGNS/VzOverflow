package com.verizon.competency.notificationservice.service;


import com.verizon.competency.notificationservice.model.InviteBody;
import com.verizon.competency.notificationservice.model.ResetPasswordBody;
import com.verizon.competency.notificationservice.model.ResetPasswordRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;


@Service
public class EmailServiceImpl implements IEmailService{
	
	/*
	@Autowired
	private RabbitTemplate template;
	@Autowired
	private DirectExchange directExchange;
	*/
	@Autowired
	private JavaMailSender sender;

	@Autowired
	private IEmailService emailService;

	
	//Message message=template.receive("directQueue");
	
//	String f="abhishek";
//	String email=;
//	String token="abcddd";

		
	
	

	
	
//	public void sendEmailPasswordReset() throws MessagingException {
//
//
//		MimeMessage msg = sender.createMimeMessage();
//		MimeMessageHelper helper=new MimeMessageHelper(msg,true);
//		helper.setTo(email);
//		helper.setSubject("Regarding password reset request");
//		helper.setText("<html>"
//				+ "<h1>Password Reset Request</h1>"
//				+"<p>Hi</p>"+f
//				+"<p>You have requested a password reset.If it was you please click on the link ,if not report immediately.</p>"
//				+"<a href=www.google.com?token="+token+">Click me</a>"
//				+ "</html>"
//				,
//
//				true);
//		sender.send(msg);
//	}

	@Override
	public void sendEmailInvitation(InviteBody inviteBody) throws MessagingException {


		MimeMessage msg = sender.createMimeMessage();
		MimeMessageHelper helper=new MimeMessageHelper(msg,true);
		helper.setTo(inviteBody.getEmail());
		helper.setSubject("Welcome to VzOverflow");
		helper.setText("<html>"
						+ "<h1>Account Activation Request</h1>"
						+"<p>Hi"+inviteBody.getFirstName()+" ,</p>"
						+"<p>Your VzoVerflow account has been created by admin..</p>"
						+"<p>Your username is "+inviteBody.getEmail()+"</p>"
						+"<p>Your password is "+inviteBody.getPassword()+"</p>"
						+"<a href=http://localhost:3000/login>Click here to login to our portal</a>"
						+ "</html>"
				,

				true);
		sender.send(msg);
	}

	@Override
	public void sendEmailPasswordReset(ResetPasswordRequest resetPasswordRequest) throws MessagingException{
		MimeMessage msg = sender.createMimeMessage();
		MimeMessageHelper helper=new MimeMessageHelper(msg,true);
		helper.setTo(resetPasswordRequest.getEmail());
		helper.setSubject("Regarding password reset request");
		helper.setText("<html>"
				+ "<h1>Password Reset Request</h1>"
				+"<p>Hi,</p>"
				+"<p>You have requested a password reset.If it was you please click on the link below,if not report immediately.</p>"
				+"<a href=http://localhost:3000/updatepassword?token="+resetPasswordRequest.getToken()+">Click here</a>"
				+ "</html>"
				,

				true);
		sender.send(msg);
	}
}

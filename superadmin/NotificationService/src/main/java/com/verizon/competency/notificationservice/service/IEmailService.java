package com.verizon.competency.notificationservice.service;

import com.verizon.competency.notificationservice.model.InviteBody;
import com.verizon.competency.notificationservice.model.ResetPasswordRequest;

import javax.mail.MessagingException;


public interface IEmailService {
    public void sendEmailInvitation(InviteBody inviteBody) throws MessagingException;
    public void sendEmailPasswordReset(ResetPasswordRequest resetPasswordRequest) throws MessagingException;
}

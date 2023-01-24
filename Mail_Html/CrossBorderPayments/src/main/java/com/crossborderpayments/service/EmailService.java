package com.crossborderpayments.service;

import com.crossborderpayments.model.EmailDetails;

import javax.mail.MessagingException;

// Interface
public interface EmailService {

    // Method
    // To send a simple email
    String sendSimpleMail(EmailDetails details) throws MessagingException;

    // Method
    // To send an email with attachment
    String sendMailWithAttachment(EmailDetails details);

}
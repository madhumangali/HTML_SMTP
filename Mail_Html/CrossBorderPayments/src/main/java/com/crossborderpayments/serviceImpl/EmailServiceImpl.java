package com.crossborderpayments.serviceImpl;

// Importing required classes
import java.io.File;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.swing.text.html.HTMLDocument;

import com.crossborderpayments.controller.EmailController;
import com.crossborderpayments.model.EmailDetails;
import com.crossborderpayments.model.UserAccountDetails;
import com.crossborderpayments.repository.UserDetailsRepository;
import com.crossborderpayments.service.EmailService;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

// Annotation
@Service
// Class
// Implementing EmailService interface
public class EmailServiceImpl implements EmailService {

    @Autowired private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}") private String sender;

    @Autowired private UserDetailsRepository userDetailsRepository;

    // Method 1
    // To send a simple email
    public String sendSimpleMail(EmailDetails details) throws MessagingException {

            String token = RandomString.make(30);

            UserAccountDetails userAccountDetails=userDetailsRepository.email(details.getRecipient());
            userAccountDetails.setResetPasswordToken(token);
            userDetailsRepository.save(userAccountDetails);

            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper;
            helper = new MimeMessageHelper(message, true);//true indicates multipart message

            helper.setFrom(sender); // <--- THIS IS IMPORTANT
            helper.setText("To reset your password, please click the link: " + "http://localhost:8090/?token=" +token);
            helper.setSubject(details.getSubject());
            helper.setTo(details.getRecipient());
          javaMailSender.send(message);

            return "Mail Sent Successfully...";
    }

    // Method 2
    // To send an email with attachment
    public String
    sendMailWithAttachment(EmailDetails details)
    {
        // Creating a mime message
        MimeMessage mimeMessage
                = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper;

        try {

            // Setting multipart as true for attachments to
            // be send
            mimeMessageHelper
                    = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setFrom(sender);
            mimeMessageHelper.setTo(details.getRecipient());
            mimeMessageHelper.setText(details.getMsgBody());
            mimeMessageHelper.setSubject(
                    details.getSubject());

            // Adding the attachment
            FileSystemResource file
                    = new FileSystemResource(
                    new File(details.getAttachment()));

            mimeMessageHelper.addAttachment(
                    file.getFilename(), file);

            // Sending the mail
            javaMailSender.send(mimeMessage);
            return "Mail sent Successfully";
        }

        // Catch block to handle MessagingException
        catch (MessagingException e) {

            // Display message when exception occurred
            return "Error while sending mail!!!";
        }
    }
}

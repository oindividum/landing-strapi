package com.example.strapi_1.service;

import com.example.strapi_1.model.ContactFormDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {


    private final JavaMailSender mailSender;
    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendContactFormEmail(ContactFormDto contactForm) {
        SimpleMailMessage message = new SimpleMailMessage();

        String fromAndToEmail = "aupovadiloram@gmail.com";

        message.setFrom(fromAndToEmail);
        message.setTo(fromAndToEmail);
        message.setSubject("Новая заявка с сайта от: " + contactForm.getName());

        String emailBody = "Получена новая заявка с контактной формы:\n\n"
                + "Имя: " + contactForm.getName() + "\n"
                + "Телефон: " + contactForm.getPhone() + "\n\n"
                + "Сообщение:\n" + contactForm.getMessage();

        message.setText(emailBody);

        mailSender.send(message);
    }
}

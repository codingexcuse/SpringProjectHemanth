package com.hemanth.SpringBootMapping.mailService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;



@Component
public class MailService
{

        @Autowired
        JavaMailSender javaMailSender;


        public void sendMessage(String msg)
        {
            SimpleMailMessage simpleMailMessage=new SimpleMailMessage();
            simpleMailMessage.setFrom("UniversityDepartment@nmamit.in");
            simpleMailMessage.setTo(msg);
            simpleMailMessage.setSubject("Student Registeration");
            simpleMailMessage.setText("Student Successfully Registered into the University");





            javaMailSender.send(simpleMailMessage);
        }

    }



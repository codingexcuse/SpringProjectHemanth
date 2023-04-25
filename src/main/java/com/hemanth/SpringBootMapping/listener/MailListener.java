package com.hemanth.SpringBootMapping.listener;

import com.hemanth.SpringBootMapping.EmailConfig.MailConfig;
import com.hemanth.SpringBootMapping.dto.StudentDto;
import com.hemanth.SpringBootMapping.mailService.MailService;
import com.hemanth.SpringBootMapping.model.Student;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



@Component
public class MailListener
{



        @Autowired
        MailService mailService;

        @RabbitListener(queues = MailConfig.login_queue)
        public void sendingMessage(StudentDto studentDto)
        {
            String result=studentDto.getEmail();

            System.out.println(result);

            mailService.sendMessage(result);

            System.out.println("Mail sent to --> "+result);

            System.out.println("Registration Complete");


        }
    }



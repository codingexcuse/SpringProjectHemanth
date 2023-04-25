package com.hemanth.SpringBootMapping.controller;

import com.hemanth.SpringBootMapping.EmailConfig.MailConfig;
import com.hemanth.SpringBootMapping.dto.StudentDto;
import com.hemanth.SpringBootMapping.model.Student;
import com.hemanth.SpringBootMapping.model.University;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MailController
{


        @Autowired
        RabbitTemplate rabbitTemplate;
        @RequestMapping(method = RequestMethod.POST,value = "/add/mail")
        public String sendMessage(@RequestBody StudentDto s)
        {

            rabbitTemplate.convertAndSend(MailConfig.topic_exchange,MailConfig.routing_Key,s);

            return "Data Entered successfully";
        }

    }



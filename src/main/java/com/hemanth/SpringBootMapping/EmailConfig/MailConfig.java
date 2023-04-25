package com.hemanth.SpringBootMapping.EmailConfig;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MailConfig
{


        public final static String login_queue="login_queue5";

        public static String topic_exchange="topic_exchange5";

        public static String routing_Key="routing_key3";

        @Bean
        public Queue queue()
        {

            return new Queue(login_queue);
        }

        @Bean
        public TopicExchange topicExchange()
        {
            return new TopicExchange(topic_exchange);
        }

        @Bean
        public Binding binding()
        {
            return BindingBuilder.bind(queue())
                    .to(topicExchange())
                    .with(routing_Key);
        }

        @Bean
        public MessageConverter messageConverter()
        {
            return new Jackson2JsonMessageConverter();
        }

        @Bean
        public AmqpTemplate rabbitTemplates(ConnectionFactory connectionFactory)
        {
            final RabbitTemplate rbt=new RabbitTemplate(connectionFactory);
            rbt.setMessageConverter(messageConverter());
            return rbt;
        }


    }



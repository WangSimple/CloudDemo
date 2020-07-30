package com.cloud.rbacserver.conf;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;

import javax.jms.Queue;
import javax.jms.Topic;

@EnableJms
@Configuration
public class MqConfiguration {

    @Bean
    public Queue getQueue(){
        return new ActiveMQQueue("ActiveMQQueue");
    }
    @Bean
    public Topic topic() {
        return new ActiveMQTopic("ActiveMQTopic");
    }
}

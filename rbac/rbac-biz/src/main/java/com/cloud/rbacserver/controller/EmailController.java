package com.cloud.rbacserver.controller;

import org.apache.activemq.command.ActiveMQMapMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Queue;
import javax.jms.Topic;

@RestController
@RequestMapping("/email")
public class EmailController {
    @Autowired
    private Queue emailQueue;
    @Autowired
    private Topic emailTopic;
    @Autowired
    private JmsMessagingTemplate jmsMessageTemplate;

    @PostMapping("/sendMessage/{name}")
    public ResponseEntity<String> sendMessage(@PathVariable("name") String name){
        //方法一：添加消息到消息队列
        MapMessage mapMessage = new ActiveMQMapMessage();
        try {
            mapMessage.setString("name", name);
        } catch (JMSException e) {
            e.printStackTrace();
        }

        jmsMessageTemplate.convertAndSend(emailQueue, mapMessage);
        //方法二：这种方式不需要手动创建queue，系统会自行创建名为test的队列
        //jmsMessageTemplate.convertAndSend("test", name);
        return new ResponseEntity<String>(HttpStatus.OK);
    }

    @PostMapping("/publishMessage/{name}")
    public ResponseEntity<String> publishMessage(@PathVariable("name") String name){
        //方法一：添加消息到消息队列
        MapMessage mapMessage = new ActiveMQMapMessage();
        try {
            mapMessage.setString("name", name);
            mapMessage.setString("info", "xpwang发布信息");
        } catch (JMSException e) {
            e.printStackTrace();
        }

        jmsMessageTemplate.convertAndSend(emailTopic, mapMessage);
        //方法二：这种方式不需要手动创建queue，系统会自行创建名为test的队列
        //jmsMessageTemplate.convertAndSend("test", name);
        return new ResponseEntity<String>(HttpStatus.OK);
    }
}

package org.simple.mq.subcirber.service;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

import javax.jms.JMSException;
import javax.jms.MapMessage;

@Service
public class EmailService {


    @JmsListener(destination = "ActiveMQTopic")
    public void subcribeMessage1(MapMessage message) throws JMSException {
        MapMessage mapMessage = (MapMessage) message;
        String name = mapMessage.getString("name");
        String info = mapMessage.getString("info");
        System.out.println("subcribeMessage1"+info + name);
    }

    @JmsListener(destination = "ActiveMQTopic")
    public void subcribeMessage2(MapMessage message) throws JMSException {
        MapMessage mapMessage = (MapMessage) message;
        String name = mapMessage.getString("name");
        String info = mapMessage.getString("info");
        System.out.println("subcribeMessage2"+info + name);
    }

}

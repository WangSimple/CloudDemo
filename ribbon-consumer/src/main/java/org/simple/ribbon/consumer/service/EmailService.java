package org.simple.ribbon.consumer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Service;

import javax.jms.JMSException;
import javax.jms.MapMessage;

@Service
public class EmailService {

    // 使用JmsListener配置消费者监听的队列，其中name是接收到的消息
    @JmsListener(destination = "ActiveMQQueue")
    // SendTo 会将此方法返回的数据, 写入到 OutQueue 中去.
    @SendTo("SQueue")
    public String handleMessage(MapMessage message) throws JMSException {
        MapMessage mapMessage = (MapMessage) message;
        String name = mapMessage.getString("name");
        System.out.println("成功接受Name" + name);
        return "成功接受Name" + name;
    }



}

package com.example.zaynab;


import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import java.util.Map;

@Component
public class JmsWrapper {
    @Autowired
    private JmsTemplate jmsTemplate;

    @JmsListener(destination = "java.jms.zaynab")
    public void receiveMessage(final String jsonMessage) throws JMSException {
        System.out.println("Received message " + jsonMessage);
        String response = null;

        Map map = new Gson().fromJson(jsonMessage, Map.class);
        response = "Hello " + map.get("name");

        System.out.println(response);
    }

   // @SendTo("java.jms.dima")

    public String sendMessage(String text) {
        jmsTemplate.convertAndSend("java.jms.dima", text);
        return text;
    }

}
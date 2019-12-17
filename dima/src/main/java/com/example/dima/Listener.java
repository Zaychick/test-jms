package com.example.dima;


import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import java.util.HashMap;
import java.util.Map;

@Component
public class Listener {

    @Autowired
    private JmsTemplate jmsTemplate;

    @JmsListener(destination = "java.jms.dima")
   /* @SendTo("java.jms.zaynab")*/
    public void receiveMessage(final String jsonMessage) throws JMSException {
        System.out.println("Received message " + jsonMessage);
        Map<String, String> responseMap = new HashMap<>();
        responseMap.put("name", "Dima");
        String msg = new Gson().toJson(responseMap);
        jmsTemplate.convertAndSend("java.jms.zaynab", msg);
    }


}
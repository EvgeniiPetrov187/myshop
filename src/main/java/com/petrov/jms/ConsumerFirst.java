package com.petrov.jms;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.ejb.Stateless;
import javax.jms.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@MessageDriven(name = "ConsumerFirst", activationConfig = {
        @ActivationConfigProperty(propertyName = "destination",
                propertyValue = "jms/queue/ExpiryQueue"),
        @ActivationConfigProperty(propertyName = "destinationType",
                propertyValue = "javax.jms.Queue"),
        @ActivationConfigProperty(propertyName = "acknowledgeMode",
                propertyValue = "Auto-acknowledge") })
public class ConsumerFirst implements MessageListener {

    private final Logger logger = Logger.getLogger(Producer.class.getName());

    public static List<String> messages = new ArrayList<String>();


    @Override
    public void onMessage(Message message) {
        TextMessage textMessage = (TextMessage) message;
        try {
            messages.add(textMessage.getText());
            logger.info("ConsumerFirst logger");
            System.out.println(textMessage.getText() +" "+ this.getClass().toString());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}

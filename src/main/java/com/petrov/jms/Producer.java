package com.petrov.jms;

import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.Schedule;
import javax.jms.*;
import java.util.Random;
import java.util.logging.Logger;

@LocalBean
public class Producer {

    private final Logger logger = Logger.getLogger(Producer.class.getName());

    private final String[] messages = new String[]{"Дай", "Закажи", "Печеньки", "Мне"};

    @Resource(name = "ConnectionFactory")
    private ConnectionFactory connectionFactory;

    @Resource(name = "java:/jms/queue/ExpiryQueue")
    private Destination destination;

    public void produceMessage(String message){
        Random random = new Random();
        try {
            Connection connection = connectionFactory.createConnection();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            MessageProducer messageProducer = session.createProducer(destination);
            TextMessage textMessage = session.createTextMessage(message != null ? message : messages[random.nextInt(4)]);
            messageProducer.send(textMessage);
            logger.info("Producer logger");
            connection.close();
            session.close();
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}

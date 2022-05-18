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

    @Schedule(hour = "*", minute = "*", second = "*/2", persistent = false)
    public void produceMessage(){
        Random random = new Random();
        try {
            Connection connection = connectionFactory.createConnection();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            MessageProducer messageProducer = session.createProducer(destination);
            TextMessage textMessage = session.createTextMessage(messages[random.nextInt(4)]);
            messageProducer.send(textMessage);
            System.out.println("Producer sout");
            logger.info("Producer logger");
            connection.close();
            session.close();
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}

package lk.jiat.ee.client;

import jakarta.jms.*;

import javax.naming.InitialContext;
import javax.naming.NamingException;

public class QueueReceiver {

    public static void main(String[] args) {
        try {
            InitialContext context = new InitialContext();
            QueueConnectionFactory factory = (QueueConnectionFactory)
                    context.lookup("jms/MyQueueConnectionFactory");

            QueueConnection connection = factory.createQueueConnection();
            connection.start();
            QueueSession session = connection.createQueueSession(false, Session.CLIENT_ACKNOWLEDGE);

            Queue queue = (Queue) context.lookup("jms/MyQueue");

            jakarta.jms.QueueReceiver receiver = session.createReceiver(queue);

            //Message receive = receiver.receive();
            //System.out.println("Message Received:- " + receive.getBody(String.class));

            receiver.setMessageListener(new MessageListener() {
                @Override
                public void onMessage(Message message) {
                    try {
                        String msg = message.getBody(String.class);
                        System.out.println("Message Received:- " + msg);
                        message.acknowledge();
                    } catch (JMSException e) {
                        throw new RuntimeException(e);
                    }
                }
            });

            while (true){}

            //receiver.close();
            //session.close();
            //connection.close();

        } catch (NamingException | JMSException e) {
            throw new RuntimeException(e);
        }
    }

}

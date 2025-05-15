package lk.jiat.ee.client;

import jakarta.jms.*;

import javax.naming.InitialContext;
import javax.naming.NamingException;

public class TopicReceiver {
    public static void main(String[] args) {
        try {
            InitialContext context = new InitialContext();
            TopicConnectionFactory factory = (TopicConnectionFactory) context.lookup("jms/MyConnectionFactory");

            // Lookup topic
            TopicConnection connection = factory.createTopicConnection(); // Corrected line
            connection.start();

            TopicSession session = connection.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);

            System.out.println("Session:-  " + session);

            Topic topic = (Topic) context.lookup("jms/MyTopic");

            TopicSubscriber subscriber = session.createSubscriber(topic);

            //Message message = subscriber.receive();
            //System.out.println("Received:- " + message.getBody(String.class));

            subscriber.setMessageListener(new MessageListener() {

                @Override
                public void onMessage(Message message) {
                    try {
                        String msg = message.getBody(String.class);
                        System.out.println("Received:- " + msg);
                    } catch (JMSException e) {
                        throw new RuntimeException(e);
                    }
                }
            });

            while (true){

            }

        } catch (NamingException | JMSException e) {
            throw new RuntimeException(e);
        }
    }
}

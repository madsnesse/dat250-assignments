package workqueues;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeoutException;

public class NewTask {
    private static final String QUEUE_NAME = "TEST_QUEUE";


    public static void main(String[] args) {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");

        try(Connection connection = factory.newConnection();
            Channel channel = connection.createChannel()){
            channel.queueDeclare(QUEUE_NAME, true, false, false, null);

            String message = String.join(" ", args);

            channel.basicPublish("", QUEUE_NAME,
                                 MessageProperties.PERSISTENT_TEXT_PLAIN,
                                 message.getBytes(StandardCharsets.UTF_8));
        }catch (IOException | TimeoutException e){
            System.err.println("Error");
        }

    }
}

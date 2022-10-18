package tutorial;

import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.concurrent.TimeoutException;

public class Send {
    private static final String QUEUE_NAME = "TEST_QUEUE";


    public static void main(String[] args) {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");

        try(Scanner sc = new Scanner(System.in);Connection connection = factory.newConnection();
            Channel channel = connection.createChannel()){
            while(true){
                channel.queueDeclare(QUEUE_NAME, false, false, false, null);
                String message = sc.nextLine();
                if (message.equals("quit")) return;
                channel.basicPublish("", QUEUE_NAME, null, message.getBytes(StandardCharsets.UTF_8));
            }
        }catch (IOException | TimeoutException ignored){
        }

    }
}

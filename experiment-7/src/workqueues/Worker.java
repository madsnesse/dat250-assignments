package workqueues;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

public class Worker {
    private static final String QUEUE_NAME = "TEST_QUEUE";

    public static void main(String[] args) throws Exception{
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");

        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare(QUEUE_NAME, true, false, false, null);

        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

        channel.basicQos(1);


        DeliverCallback callback = (consumerTag, delivery) ->{
            String message = new String(delivery.getBody());
            System.out.println("Received: " + message);
            try {
                doWork(message);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(" [x] Done");
                channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);
            }
        };

        channel.basicConsume(QUEUE_NAME, false, callback, consumerTag -> { });

    }

    private static void doWork(String message) throws InterruptedException {
        for (char c : message.toCharArray()){
            if (c == '.')Thread.sleep(1000);
        }
    }
}

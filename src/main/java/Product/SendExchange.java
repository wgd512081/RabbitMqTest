package Product;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import rabbitMq.ConnectionUtil;

/**
 * Created by lenovo on 2018/4/20.
 */
public class SendExchange {

    private final static String EXCHANGE_NAME = "test_exchange_fanout";

    public static void main(String[] args) throws Exception {
        //获取到连接以及mq通道
        Connection connection = ConnectionUtil.getConnection();
        //从连接中创建通道
        Channel channel = connection.createChannel();

        //声明Exchange
        channel.exchangeDeclare(EXCHANGE_NAME, "fanout");

        //消息内容
        String message = "Hello World!";
        channel.basicPublish(EXCHANGE_NAME, "", null, message.getBytes());
        System.out.println("[product] Send '" + message + "'");

        //关闭通道和连接
        channel.close();
        connection.close();
    }
}

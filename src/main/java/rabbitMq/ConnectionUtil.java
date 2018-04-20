package rabbitMq;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;

/**
 * Created by wgd
 */
public class ConnectionUtil {
    public static Connection getConnection() throws IOException {
        //定义连接工厂
        ConnectionFactory factory = new ConnectionFactory();
        //定义连接地址
        factory.setHost("127.0.0.1");
        //定义端口
        factory.setPort(5672);
        //设置账号信息，用户名、密码、vhost
        factory.setVirtualHost("/wugd");
        factory.setUsername("wugd");
        factory.setPassword("512081");
        // 通过工厂获取连接
        Connection connection = factory.newConnection();
        return connection;
    }
}

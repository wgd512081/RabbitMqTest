package Product;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import rabbitMq.ConnectionUtil;

/**
 * Created by lenovo on 2018/4/20.
 */
public class SendWork {
    private final static String QUEUE_NAME="test_queue_work";

    public static void main(String[] args) throws Exception {
        //获取到连接以及mq通道
        Connection connection = ConnectionUtil.getConnection();
        //从连接中创建通道
        Channel channel = connection.createChannel();

        //声明(创建)队列
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        // 同一时刻服务器只会发一条消息给消费者
        channel.basicQos(1);

        //发送100条信息
        for(int i=0;i<100;i++){
            //消息内容
            String message = "Hello World!"+i;
            channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
            System.out.println("[product] Send '"+ message +"'");

            Thread.sleep(i*10);//随着发送的信息越多而间隔越长
        }

        //关闭通道和连接
        channel.close();
        connection.close();
    }
}

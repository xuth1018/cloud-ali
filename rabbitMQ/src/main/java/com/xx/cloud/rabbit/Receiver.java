package com.xx.cloud.rabbit;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver {

    @RabbitHandler
    @RabbitListener(queues = "queue1")
    public void onMessage(String message, Channel channel){
        System.out.println("队列1：获取的消息-----："+message);
    }

    @RabbitHandler
    @RabbitListener(queues = "queue2")
    public void onMessage2(String message) throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("队列2：获取的消息-----："+message);
    }


}

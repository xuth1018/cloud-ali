package com.xx.cloud.rabbit;

import com.xx.cloud.config.RabbitConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.UUID;

@Component
public class Sender implements RabbitTemplate.ConfirmCallback, RabbitTemplate.ReturnCallback {

    private static final Logger logger = LoggerFactory.getLogger(Sender.class);

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @PostConstruct
    public void init(){
        rabbitTemplate.setConfirmCallback(this);
        rabbitTemplate.setReturnCallback(this);
    }

    //消息发送确认返回
    @Override
    public void confirm(CorrelationData correlationData, boolean b, String s) {
        if(b){
            logger.info("---消息发送成功：{}",correlationData);
        }else{
            logger.info("---消息发送失败：{}",s);
        }
    }

    @Override
    public void returnedMessage(Message message, int i, String s, String s1, String s2) {
        logger.info(Thread.currentThread().getName()+"---"+message.getMessageProperties().getCorrelationId()+"发送失败");
    }

    public void send(String message){
        CorrelationData data = new CorrelationData(UUID.randomUUID().toString());
        //转换并发送消息，等待响应
        rabbitTemplate.convertSendAndReceive(RabbitConfig.EXCHANGE,RabbitConfig.KEY1,message,data);
        logger.info("发送消息结束：{}",message);
    }
}

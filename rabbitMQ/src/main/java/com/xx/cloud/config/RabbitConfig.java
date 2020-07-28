package com.xx.cloud.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    public static final String QUEUE1 = "queue1";
    public static final String QUEUE2 = "queue2";
    public static final String EXCHANGE = "topicExchange";
    public static final String KEY1 = "hello.1";
    public static final String KEY2 = "hello.#";

    @Bean
    public TopicExchange exchange(){
        return new TopicExchange(EXCHANGE);
    }

    @Bean
    public Queue queue1(){
        return new Queue(QUEUE1);
    }

    @Bean
    public Queue queue2(){
        return new Queue(QUEUE2);
    }

    @Bean
    public Binding bind1(){
        return BindingBuilder.bind(queue1()).to(exchange()).with(KEY1);
    }

    @Bean
    public Binding bind2(){
        return BindingBuilder.bind(queue2()).to(exchange()).with(KEY1);
    }


    //-------------------------------------
    @Bean
    public Queue delayQueuePerMessage(){
        return QueueBuilder.durable("delay_queue_per_message_ttl").withArgument("x-dead-letter-exchange","111").build();
    }
}

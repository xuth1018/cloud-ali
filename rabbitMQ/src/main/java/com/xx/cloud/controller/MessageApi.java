package com.xx.cloud.controller;

import com.xx.cloud.rabbit.Sender;
import org.springframework.amqp.core.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/msg")
@RestController
public class MessageApi {

    @Autowired
    private Sender sender;

    @GetMapping("/send1/{msg}")
    public void send1(@PathVariable("msg") String msg){

        sender.send(msg);
    }

}

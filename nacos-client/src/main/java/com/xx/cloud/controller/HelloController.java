package com.xx.cloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicInteger;

@RestController
@RequestMapping("/hello")
public class HelloController {

    private AtomicInteger num = new AtomicInteger(0);

    @GetMapping("/hello/{name}")
    public String hello(@PathVariable String name){
        return "hello "+name;
    }

    @GetMapping("/create")
    public String product(){
        num.incrementAndGet();
        return "the product account: "+num;
    }

}

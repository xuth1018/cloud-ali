package com.xx.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/hello")
public class TestController {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private DiscoveryClient discoveryClient;
    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping("/hello")
    public String hello(@RequestParam("name") String name){
        ServiceInstance serviceInstance;
        List<ServiceInstance> list = discoveryClient.getInstances("nacos-client-8080");
        serviceInstance = list.get(0);
        String target = serviceInstance.getUri()+"/hello/hello/"+name;
        System.out.println(target);
        return restTemplate.getForObject(target,String.class);
    }
}

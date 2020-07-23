package com.xx.cloud.controller;

import com.alibaba.fastjson.JSON;
import com.xx.cloud.elasticMapper.ProductMapper;
import com.xx.cloud.elasticType.Product;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private ElasticsearchRestTemplate elasticsearchRestTemplate;

    private AtomicInteger num = new AtomicInteger(0);

    @GetMapping("/hello/{name}")
    public String hello(@PathVariable String name){
        return "hello "+name;
    }

    @GetMapping("/find/{flag}")
    public String find(@PathVariable("flag") String flag){
        String l = StringUtils.EMPTY;
        if("1".equals(flag)){
            List<Product> list = productMapper.findByName("huawei");
            l = JSON.toJSONString(list);
        }else if("2".equals(flag)){
            l = JSON.toJSONString(productMapper.findByName("huawei",Sort.by("name")));
        }else if("3".equals(flag)){
            l = JSON.toJSONString(productMapper.findByName("huawei", PageRequest.of(0,20)));
        }
        return l;
    }


    @GetMapping("/insert")
    public String insert(){
        Product product = new Product();
        product.setId(num.getAndIncrement());
        product.setImg("图片三");
        product.setName("huawei");
        product.setDescribe("好好看的手机呢");
        product.setPrice(new BigDecimal("3999.3"));
        Product p = productMapper.save(product);
        return "the product account: "+JSON.toJSONString(p);
    }



}

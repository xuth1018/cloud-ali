package com.xx.cloud.advice;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(basePackages = "com.xx.cloud")
public class GlobalException {

    @ExceptionHandler(BlockException.class)
    public String blockException(BlockException blockException){
        return new JSONObject().fluentPut("msg","请求被拦截，拦截类型为："+blockException.getClass().getSimpleName())
                .fluentPut("code",400).toJSONString();
    }
}

package com.xu.springcloud.controller;

import com.xu.springcloud.pojo.CommonResult;
import com.xu.springcloud.pojo.Payment;
import com.xu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;
    @Value("${server.port}")
    private String serverPort;

    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int res = paymentService.create(payment);
        log.info("*********插入结果："+res);
        if(res>0){
            return new CommonResult(200,"插入成功,端口号："+serverPort,res);
        }
        return new CommonResult(444,"插入失败,端口号："+serverPort);
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        log.info("********查询结果："+payment);
        if(payment != null){
            return new CommonResult(200,"查询成功,端口号："+serverPort,payment);
        }
        return new CommonResult(444,"查询失败,端口号："+serverPort);
    }

    @GetMapping(value = "/payment/lb")
    public String getPaymentLB() {
        return serverPort;//返回服务接口
    }
}

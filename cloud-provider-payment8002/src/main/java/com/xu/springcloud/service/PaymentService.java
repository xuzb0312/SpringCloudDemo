package com.xu.springcloud.service;

import com.xu.springcloud.pojo.Payment;
import org.apache.ibatis.annotations.Param;

public interface PaymentService {
    //插入
    public int create(Payment payment);
    //根据id查询
    public Payment getPaymentById(@Param("id") Long id);
}

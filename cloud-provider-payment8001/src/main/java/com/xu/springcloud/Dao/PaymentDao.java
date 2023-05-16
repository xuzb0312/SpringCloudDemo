package com.xu.springcloud.Dao;

import com.xu.springcloud.pojo.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PaymentDao {
    //插入
    public int create(Payment payment);
    //根据id查询
    public Payment getPaymentById(@Param("id") Long id);
}

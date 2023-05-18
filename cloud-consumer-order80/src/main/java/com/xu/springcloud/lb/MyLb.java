package com.xu.springcloud.lb;


import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author xuzb
 * @Date 2023/5/18 21:49
 * @Version 1.0
 */
@Component
public class MyLb implements LoadBalancer{
    //定义一个原子整型
    private AtomicInteger atomicInteger = new AtomicInteger(0);

    //获取当前请求次数并且加1
    public final int getAndIncrement(){
        int current;
        int next;

        do{
            current = this.atomicInteger.get();
            next = current >= 2147483647 ? 0:current+1;
        }while (!this.atomicInteger.compareAndSet(current,next));
        System.out.println("-----当前是第几次访问next：-----"+next);
        return next;
    }


    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstance) {
        int index = getAndIncrement() % serviceInstance.size();
        return serviceInstance.get(index);
    }
}

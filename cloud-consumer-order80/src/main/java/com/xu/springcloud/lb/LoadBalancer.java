package com.xu.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @Author xuzb
 * @Date 2023/5/18 21:49
 * @Version 1.0
 */
public interface LoadBalancer {
    ServiceInstance instances(List<ServiceInstance> serviceInstance);
}

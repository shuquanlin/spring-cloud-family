package com.spring.ordercenter.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author sql
 * @Date 16:082018\8\30 0030
 */
@FeignClient(name = "user-center",fallback = UserCenterFeignService.HystrixClientFallback.class)
public interface UserCenterFeignService {

    @RequestMapping("/user/test")
    String test1();

    /**
     * 熔断
     */
    @Component
    class HystrixClientFallback implements UserCenterFeignService{
        @Override
        public String test1() {
            return "没调通";
        }
    }

}

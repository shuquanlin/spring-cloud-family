package com.spring.ordercenter.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author sql
 * @Date 16:082018\8\30 0030
 */
@FeignClient("user-center")
public interface UserCenterFeignService {

    @RequestMapping("/user/test")
    String test1();



}

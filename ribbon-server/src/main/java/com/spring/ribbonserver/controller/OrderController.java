package com.spring.ribbonserver.controller;

import com.spring.ribbonserver.feign.UserCenterFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author sql
 * @Date 16:062018\8\30 0030
 */
@RestController
@RequestMapping("/order/center")
public class OrderController {

    @Autowired
    private UserCenterFeignService userCenterFeignService;

    @RequestMapping("/test")
    private String test(){

        return userCenterFeignService.test1();

    }

}

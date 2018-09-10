package com.spring.usercenter.controller;

import com.spring.usercenter.domain.User;
import com.spring.usercenter.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author sql
 * @Date 15:272018\7\9 0009
 */
@RestController
@RequestMapping("/user")
public class LoginController {

    @Autowired
    private UserMapper userMapper;


    @RequestMapping("/login")
    public List<User> login(){

        List<User> users = userMapper.queryUserInfoList();

        return users;
    }

    @RequestMapping("/test")
    public String test1(){



        return "aaaaaaaaaa";
    }


}

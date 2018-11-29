package com.spring.usercenter.controller;

import com.spring.usercenter.domain.User;
import com.spring.usercenter.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author sql
 * @Date 15:272018\7\9 0009
 */
@RestController
@RequestMapping("/user")
public class LoginController {




    @RequestMapping("/login")
    public String login(){



        return "this is user center";
    }

    @GetMapping("/test")
    public String test1(){



        return "aaaaaaaaaa";
    }


}

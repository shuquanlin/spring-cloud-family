package com.spring.usercenter.domain;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @Author sql
 * @Date 16:512018\7\9 0009
 */
@Data
@ToString
public class User implements Serializable {
    private static final long serialVersionUID = -2831361361894437101L;

    private String id;

    private String userName;

    private String password;

    private String email;

    private String phoneNumber;

    private Integer validate;
}

package com.hanjie.ljtools.entity;

import lombok.Data;


/**
 * @program: tools
 * @description
 * @author: hanjie
 * @create: 2020-03-21 19:25
 **/

@Data
public class Admin {
    private String adminNickName;
    private String adminPassword;
    private String token;
}

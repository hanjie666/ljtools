package com.hanjie.ljtools.entity;

import lombok.Data;

/**
 * @program: ljtools
 * @description
 * @author: hanjie
 * @create: 2020-04-12 14:16
 **/
@Data
public class AdminToken {
    private String roles;
    private String introduction;
    private String avatar;
    private String name;
    private String adminNickName;
}

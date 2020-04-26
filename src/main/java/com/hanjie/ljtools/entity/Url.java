package com.hanjie.ljtools.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**
 * @program: ljtools
 * @description
 * @author: hanjie
 * @create: 2020-03-23 13:58
 **/
@Data
public class Url {
    private String id;
    private String adminNickName;
    private String ipAddr;
    private String oneAddr;
    private String shortAddr;
    private String goAddr;
    private String message;
    private String createTime;
    private String tapCount;
    private String token;
}

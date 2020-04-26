package com.hanjie.ljtools.entity;

import lombok.Data;

/**
 * @program: ljtools
 * @description
 * @author: hanjie
 * @create: 2020-04-02 11:17
 **/
@Data
public class PageRequest {
    /**
     * 当前页码
     */
    private int pageNum;
    /**
     * 每页数量
     */
    private int pageSize;
    private String token;
}

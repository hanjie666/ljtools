package com.hanjie.ljtools.entity;

import lombok.Data;

import java.util.List;

/**
 * @program: ljtools
 * @description
 * @author: hanjie
 * @create: 2020-04-02 11:20
 **/
@Data
public class PageResult {
    /**
     * 当前页码
     */
    private int pageNum;
    /**
     * 每页数量
     */
    private int pageSize;
    /**
     * 记录总数
     */
    private long totalSize;
    /**
     * 页码总数
     */
    private int totalPages;
    /**
     * 数据模型
     */
    private List<?> content;
}

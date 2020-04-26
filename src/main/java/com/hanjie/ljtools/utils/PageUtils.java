package com.hanjie.ljtools.utils;

import com.github.pagehelper.PageInfo;
import com.hanjie.ljtools.entity.PageRequest;
import com.hanjie.ljtools.entity.PageResult;

/**
 * @program: ljtools
 * @description
 * @author: hanjie
 * @create: 2020-04-02 11:25
 **/
public class PageUtils {
    /**
     * 将分页信息封装到统一的接口
     * @return
     */
    public static PageResult getPageResult(PageInfo<?> pageInfo) {
        PageResult pageResult = new PageResult();
        pageResult.setPageNum(pageInfo.getPageNum());
        pageResult.setPageSize(pageInfo.getPageSize());
        pageResult.setTotalSize(pageInfo.getTotal());
        pageResult.setTotalPages(pageInfo.getPages());
        pageResult.setContent(pageInfo.getList());
        return pageResult;
    }
}

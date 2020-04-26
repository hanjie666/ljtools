package com.hanjie.ljtools.service;

import com.hanjie.ljtools.common.Result;
import com.hanjie.ljtools.entity.IpAddr;
import com.hanjie.ljtools.entity.PageRequest;
import com.hanjie.ljtools.entity.PageResult;
import com.hanjie.ljtools.entity.Url;

/**
 * @program: ljtools
 * @description
 * @author: hanjie
 * @create: 2020-03-24 09:46
 **/
public interface IJumpService {

    Result getAll(Url url);

    Result getGoAddr(String urlId);

    Result deleteAddr(String urlId);

    Result updateGoAddr(Url url);

    Result addAddr(Url url);

    /**
     * 分页查询接口
     * 这里统一封装了分页请求和结果，避免直接引入具体框架的分页对象, 如MyBatis或JPA的分页对象
     * 从而避免因为替换ORM框架而导致服务层、控制层的分页接口也需要变动的情况，替换ORM框架也不会
     * 影响服务层以上的分页接口，起到了解耦的作用
     * @param pageRequest 自定义，统一分页查询请求
     * @return PageResult 自定义，统一分页查询结果
     */
    PageResult findPage(PageRequest pageRequest);

    Result getIpAddr(String token);

    Result setIpAddr(IpAddr ipAddr);

    Result deleteIpAddr(IpAddr ipAddr);

}

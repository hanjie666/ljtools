package com.hanjie.ljtools.service;

import com.hanjie.ljtools.common.Result;
import com.hanjie.ljtools.entity.Admin;
import com.hanjie.ljtools.entity.Url;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @program: ljtools
 * @description
 * @author: hanjie
 * @create: 2020-03-21 20:33
 **/
public interface IAdminService {
    /**
     * 根据用户名和密码查询数据库是否有此用户，用来 后台登录验证
     **/
    Result adminLogin(Admin admin);

    Result getUserInfo(String token);
}

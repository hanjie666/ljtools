package com.hanjie.ljtools.service.impl;

import com.hanjie.ljtools.common.Result;
import com.hanjie.ljtools.common.ResultStatus;
import com.hanjie.ljtools.dao.IAdminDao;
import com.hanjie.ljtools.dao.IJumpDao;
import com.hanjie.ljtools.entity.Admin;
import com.hanjie.ljtools.entity.AdminToken;
import com.hanjie.ljtools.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



/**
 * @program: ljtools
 * @description
 * @author: hanjie
 * @create: 2020-03-21 20:33
 **/

@Service
public class AdminServiceImpl implements IAdminService {

    @Autowired
    IAdminDao adminDao;

    @Override
    public Result adminLogin(Admin admin) {
        Result result = new Result();
        Admin wocao = adminDao.adminLogin(admin);
        if (wocao != null){
            result.setCode(20000);
            result.setData(wocao);
        }else {
            result.setMessage("账号或密码错误");
            result.setCode(ResultStatus.ERROR.value());
        }
        return result;
    }

    @Override
    public Result getUserInfo(String token) {
        Result result = new Result();
        AdminToken adminToken = adminDao.geuUserInfo(token);
        result.setCode(ResultStatus.SUCCESS.value());
        result.setData(adminToken);
        return result;
    }


}

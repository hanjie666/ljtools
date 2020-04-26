package com.hanjie.ljtools.dao;

import com.hanjie.ljtools.entity.Admin;
import com.hanjie.ljtools.entity.AdminToken;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @program: ljtools
 * @description
 * @author: hanjie
 * @create: 2020-03-21 20:32
 **/
@Mapper
public interface IAdminDao {
    /**
     *后台登录验证
     **/
    @Select("select * from tb_admin where adminNickName=#{adminNickName} and adminPassword=#{adminPassword}")
    Admin adminLogin(Admin admin);
    @Select("select * from tb_admin_token where token = #{token}")
    AdminToken geuUserInfo(String token);
}

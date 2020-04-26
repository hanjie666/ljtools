package com.hanjie.ljtools.dao;

import com.hanjie.ljtools.common.Result;
import com.hanjie.ljtools.entity.AdminToken;
import com.hanjie.ljtools.entity.IpAddr;
import com.hanjie.ljtools.entity.PageRequest;
import com.hanjie.ljtools.entity.Url;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @program: ljtools
 * @description
 * @author: hanjie
 * @create: 2020-03-23 20:50
 **/
@Mapper
public interface IJumpDao {
    @Insert("insert into tools_jump (id,adminNickName,ipAddr,oneAddr,shortAddr,goAddr,message,createTime,token) values (#{id},#{adminNickName},#{ipAddr},#{oneAddr},#{shortAddr},#{goAddr},#{message},#{createTime},#{token})")
    int addAddr(Url url);

    @Select("select * from tools_jump where adminNickName = #{adminNickName} ORDER BY createTime")
    List<Url> getAll(Url url);

    @Select("select goAddr from tools_jump where id = #{urlId}")
    String getGoAddr(String urlId);

    @Delete("delete from tools_jump where id = #{urlId}")
    int deleteAddr(String urlId);

    @Update("update tools_jump set goAddr = #{goAddr} where id = #{id}")
    int updateGoAddr(Url url);

    @Update("update tools_jump set tapCount = tapCount+1 where id = #{urlId}")
    int addTapCount(String urlId);
    /**
     * 分页查询用户
     * @return
     */
    @Select("select * from tools_jump where token = #{token} ORDER BY createTime")
    List<Url> selectPage(PageRequest pageRequest);

    @Select("select * from jump_ip_addr where token = #{token}")
    List<IpAddr> getIpAddr(String token);

    @Insert("insert into jump_ip_addr (ipAddr,token) values (#{ipAddr},#{token})")
    int setIpAddr(IpAddr ipAddr);
    @Delete("delete from jump_ip_addr where ipAddr = #{ipAddr}")
    int deleteIpAddr(IpAddr ipAddr);
    @Delete("delete from tools_jump where ipAddr = #{ipAddr}")
    int deleteAllIpAddr(IpAddr ipAddr);

}

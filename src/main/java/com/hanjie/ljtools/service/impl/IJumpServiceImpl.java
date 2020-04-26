package com.hanjie.ljtools.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hanjie.ljtools.common.Result;
import com.hanjie.ljtools.common.ResultStatus;
import com.hanjie.ljtools.dao.IJumpDao;
import com.hanjie.ljtools.entity.*;
import com.hanjie.ljtools.service.IJumpService;
import com.hanjie.ljtools.utils.BaiDuShortUrl;
import com.hanjie.ljtools.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * @program: ljtools
 * @description
 * @author: hanjie
 * @create: 2020-03-24 09:46
 **/
@Service
public class IJumpServiceImpl implements IJumpService {

    @Autowired
    IJumpDao jumpDao;

    @Resource
    Result result;

    @Override
    public Result getAll(Url url) {
        List<Url> urls = jumpDao.getAll(url);
        String total = String.valueOf(urls.size());
        result.setData(urls);
        result.setMessage(total);
        return result;
    }


    @Override
    public Result getGoAddr(String urlId) {
        jumpDao.addTapCount(urlId);
        String goAddr  = jumpDao.getGoAddr(urlId);
        if (goAddr != null){
            result.setCode(ResultStatus.SUCCESS.value());
            result.setData(goAddr);
        }else {
            result.setCode(ResultStatus.ERROR.value());
        }
        return result;
    }

    @Override
    public Result deleteAddr(String urlId) {
        int i = jumpDao.deleteAddr(urlId);
        if (i>0){
            result.setCode(ResultStatus.SUCCESS.value());
        }else {
            result.setCode(ResultStatus.ERROR.value());
        }
        return result;
    }

    @Override
    public Result updateGoAddr(Url url) {
        if (jumpDao.updateGoAddr(url)>0){
            result.setCode(ResultStatus.SUCCESS.value());
        }else {
            result.setCode(ResultStatus.ERROR.value());
        }
        return result;
    }

    /**
     * 添加跳转地址
     * **/
    @Override
    public Result addAddr(Url url) {
        String oneAddr = url.getIpAddr()+"/temp?urlId="+url.getId();
        url.setOneAddr(oneAddr);
        String shortUrl = BaiDuShortUrl.createShortUrl(oneAddr, "1-year");
        url.setShortAddr(shortUrl);
        LocalDateTime rightNow = LocalDateTime.now();
        String time = rightNow.format(DateTimeFormatter.ofPattern("yyyy/MM/dd/HH/mm/ss"));
        url.setCreateTime(time);
        if (jumpDao.addAddr(url) > 0){
            result.setCode(ResultStatus.SUCCESS.value());
        }else {
            result.setCode(ResultStatus.ERROR.value());
        }
        return result;
    }


    @Override
    public PageResult findPage(PageRequest pageRequest) {
        return PageUtils.getPageResult(getPageInfo(pageRequest));
    }

    @Override
    public Result getIpAddr(String token) {
        List<IpAddr> list = jumpDao.getIpAddr(token);
        result.setCode(ResultStatus.SUCCESS.value());
        result.setData(list);
        return result;
    }

    @Override
    public Result setIpAddr(IpAddr ipAddr) {
        if (jumpDao.setIpAddr(ipAddr)<1){
            result.setCode(ResultStatus.ERROR.value());
        }else{
            result.setCode(ResultStatus.SUCCESS.value());
        }
        return result;
    }

    @Override
    public Result deleteIpAddr(IpAddr ipAddr) {
        jumpDao.deleteAllIpAddr(ipAddr);
        if (jumpDao.deleteIpAddr(ipAddr)>0){
            result.setCode(ResultStatus.SUCCESS.value());
        }else {
            result.setCode(ResultStatus.ERROR.value());
        }
        return result;
    }

    /**
     * 调用分页插件完成分页
     * @return
     */
    private PageInfo<Url> getPageInfo(PageRequest pageRequest) {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        List<Url> sysMenus = jumpDao.selectPage(pageRequest);
        return new PageInfo<>(sysMenus);
    }


}

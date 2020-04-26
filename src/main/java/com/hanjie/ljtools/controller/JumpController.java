package com.hanjie.ljtools.controller;

import com.hanjie.ljtools.common.Result;
import com.hanjie.ljtools.entity.IpAddr;
import com.hanjie.ljtools.entity.PageRequest;
import com.hanjie.ljtools.entity.Url;
import com.hanjie.ljtools.service.IJumpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.logging.Logger;

/**
 * @program: ljtools
 * @description
 * @author: hanjie
 * @create: 2020-03-24 09:43
 **/
@RestController
public class JumpController {

    @Autowired
    IJumpService iJumpService;

    @Resource
    Result result;

    private Logger logger = Logger.getLogger(String.valueOf(AdminController.class));

    @PostMapping("/api/admin/jump/getAll")
    public Result getAll(@RequestBody Url url){
        logger.info("getAll run");
        result = iJumpService.getAll(url);
        return result;
    }

    @GetMapping("/api/admin/jump/temp")
    public Result getGoAddr(@RequestParam(value="urlId", required=false) String urlId){
        logger.info("getGoAddr run");
        result = iJumpService.getGoAddr(urlId);
        return result;
    }

    @GetMapping("/api/admin/jump/delete")
    public Result deleteAddr(@RequestParam(value="urlId", required=false) String urlId){
        logger.info("deleteAddr run");
        result = iJumpService.deleteAddr(urlId);
        return result;
    }

    @PostMapping("/api/admin/jump/update")
    public Result updateGoAddr(@RequestBody Url url){
        logger.info("updateGoAddr run");
        result = iJumpService.updateGoAddr(url);
        return result;
    }

    /**
     * 类功能描述：添加Addr
     */
    @RequestMapping(value = "/api/admin/addAddr", method = RequestMethod.POST)
    public Result addAddr(@RequestBody Url url) {
        logger.info("addAddr run");
        result = iJumpService.addAddr(url);
        return result;
    }

    @PostMapping(value="/api/admin/jump/findPage")
    public Result findPage(@RequestBody PageRequest pageQuery) {
        result.setData(iJumpService.findPage(pageQuery));
        return result;
    }

    @GetMapping(value="/api/admin/jump/getIpAddr")
    public Result getIpAddr(@RequestParam(value="token", required=false) String token) {
        result=iJumpService.getIpAddr(token);
        return result;
    }

    @PostMapping("/api/admin/jump/setIpAddr")
    public Result setIpAddr(@RequestBody IpAddr ipAddr){
        logger.info("setIpAddr run");
        result = iJumpService.setIpAddr(ipAddr);
        return result;
    }

    @PostMapping("/api/admin/jump/deleteIpAddr")
    public Result deleteIpAddr(@RequestBody IpAddr ipAddr){
        logger.info("deleteIpAddr run");
        result = iJumpService.deleteIpAddr(ipAddr);
        return result;
    }

}

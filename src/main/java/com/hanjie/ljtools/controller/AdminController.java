package com.hanjie.ljtools.controller;
import com.hanjie.ljtools.common.Result;
import com.hanjie.ljtools.entity.Admin;
import com.hanjie.ljtools.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

/**
 * @program: ljtools
 * @description
 * @author: hanjie
 * @create: 2020-03-21 20:35
 **/
@RestController
public class AdminController {
    @Autowired
    private IAdminService adminService;

    private Logger logger = Logger.getLogger(String.valueOf(AdminController.class));

    /**
     * 类功能描述：登录的功能
     */
    @RequestMapping(value = "/api/admin/adminLogin", method = RequestMethod.POST)
    public Result adminLogin(@RequestBody Admin admin) {
        logger.info("AdminUserController login run");
        Result result = adminService.adminLogin(admin);
        return result;
    }

    @RequestMapping(value = "/api/admin/logout", method = RequestMethod.POST)
    public Result logout() {
        logger.info("AdminUserController logout run");
        Result result = new Result();
        result.setCode(20000);
        return result;
    }

    @RequestMapping(value = "/api/admin/userInfo", method = RequestMethod.GET)
    public Result getInfo(@RequestParam String token) {
        logger.info("AdminController getInfo run");
        Result result = adminService.getUserInfo(token);
        return result;
    }

    @GetMapping(value = "/test")
    @ResponseBody
    public String test() {
        return "wocao";
    }
}

package com.abin.lee.thrift.controller;

import com.abin.lee.thrift.common.util.JsonUtil;
import com.abin.lee.thrift.model.User;
import com.abin.lee.thrift.service.UserService;
import com.google.common.primitives.Longs;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by abin
 * Be Created in 2016/9/28.
 */
@Controller
@RequestMapping("/thrift")
public class RpcController {
    protected final static Logger LOGGER = LoggerFactory.getLogger(RpcController.class);

    @Resource
    UserService.Iface userService;

    @ResponseBody
    @RequestMapping(value = "/show")
    public String userInfo(String param) {
        String result = "";
        try {
            User user = userService.getById(Longs.tryParse(param));
            result = JsonUtil.toJson(user);
        } catch (Exception e) {
            LOGGER.error("e={}",  e);
        }
        return result;
    }






}

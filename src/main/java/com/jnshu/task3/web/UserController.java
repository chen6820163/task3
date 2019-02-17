package com.jnshu.task3.web;

import com.jnshu.task3.service.interfaces.IUserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: task3
 * @description: 用户管理
 * @author: Mr.Chen
 * @create: 2019-01-23 18:24
 * @contact:938738637@qq.com
 **/
@Controller
public class UserController {
    private static Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
    @Autowired
    IUserService userService;

    @PostMapping("/a/login")
    @ResponseBody
    public Map<String, Object> login(@RequestParam("username") String username,@RequestParam("password") String password) {
        Map<String, Object> map = new HashMap();
        try {
            boolean b = userService.login(username, password);
            if (b == true) {
                map.put("message", "登录成功");
                map.put("code", 200);
                return map;
            }
            map.put("message", "登录失败");
            map.put("code", 400);
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            map.put("message", "登录失败");
            map.put("code", 400);
            return map;
        }
    }
}


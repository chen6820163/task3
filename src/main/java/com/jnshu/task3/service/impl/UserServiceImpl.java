package com.jnshu.task3.service.impl;

import com.jnshu.task3.common.bean.User;
import com.jnshu.task3.dao.UserMapper;
import com.jnshu.task3.service.interfaces.IUserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: task3
 * @description: 角色管理
 * @author: Mr.Chen
 * @create: 2019-01-21 16:42
 * @contact:938738637@qq.com
 **/
@Service
public class UserServiceImpl implements IUserService {
    private static Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
    @Autowired
    public UserMapper userMapper;
    @Override
    public boolean login(String name, String password) throws Exception {
        if (name == null) {
            logger.info("用户名为空");
            throw new Exception("传入用户名为空为空");
        }
        User user = userMapper.selectByName(name);
        if (user==null) {
            logger.info("用户名不存在");
            throw new Exception("用户名不存在");
        }
        if (!user.getPassword().equals(password)) {
            logger.info("密码错误");
            throw new Exception("密码错误");
        }
        return true;
    }

    @Override
    public boolean register(User user) throws Exception {
        return false;
    }
}

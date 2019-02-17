package com.jnshu.task3.service.interfaces;

import com.jnshu.task3.common.bean.User;

public interface IUserService {
    boolean login(String name, String password) throws Exception;
    boolean register(User user) throws Exception;
}

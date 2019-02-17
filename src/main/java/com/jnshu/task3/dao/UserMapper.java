package com.jnshu.task3.dao;

import com.jnshu.task3.common.bean.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(User record);

    User selectByPrimaryKey(Long id);

    User selectByName(String name);

    List<User> selectByNameAndRole(@Param("name") String name, @Param("role") String role);

    int updateByPrimaryKeySelective(User record);

}
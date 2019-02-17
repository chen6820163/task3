package com.jnshu.task3.dao;

import com.jnshu.task3.common.bean.FirstList;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FirstListMapper {
    boolean deleteByPrimaryKey(Long id);

    Long insert(FirstList record);

    FirstList selectByPrimaryKey(Long id);

    List<FirstList> selectByStatusAndName(@Param("status") Short status, @Param("name") String name);

    boolean updateByPrimaryKeySelective(FirstList record);
}
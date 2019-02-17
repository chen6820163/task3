package com.jnshu.task3.dao;

import com.jnshu.task3.common.bean.SecondList;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SecondListMapper {
    boolean deleteByPrimaryKey(Long id);

    Long insert(SecondList record);

    SecondList selectByPrimaryKey(Long id);

    List<SecondList> selectByStatusAndName(@Param("status") Short status, @Param("name") String name);

    boolean updateByPrimaryKeySelective(SecondList record);

}
package com.jnshu.task3.dao;

import com.jnshu.task3.common.bean.Author;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface AuthorMapper {
    boolean deleteByPrimaryKey(Long id);

    Long insert(Author record);

//    int insertSelective(Author record);

    Author selectByPrimaryKey(Long id);

    List<Author> selectBystatusAndName(@Param("status") Short status, @Param("name") String name);

    boolean updateByPrimaryKeySelective(Author record);

}
package com.jnshu.task3.dao;

import com.jnshu.task3.common.bean.Comment;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentMapper {

    Long insert(Comment record);

    boolean deleteByPrimaryKey(Long id);

    Comment selectByPrimaryKey(Long id);

    List<Comment> selectBystatusAndWid(@Param("status") Short status, @Param("wid") Long wid);

    boolean updateByPrimaryKeySelective(Comment record);

}
package com.jnshu.task3.service.interfaces;

import com.jnshu.task3.common.bean.Banner;
import com.jnshu.task3.common.bean.Comment;

import java.util.List;

public interface ICommentService {
    long saveComment(Comment comment) throws Exception;

    boolean deleteCommentById(Long id) throws Exception;

    boolean updateComment(Comment comment) throws Exception;

    Comment queryCommentById(Long id) throws Exception;

    List<Comment> queryCommentsByNameAndStatus(Short status, Long wid) throws Exception;
}

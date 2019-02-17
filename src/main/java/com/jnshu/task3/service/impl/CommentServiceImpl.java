package com.jnshu.task3.service.impl;

import com.jnshu.task3.common.bean.Comment;
import com.jnshu.task3.dao.CommentMapper;
import com.jnshu.task3.service.interfaces.ICommentService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: task3
 * @description: 留言评论
 * @author: Mr.Chen
 * @create: 2019-01-20 23:37
 * @contact:938738637@qq.com
 **/
@Service
public class CommentServiceImpl implements ICommentService {
    private static Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

    @Autowired
    public CommentMapper commentMapper;

    @Override
    public long saveComment(Comment comment) throws Exception {
        if (comment == null) {
            logger.error("留言内容为空，请重新提交");
            throw new Exception("传入留言为空");
        }
        Long i = commentMapper.insert(comment);
        return i;
    }

    @Override
    public boolean deleteCommentById(Long id) throws Exception {
        if (id == null) {
            logger.error("传入留言id异常，删除留言失败");
            throw new Exception("传入id失败");
        }
        boolean b = commentMapper.deleteByPrimaryKey(id);
        return b;
    }

    @Override
    public boolean updateComment(Comment comment) throws Exception {
        if (comment==null) {
            throw new Exception("修改留言信息失败");
        }
        boolean b = commentMapper.updateByPrimaryKeySelective(comment);
        return b;
    }

    @Override
    public Comment queryCommentById(Long id) throws Exception {
        if (id == null) {
            throw new Exception("传入id失败");
        }
        Comment comment = commentMapper.selectByPrimaryKey(id);
        if (comment == null) {
            throw new Exception("查询id为"+id+"的留言信息失败");
        }
        return comment;
    }

    @Override
    public List<Comment> queryCommentsByNameAndStatus(Short status, Long wid) throws Exception {
        List<Comment> comments = commentMapper.selectBystatusAndWid(status, wid);
        if(comments.size()==0) {
            throw new Exception("留言表目前没有数据，请先留言");
        }
        return comments;
    }
}

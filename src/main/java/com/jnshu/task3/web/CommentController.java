package com.jnshu.task3.web;

import com.jnshu.task3.common.bean.Comment;
import com.jnshu.task3.service.interfaces.ICommentService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: task3
 * @description: 留言管理
 * @author: Mr.Chen
 * @create: 2019-01-23 18:23
 * @contact:938738637@qq.com
 **/
@Controller
public class CommentController {
    private static Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
    @Autowired
    ICommentService commentService;

    @PostMapping("/a/comment")
    @ResponseBody
    public Map<String, Object> saveComment(Comment comment) {
        Map<String, Object> map = new HashMap();
        Long time = System.currentTimeMillis();
        comment.setCreate_at(time);
        comment.setUpdate_at(time);
        comment.setStatus((short) 0);
        logger.info(comment);
        try {
            long l = commentService.saveComment(comment);
            map.put("message", "添加成功");
            map.put("code", 200);
            map.put("data", comment.getId());
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            map.put("message", "添加失败");
            map.put("code", 400);
            return map;
        }
    }

    @DeleteMapping("/a/u/comment/{id}")
    @ResponseBody
    public Map<String, Object> deleteCommentByid (@PathVariable Long id){
        Map<String, Object> map = new HashMap();
        try {
            boolean b = commentService.deleteCommentById(id);
            if (b == true) {
                map.put("message", "删除成功");
                map.put("code", 200);
                return map;
            }
            map.put("message", "删除失败");
            map.put("code", 400);
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            map.put("message", "删除失败");
            map.put("code", 400);
            return map;
        }
    }

    @PutMapping( "/a/u/comment")
    @ResponseBody
    public Map<String,Object> updateComment(Comment comment) {
        Map<String,Object> map = new HashMap();
        try {
            boolean b = commentService.updateComment(comment);
            if (b==true) {
                map.put("message","更新成功");
                map.put("code",200);
                return map;
            }
            map.put("message","更新失败");
            map.put("code",400);
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            map.put("message","更新失败");
            map.put("code",400);
            return map;
        }
    }

    @GetMapping("/a/u/comment/{id}")
    @ResponseBody
    public Map<String,Object> getCommentById(@PathVariable Long id) {
        Map<String,Object> map = new HashMap();
        try {
            Comment comment = commentService.queryCommentById(id);
            logger.info(comment);
                map.put("message","查询留言成功");
                map.put("code",200);
                map.put("data",comment);
                return map;
        } catch (Exception e) {
            e.printStackTrace();
            map.put("message","查询失败");
            map.put("code",400);
            return map;
        }
    }

    @GetMapping("/a/u/comment/list")
    @ResponseBody
    public Map<String,Object> getCommentByNameAndStatus(@RequestParam(value = "w_id") Long wid, @RequestParam(value = "status",defaultValue = "0") Short status) {
        Map<String,Object> map = new HashMap();
        try {
            List<Comment> comments = commentService.queryCommentsByNameAndStatus(status, wid);
            logger.info(comments);
                map.put("message","查询留言列表成功");
                map.put("code",200);
                map.put("data",comments);
                return map;

        } catch (Exception e) {
            e.printStackTrace();
            map.put("message","查询失败,目前没有留言");
            map.put("code",400);
            return map;
        }
    }
}

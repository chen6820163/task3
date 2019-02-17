package com.jnshu.task3.web;

import com.jnshu.task3.common.bean.Author;
import com.jnshu.task3.service.interfaces.IAuthorService;
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
 * @description: 工作室管理
 * @author: Mr.Chen
 * @create: 2019-01-23 18:23
 * @contact:938738637@qq.com
 **/
@Controller
public class AuthorController {
    private static Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
    @Autowired
    IAuthorService authorService;

    @PostMapping("/a/u/author")
    @ResponseBody
    public Map<String, Object> saveAuthor(Author author) {
        Map<String, Object> map = new HashMap();
        Long time = System.currentTimeMillis();
        author.setCreate_at(time);
        author.setUpdate_at(time);
        author.setStatus((short) 0);
        author.setCreated_by("梵高");
        logger.info(author);
        try {
            long l = authorService.saveAuthor(author);
            map.put("message", "添加成功");
            map.put("code", 200);
            map.put("data", author.getId());
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            map.put("message", "添加失败");
            map.put("code", 400);
            return map;
        }
    }

    @DeleteMapping("/a/u/author/{id}")
    @ResponseBody
    public Map<String, Object> deleteAuthorByid (@PathVariable Long id){
        Map<String, Object> map = new HashMap();
        try {
            boolean b = authorService.deleteAuthorById(id);
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

    @PutMapping( "/a/u/author")
    @ResponseBody
    public Map<String,Object> updateAuthor(Author author) {
        Map<String,Object> map = new HashMap();
        try {
            boolean b = authorService.updateAuthor(author);
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

    @GetMapping("/a/u/author/{id}")
    @ResponseBody
    public Map<String,Object> getAuthorById(@PathVariable Long id) {
        Map<String,Object> map = new HashMap();
        try {
            Author author = authorService.queryAuthorById(id);
            logger.info(author);
                map.put("message","查询作者成功");
                map.put("code",200);
                map.put("data",author);
                return map;
        } catch (Exception e) {
            e.printStackTrace();
            map.put("message","查询失败");
            map.put("code",400);
            return map;
        }
    }

    @GetMapping("/a/u/author/list")
    @ResponseBody
    public Map<String,Object> getAuthorByNameAndStatus(@RequestParam(value = "name") String name, @RequestParam(value = "status",defaultValue = "0") Short status) {
        Map<String,Object> map = new HashMap();
        try {
            List<Author> authors = authorService.queryAuthorsByNameAndStatus(status, name);
            logger.info(authors);
                map.put("message","查询工作室列表成功");
                map.put("code",200);
                map.put("data",authors);
                return map;
        } catch (Exception e) {
            e.printStackTrace();
            map.put("message","author表目前没有数据");
            map.put("code",400);
            return map;
        }
    }
}

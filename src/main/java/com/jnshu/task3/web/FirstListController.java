package com.jnshu.task3.web;

import com.jnshu.task3.common.bean.FirstList;
import com.jnshu.task3.service.interfaces.IFirstListService;
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
 * @description: 作品集列表web层
 * @author: Mr.Chen
 * @create: 2019-01-23 16:34
 * @contact:938738637@qq.com
 **/
@Controller
public class FirstListController {
    private static Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
    @Autowired
    IFirstListService firstListService;

    @PostMapping("/a/u/first_list")
    @ResponseBody
    public Map<String, Object> saveFirstList(FirstList firstList) {
        Map<String, Object> map = new HashMap();
        Long time = System.currentTimeMillis();
        firstList.setCreate_at(time);
        firstList.setUpdate_at(time);
        firstList.setStatus((short) 0);
        logger.info(firstList);
        try {
            long l = firstListService.saveFirstList(firstList);
            map.put("message", "添加成功");
            map.put("code", 200);
            map.put("data", firstList.getId());
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            map.put("message", "添加失败");
            map.put("code", 400);
            return map;
        }
    }

    @DeleteMapping("/a/u/first_list/{id}")
    @ResponseBody
    public Map<String, Object> deleteFirstListByid (@PathVariable Long id){
        Map<String, Object> map = new HashMap();
        try {
            boolean b = firstListService.deleteFirstListById(id);
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

    @PutMapping( "/a/u/first_list")
    @ResponseBody
    public Map<String,Object> updateFirstList(FirstList firstList) {
        Map<String,Object> map = new HashMap();
        try {
            boolean b = firstListService.updateFirstList(firstList);
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

    @GetMapping("/a/u/first_list/{id}")
    @ResponseBody
    public Map<String,Object> getFirstListById(@PathVariable Long id) {
        Map<String,Object> map = new HashMap();
        try {
            FirstList firstList = firstListService.queryFirstListById(id);
            logger.info(firstList);
            if (firstList!=null) {
                map.put("message","查询作品集成功");
                map.put("code",200);
                map.put("data",firstList);
                return map;
            }
            map.put("message","查询失败");
            map.put("code",400);
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            map.put("message","查询失败");
            map.put("code",400);
            return map;
        }
    }

    @GetMapping("/a/u/first_list/list")
    @ResponseBody
    public Map<String,Object> getFirstListByNameAndStatus(@RequestParam(value = "name",required = false) String name, @RequestParam(value = "status",defaultValue = "0",required = false) Short status) {
        Map<String,Object> map = new HashMap();
        try {
            List<FirstList> firstLists = firstListService.queryFirstListsByNameAndStatus(status,name);
            logger.info(firstLists);
            if (firstLists!=null) {
                map.put("message","查询作品集列表成功");
                map.put("code",200);
                map.put("data",firstLists);
                return map;
            }
            map.put("message","查询失败");
            map.put("code",400);
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            map.put("message","查询失败");
            map.put("code",400);
            return map;
        }
    }
}


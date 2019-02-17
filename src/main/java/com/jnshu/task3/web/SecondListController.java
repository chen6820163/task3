package com.jnshu.task3.web;

import com.jnshu.task3.common.bean.SecondList;
import com.jnshu.task3.service.interfaces.ISecondListService;
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
 * @description: 作品集分类列表管理
 * @author: Mr.Chen
 * @create: 2019-01-23 16:53
 * @contact:938738637@qq.com
 **/
@Controller
public class SecondListController {
    private static Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
    @Autowired
    ISecondListService secondListService;

    @PostMapping("/a/u/second_list")
    @ResponseBody
    public Map<String, Object> saveSecondList(SecondList secondList) {
        Map<String, Object> map = new HashMap();
        Long time = System.currentTimeMillis();
        secondList.setCreate_at(time);
        secondList.setUpdate_at(time);
        secondList.setStatus((short) 0);
        logger.info(secondList);
        try {
            long l = secondListService.saveSecondList(secondList);
            map.put("message", "添加成功");
            map.put("code", 200);
            map.put("data", secondList.getId());
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            map.put("message", "添加失败");
            map.put("code", 400);
            return map;
        }
    }

    @DeleteMapping("/a/u/second_list/{id}")
    @ResponseBody
    public Map<String, Object> deleteSecondListByid (@PathVariable Long id){
        Map<String, Object> map = new HashMap();
        try {
            boolean b = secondListService.deleteSecondListById(id);
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

    @PutMapping( "/a/u/second_list")
    @ResponseBody
    public Map<String,Object> updateSecondList(SecondList secondList) {
        Map<String,Object> map = new HashMap();
        try {
            boolean b = secondListService.updateSecondList(secondList);
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

    @GetMapping("/a/u/second_list/{id}")
    @ResponseBody
    public Map<String,Object> getSecondListById(@PathVariable Long id) {
        Map<String,Object> map = new HashMap();
        try {
            SecondList secondList = secondListService.querySecondListById(id);
            logger.info(secondList);
            if (secondList!=null) {
                map.put("message","查询作品分类成功");
                map.put("code",200);
                map.put("data",secondList);
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

    @GetMapping("/a/u/second_list/list")
    @ResponseBody
    public Map<String,Object> getSecondListByNameAndStatus(@RequestParam(value = "name") String name, @RequestParam(value = "status",defaultValue = "0") Short status) {
        Map<String,Object> map = new HashMap();
        try {
            List<SecondList> secondLists = secondListService.querySecondListsByNameAndStatus(status, name);
            logger.info(secondLists);
            if (secondLists!=null) {
                map.put("message","查询作品分类列表成功");
                map.put("code",200);
                map.put("data",secondLists);
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

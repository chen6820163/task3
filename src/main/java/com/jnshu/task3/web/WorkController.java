package com.jnshu.task3.web;

import com.jnshu.task3.common.bean.Work;
import com.jnshu.task3.service.interfaces.IWorkService;
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
 * @description: 作品管理
 * @author: Mr.Chen
 * @create: 2019-01-23 17:12
 * @contact:938738637@qq.com
 **/
@Controller
public class WorkController {
    private static Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
    @Autowired
    IWorkService workService;

    @PostMapping("/a/u/work")
    @ResponseBody
    public Map<String, Object> saveWork(Work work) {
        Map<String, Object> map = new HashMap();
        Long time = System.currentTimeMillis();
        work.setCreate_at(time);
        work.setUpdate_at(time);
        work.setStatus((short) 0);
        logger.info(work);
        try {
            long l = workService.saveWork(work);
            map.put("message", "添加成功");
            map.put("code", 200);
            map.put("data", work.getId());
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            map.put("message", "添加失败");
            map.put("code", 400);
            return map;
        }
    }

    @DeleteMapping("/a/u/work/{id}")
    @ResponseBody
    public Map<String, Object> deleteWorkByid (@PathVariable Long id){
        Map<String, Object> map = new HashMap();
        try {
            boolean b = workService.deleteWorkById(id);
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

    @PutMapping( "/a/u/work")
    @ResponseBody
    public Map<String,Object> updateWork(Work work) {
        Map<String,Object> map = new HashMap();
        try {
            boolean b = workService.updateWork(work);
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

    @GetMapping("/a/u/work/{id}")
    @ResponseBody
    public Map<String,Object> getWorkById(@PathVariable Long id) {
        Map<String,Object> map = new HashMap();
        try {
            Work work = workService.queryWorkById(id);
            logger.info(work);
                map.put("message","查询作品成功");
                map.put("code",200);
                map.put("data",work);
                return map;
        } catch (Exception e) {
            e.printStackTrace();
            map.put("message","查询失败,该作品不存在");
            map.put("code",400);
            return map;
        }
    }

    @GetMapping("/a/u/work/list")
    @ResponseBody
    public Map<String,Object> getWorkByNameAndStatus(@RequestParam(value = "name",required = false) String name, @RequestParam(value = "status",required = false) Short status) {
        Map<String,Object> map = new HashMap();
        try {
            List<Work> works = workService.queryWorksByNameAndStatus(status, name);
            logger.info(works);
                map.put("message","查询作品列表成功");
                map.put("code",200);
                map.put("data",works);
                return map;
        } catch (Exception e) {
            e.printStackTrace();
            map.put("message","查询失败");
            map.put("code",400);
            return map;
        }
    }
}

package com.jnshu.task3.web;

import com.jnshu.task3.common.bean.Banner;
import com.jnshu.task3.service.interfaces.IBannerService;
import org.apache.commons.lang3.ObjectUtils;
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
 * @description:, headers="Content-Type=application/json"
 * @author: Mr.Chen
 * @create: 2019-01-21 23:44
 * @contact:938738637@qq.com
 **/
@Controller

public class BannerController {
    private static Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
    @Autowired
    IBannerService bannerService;

    @RequestMapping(value = "/a/u/banner" , method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> saveBanner(Banner banner) {
        Map<String,Object> map = new HashMap();
        Long time = System.currentTimeMillis();
        banner.setCreate_at(time);
        banner.setUpdate_at(time);
        banner.setCreated_by("梵高");
        banner.setStatus((short) 0);
        logger.info(banner);
        try {
            long l = bannerService.saveBanner(banner);
            map.put("message","添加成功");
            map.put("code",200);
            map.put("data",banner.getId());
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            map.put("message","添加失败");
            map.put("code",400);
            return map;
        }

    }

    @RequestMapping(value = "/a/u/banner/{id}" , method = RequestMethod.DELETE)
    @ResponseBody
    public Map<String,Object> deleteBannerById(@PathVariable Long id) {
        Map<String,Object> map = new HashMap();
        try {
            boolean b = bannerService.deleteBannerById(id);
            if (b==true) {
                map.put("message","删除成功");
                map.put("code",200);
                return map;
            }
            map.put("message","删除失败");
            map.put("code",400);
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            map.put("message","id为空,删除失败");
            map.put("code",400);
            return map;
        }
    }

    @RequestMapping(value = "/a/u/banner" , method = RequestMethod.PUT)
    @ResponseBody
    public Map<String,Object> updateBanner(Banner banner) {
        Map<String,Object> map = new HashMap();
        try {
            boolean b = bannerService.updateBanner(banner);
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

    @RequestMapping(value = "/a/u/banner/{id}" , method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getBannerById(@PathVariable Long id) {
        Map<String,Object> map = new HashMap();
        try {
            Banner banner = bannerService.queryBannerById(id);
            logger.info(banner);
                map.put("message","查询成功");
                map.put("code",200);
                map.put("data",banner);
                return map;
        } catch (Exception e) {
            e.printStackTrace();
            map.put("message","查询失败");
            map.put("code",400);
            return map;
        }
    }

    @RequestMapping(value = "/a/u/banner/list" , method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getBannerByNameAndStatus(@RequestParam(value = "name",required = false) String name, @RequestParam(value = "status",defaultValue = "0") Short status) {
        Map<String,Object> map = new HashMap();
        try {
            List<Banner> banners = bannerService.queryBannersByNameAndStatus(status, name);
            logger.info(banners);
                map.put("message","查询banner列表成功");
                map.put("code",200);
                map.put("data",banners);
                return map;
        } catch (Exception e) {
            e.printStackTrace();
            map.put("message","banner表目前没有数据，请先添加banner");
            map.put("code",400);
            return map;
        }
    }
}

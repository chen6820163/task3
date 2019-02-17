package com.jnshu.task3.service.interfaces;

import com.jnshu.task3.common.bean.Banner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-mybatis.xml")
public class IBannerServiceTest  {
    private static Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
    @Autowired
    public IBannerService bannerService;
    @Test
    public void saveBanner() throws Exception {
        Banner banner = new Banner();
//        banner.setId((long) 3);
        banner.setName("雨");
        banner.setImg("Rain");
        banner.setImg_url("图片url");
        banner.setStatus((short) 0);
        banner.setCreate_at(System.currentTimeMillis());
        banner.setUpdate_at(System.currentTimeMillis());
        banner.setCreated_by("梵高");
        long l = bannerService.saveBanner(banner);
        logger.info(banner.getId());
        logger.info(l);
    }

    @Test
    public void deleteBannerById() throws Exception {
        boolean b = bannerService.deleteBannerById(1l);
        if (true == b) {
            logger.info("删除成功");
        } else {
            logger.info("删除失败");
        }

    }

    @Test
    public void updateBanner() throws Exception {
        Banner banner = new Banner();
        banner.setId(2l);
        banner.setName("雨");
        banner.setImg("Rain");
        banner.setImg_url("图片url");
        banner.setStatus((short) 0);
        banner.setUpdate_at(System.currentTimeMillis());
        banner.setCreated_by("毕加索");
        boolean b = bannerService.updateBanner(banner);
        if (true == b) {
            logger.info("更新成功");
        } else {
            logger.info("更新失败");
        }
    }

    @Test
    public void queryBannerById() throws Exception {
        Banner banner = bannerService.queryBannerById(4l);
        logger.info("查询成功");
        logger.info(banner);
    }

    @Test
    public void queryBannersByNameAndStatus() throws Exception {
        List<Banner> banners = bannerService.queryBannersByNameAndStatus((short) 1, "梵高");
        logger.info("查询成功");
        for (Banner banner:banners
             ) {
            logger.info(banner);
        }
    }
}
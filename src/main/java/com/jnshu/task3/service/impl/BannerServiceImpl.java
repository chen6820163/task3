package com.jnshu.task3.service.impl;

import com.github.pagehelper.PageInfo;
import com.jnshu.task3.common.bean.Banner;
import com.jnshu.task3.dao.BannerMapper;
import com.jnshu.task3.service.interfaces.IBannerService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: task3
 * @description: 轮播图增删改查
 * @author: Mr.Chen
 * @create: 2019-01-18 00:12
 * @contact:938738637@qq.com
 **/
@Service
public class BannerServiceImpl implements IBannerService {
    private static Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

    @Autowired
    public BannerMapper bannerMapper;

    @Override
    public long saveBanner(Banner banner) throws Exception {
        if (banner == null) {
            logger.error("传入banner为空，添加banner信息失败");
            throw new Exception("传入banner为空");
        }
        Long i = bannerMapper.insert(banner);
        return i;
    }

    @Override
    public boolean deleteBannerById(Long id) throws Exception {
        if (id == null) {
            logger.error("传入banner为空,删除失败");
            throw new Exception("传入id失败");
        }
        boolean b = bannerMapper.deleteByPrimaryKey(id);
        return b;

    }

    @Override
    public boolean updateBanner(Banner banner) throws Exception {
        if (banner==null) {
            throw new Exception("修改banner信息失败");
        }
        boolean b = bannerMapper.updateByPrimaryKeySelective(banner);
        return b;
    }

    @Override
    public Banner queryBannerById(Long id) throws Exception {
        if (id == null) {
            throw new Exception("传入id失败");
        }
        Banner banner = bannerMapper.selectByPrimaryKey(id);
        if(banner==null) {
            throw new Exception("没有对应banner,查询失败");
        }
        return banner;
    }

    @Override
    public List<Banner> queryBannersByNameAndStatus(Short status, String creator) throws Exception {
        List<Banner> banners = bannerMapper.selectBystatusAndCreator(status, creator);
        if(banners==null&&banners.size()==0) {
            throw new Exception("banner表目前没有数据，请先添加banner");
        }
        return banners;
    }
}

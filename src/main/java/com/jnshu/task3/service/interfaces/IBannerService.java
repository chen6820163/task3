package com.jnshu.task3.service.interfaces;

import com.jnshu.task3.common.bean.Banner;

import java.util.List;

public interface IBannerService {

    long saveBanner(Banner banner) throws Exception;

    boolean deleteBannerById(Long id) throws Exception;

    boolean updateBanner(Banner banner) throws Exception;

    Banner queryBannerById(Long id) throws Exception;

    List<Banner> queryBannersByNameAndStatus(Short status, String creator) throws Exception;
}

package com.jnshu.task3.dao;

import com.jnshu.task3.common.bean.Banner;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BannerMapper {
    boolean deleteByPrimaryKey(Long id);

    Long insert(Banner record);

    Banner selectByPrimaryKey(Long id);

    List<Banner> selectBystatusAndCreator(@Param("status") Short status,@Param("creator") String creator);

    boolean updateByPrimaryKeySelective(Banner record);


}
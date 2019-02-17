package com.jnshu.task3.dao;

import com.jnshu.task3.common.bean.Work;
import com.jnshu.task3.common.bean.WorkExample;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkMapper {
    boolean deleteByPrimaryKey(Long id);

    Long insert(Work record);

    List<Work> selectByStatusAndName(@Param("status") Short status, @Param("name") String name);

    Work selectByPrimaryKey(Long id);

    boolean updateByPrimaryKeySelective(Work record);

}
package com.jnshu.task3.service.impl;

import com.jnshu.task3.common.bean.FirstList;
import com.jnshu.task3.dao.FirstListMapper;
import com.jnshu.task3.service.interfaces.IFirstListService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: task3
 * @description: 作品集列表
 * @author: Mr.Chen
 * @create: 2019-01-21 00:06
 * @contact:938738637@qq.com
 **/
@Service
public class FirstListServiceImpl implements IFirstListService {
    private static Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
    @Autowired
    public FirstListMapper firstListMapper;

    @Override
    public long saveFirstList(FirstList firstList) throws Exception {
        if (firstList == null) {
            logger.error("传入firstList为空，添加作品集信息失败");
            throw new Exception("传入firstList为空");
        }
        Long i = firstListMapper.insert(firstList);
        return i;
    }

    @Override
    public boolean deleteFirstListById(Long id) throws Exception {
        if (id == null) {
            logger.error("传入firstList为空，删除作品集信息失败");
            throw new Exception("传入id失败");
        }
        boolean b = firstListMapper.deleteByPrimaryKey(id);
        return b;
    }

    @Override
    public boolean updateFirstList(FirstList firstList) throws Exception {
        if (firstList==null) {
            throw new Exception("修改作品集信息失败");
        }
        boolean b = firstListMapper.updateByPrimaryKeySelective(firstList);
        return b;
    }

    @Override
    public FirstList queryFirstListById(Long id) throws Exception {
        if (id == null) {
            throw new Exception("传入id失败");
        }
        FirstList firstList = firstListMapper.selectByPrimaryKey(id);
        if (firstList == null) {
            throw new Exception("查询id为"+id+"的作品集信息失败");
        }
        return firstList;
    }


    @Override
    public List<FirstList> queryFirstListsByNameAndStatus(Short status, String name) throws Exception {
        List<FirstList> firstLists = firstListMapper.selectByStatusAndName(status, name);
        if(firstLists.size()==0) {
            throw new Exception("作品集列表目前没有符合的数据,请先添加符合的作品集");
        }
        return firstLists;
    }
}

package com.jnshu.task3.service.impl;

import com.jnshu.task3.common.bean.SecondList;
import com.jnshu.task3.dao.SecondListMapper;
import com.jnshu.task3.service.interfaces.ISecondListService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: task3
 * @description: 作品集分类列表
 * @author: Mr.Chen
 * @create: 2019-01-21 11:10
 * @contact:938738637@qq.com
 **/
@Service
public class SecondListServiceImpl implements ISecondListService {
    private static Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
    @Autowired
    public SecondListMapper secondListMapper;
    @Override
    public long saveSecondList(SecondList secondList) throws Exception {
        if (secondList == null) {
            logger.error("传入secondList为空，添加作品集分类信息失败");
            throw new Exception("传入secondList为空");
        }
        Long i = secondListMapper.insert(secondList);
        return i;
    }

    @Override
    public boolean deleteSecondListById(Long id) throws Exception {
        if (id == null) {
            logger.error("传入secondList为空，删除作品集分类信息失败");
            throw new Exception("传入id失败");
        }
        boolean b = secondListMapper.deleteByPrimaryKey(id);
        return b;
    }

    @Override
    public boolean updateSecondList(SecondList secondList) throws Exception {
        if (secondList==null) {
            throw new Exception("修改作品集分类信息失败");
        }
        boolean b = secondListMapper.updateByPrimaryKeySelective(secondList);
        return b;
    }

    @Override
    public SecondList querySecondListById(Long id) throws Exception {
        if (id == null) {
            throw new Exception("传入id失败");
        }
        SecondList secondList = secondListMapper.selectByPrimaryKey(id);
        if (secondList == null) {
            throw new Exception("查询id为"+id+"的作品集分类信息失败");
        }
        return secondList;
    }

    @Override
    public List<SecondList> querySecondListsByNameAndStatus(Short status, String name) throws Exception {
        List<SecondList> secondLists = secondListMapper.selectByStatusAndName(status, name);
        if(secondLists.size()==0) {
            throw new Exception("作品集分类列表目前没有数据，请先添加作品集分类信息");
        }
        return secondLists;
    }
}

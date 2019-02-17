package com.jnshu.task3.service.impl;

import com.jnshu.task3.common.bean.Work;
import com.jnshu.task3.dao.WorkMapper;
import com.jnshu.task3.service.interfaces.IWorkService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: task3
 * @description: 作品
 * @author: Mr.Chen
 * @create: 2019-01-21 11:53
 * @contact:938738637@qq.com
 **/
@Service
public class IWorkServiceImpl implements IWorkService {
    private static Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
    @Autowired
    public WorkMapper workMapper;
    @Override
    public long saveWork(Work work) throws Exception {
        if (work == null) {
            logger.error("传入work为空，添加作品信息失败");
            throw new Exception("传入secondList为空");
        }
        Long i = workMapper.insert(work);
        return i;
    }

    @Override
    public boolean deleteWorkById(Long id) throws Exception {
        if (id == null) {
            logger.error("传入work为空，删除作品信息失败");
            throw new Exception("传入id失败");
        }
        boolean b = workMapper.deleteByPrimaryKey(id);
        return b;
    }

    @Override
    public boolean updateWork(Work work) throws Exception {
        if (work==null) {
            throw new Exception("修改作品信息失败");
        }
        boolean b = workMapper.updateByPrimaryKeySelective(work);
        return b;
    }

    @Override
    public Work queryWorkById(Long id) throws Exception {
        if (id == null) {
            throw new Exception("传入id失败");
        }
        Work work = workMapper.selectByPrimaryKey(id);
        if (work == null) {
            throw new Exception("查询id为"+id+"的作品信息失败");
        }
        return work;
    }

    @Override
    public List<Work> queryWorksByNameAndStatus(Short status, String name) throws Exception {
        List<Work> works = workMapper.selectByStatusAndName(status, name);
        if(works.size()==0&&works==null) {
            throw new Exception("作品列表目前没有数据，请先添加作品信息");
        }
        return works;
    }
}

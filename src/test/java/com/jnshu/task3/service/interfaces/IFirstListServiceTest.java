package com.jnshu.task3.service.interfaces;

import com.jnshu.task3.common.bean.FirstList;
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
public class IFirstListServiceTest {
    private static Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
    @Autowired
    public IFirstListService firstListService;
    @Test
    public void saveFirstList() throws Exception {
        FirstList firstList = new FirstList(6l,"油画", (short) 0,System.currentTimeMillis(),System.currentTimeMillis(),"梵高");
        long l = firstListService.saveFirstList(firstList);
        logger.info(firstList);
        logger.info(l);
    }

    @Test
    public void deleteFirstListById() throws Exception {
        boolean b = firstListService.deleteFirstListById(6l);
        if (true == b) {
            logger.info("删除成功");
        } else {
            logger.info("删除失败");
        }
    }

    @Test
    public void updateFirstList() throws Exception {
        FirstList firstList = new FirstList(6l,"油画", (short) 1,System.currentTimeMillis(),System.currentTimeMillis(),"梵高");
        boolean b = firstListService.updateFirstList(firstList);
        if (true == b) {
            logger.info("更新成功");
        } else {
            logger.info("更新失败");
        }
    }

    @Test
    public void queryFirstListById() throws Exception {
        FirstList firstList = firstListService.queryFirstListById(3l);
        logger.info(firstList);
    }

    @Test
    public void queryFirstListsByNameAndStatus() throws Exception {
        List<FirstList> firstLists = firstListService.queryFirstListsByNameAndStatus((short) 0, "油画");
        for (FirstList list:firstLists
             ) {
            logger.info(list);
        }
    }
}
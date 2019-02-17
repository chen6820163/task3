package com.jnshu.task3.service.interfaces;

import com.jnshu.task3.common.bean.Author;
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
public class IAuthorServiceTest {
    private static Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
    @Autowired
    public IAuthorService authorService;
    @Test
    public void saveAuthor() throws Exception {
        Author author = new Author(null,"齐大千",18375243639l,"大千","齐大千,一个优秀的画家",(short) 0,(short)0,System.currentTimeMillis(),System.currentTimeMillis(),"梵高");
        long l = authorService.saveAuthor(author);
        logger.info(author.getId());
        logger.info(l);
    }

    @Test
    public void deleteAuthorById() throws Exception {
        boolean b = authorService.deleteAuthorById(3l);
        if (true == b) {
            logger.info("删除成功");
        } else {
            logger.info("删除失败");
        }
    }

    @Test
    public void updateAuthor() throws Exception {
        Author author = new Author(2l,"齐大千",18375243639l,"张大千","齐大千,一个优秀的画家",(short) 0,(short)0,System.currentTimeMillis(),System.currentTimeMillis(),"梵高");
        boolean b = authorService.updateAuthor(author);
        if (true == b) {
            logger.info("更新成功");
        } else {
            logger.info("更新失败");
        }
    }

    @Test
    public void queryAuthorById() throws Exception {
        Author author = authorService.queryAuthorById(1l);
        logger.info("查询成功");
        logger.info(author);
    }

    @Test
    public void queryAuthorsByNameAndStatus() throws Exception {
        List<Author> authors = authorService.queryAuthorsByNameAndStatus((short) 0, "齐大千");
        logger.info("查询成功");
        for (Author author:authors
        ) {
            logger.info(author);
        }
    }
}
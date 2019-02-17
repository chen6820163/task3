package com.jnshu.task3.service.impl;

import com.jnshu.task3.common.bean.Author;
import com.jnshu.task3.common.bean.Banner;
import com.jnshu.task3.dao.AuthorMapper;
import com.jnshu.task3.service.interfaces.IAuthorService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: task3
 * @description:
 * @author: Mr.Chen
 * @create: 2019-01-20 17:47
 * @contact:938738637@qq.com
 **/
@Service
public class AuthorServiceImpl implements IAuthorService {
    private static Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
    @Autowired
    public AuthorMapper authorMapper;

    @Override
    public long saveAuthor(Author author) throws Exception {
        if (author == null) {
            logger.error("传入author为空，添加author信息失败");
            throw new Exception("传入author为空");
        }
        Long i = authorMapper.insert(author);
        return i;
    }

    @Override
    public boolean deleteAuthorById(Long id) throws Exception {
        if (id == null) {
            logger.error("传入author为空，删除作者信息失败");
            throw new Exception("传入id失败");
        }
        boolean b = authorMapper.deleteByPrimaryKey(id);
        return b;
    }

    @Override
    public boolean updateAuthor(Author author) throws Exception {
        if (author==null) {
            throw new Exception("修改author信息失败");
        }
        boolean b = authorMapper.updateByPrimaryKeySelective(author);
        return b;
    }

    @Override
    public Author queryAuthorById(Long id) throws Exception {
        if (id == null) {
            throw new Exception("传入id失败");
        }
        Author author = authorMapper.selectByPrimaryKey(id);
        if (author == null) {
            throw new Exception("查询id为"+id+"的author信息失败");
        }
        return author;
    }

    @Override
    public List<Author> queryAuthorsByNameAndStatus(Short status, String name) throws Exception {
        List<Author> authors = authorMapper.selectBystatusAndName(status, name);
        if(authors.size()==0&&authors==null) {
            throw new Exception("author表目前没有数据，请先添加author");
        }
        return authors;
    }
}

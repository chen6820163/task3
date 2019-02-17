package com.jnshu.task3.service.interfaces;

import com.jnshu.task3.common.bean.Author;

import java.util.List;

public interface IAuthorService  {
    long saveAuthor(Author author) throws Exception;

    boolean deleteAuthorById(Long id) throws Exception;

    boolean updateAuthor(Author author) throws Exception;

    Author queryAuthorById(Long id) throws Exception;

    List<Author> queryAuthorsByNameAndStatus(Short status, String name) throws Exception;
}

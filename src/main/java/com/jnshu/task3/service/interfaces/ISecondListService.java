package com.jnshu.task3.service.interfaces;

import com.jnshu.task3.common.bean.SecondList;

import java.util.List;

public interface ISecondListService {
    long saveSecondList(SecondList secondList) throws Exception;

    boolean deleteSecondListById(Long id) throws Exception;

    boolean updateSecondList(SecondList secondList) throws Exception;

    SecondList querySecondListById(Long id) throws Exception;

    List<SecondList> querySecondListsByNameAndStatus(Short status, String name) throws Exception;
}

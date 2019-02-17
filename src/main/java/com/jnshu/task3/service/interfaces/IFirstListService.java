package com.jnshu.task3.service.interfaces;

import com.jnshu.task3.common.bean.Banner;
import com.jnshu.task3.common.bean.FirstList;

import java.util.List;

public interface IFirstListService {
    long saveFirstList(FirstList firstList) throws Exception;

    boolean deleteFirstListById(Long id) throws Exception;

    boolean updateFirstList(FirstList firstList) throws Exception;

    FirstList queryFirstListById(Long id) throws Exception;

    List<FirstList> queryFirstListsByNameAndStatus(Short status, String creator) throws Exception;
}

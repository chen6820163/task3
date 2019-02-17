package com.jnshu.task3.service.interfaces;

import com.jnshu.task3.common.bean.Work;

import java.util.List;

public interface IWorkService {
    long saveWork(Work work) throws Exception;

    boolean deleteWorkById(Long id) throws Exception;

    boolean updateWork(Work work) throws Exception;

    Work queryWorkById(Long id) throws Exception;

    List<Work> queryWorksByNameAndStatus(Short status, String name) throws Exception;
}

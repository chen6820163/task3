package com.jnshu.task3.service.interfaces;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-mybatis.xml")
public class ISecondListServiceTest {

    @Test
    public void saveSecondList() {
        System.out.println(System.currentTimeMillis());
    }

    @Test
    public void deleteSecondListById() {
    }

    @Test
    public void updateSecondList() {
    }

    @Test
    public void querySecondListById() {
    }

    @Test
    public void querySecondListsByNameAndStatus() {
    }
}
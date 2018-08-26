package com.huawei.service.impl;

import com.huawei.dao.TestDao;
import com.huawei.pojo.Test;
import com.huawei.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private TestDao testDao;

    @Transactional
    public List<Test> getAllTest() {
        System.out.println("123");
        return testDao.findAll();
    }
}

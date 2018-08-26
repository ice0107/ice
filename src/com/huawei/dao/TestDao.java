package com.huawei.dao;

import com.huawei.pojo.Test;

import java.util.List;

public interface TestDao extends HibernateBaseDao {

    public List<Test> getAllTest();
}

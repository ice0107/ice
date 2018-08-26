package com.huawei.dao.impl;

import com.huawei.dao.TestDao;
import com.huawei.pojo.Test;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TestDaoImpl extends HibernateBaseDaoImpl implements TestDao {

    public List<Test> getAllTest() {
        Transaction tr = this.getSession().beginTransaction();

        List<Test> list = (List<Test>)this.getSession().createQuery( "from Test").list();
        tr.commit();

        return list;
    }
}

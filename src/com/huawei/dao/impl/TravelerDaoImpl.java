//package com.huawei.dao.impl;
//
//import org.hibernate.Query;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
//@Repository
//public class TravelerDaoImpl extends HibernateBaseDaoImpl implements TravelerDao {
//
//    public Traveler login(String mail, String password) {
//
//        Query query = getSession().createQuery("from Traveler where email=? and password=?");
//        query.setParameter(0, mail);
//        query.setParameter(1, password);
//        List<Traveler> list = query.list();
//        if (list != null && list.size() != 0) {
//            return list.get(0);
//        }
//        else {
//            return null;
//        }
//    }
//
//    public List<Traveler> getTop10Answers() {
//        Query query = getSession().createQuery("from Traveler order by answerNum desc");
//        query.setMaxResults(10);
//
//        List<Traveler> list = query.list();
//        if (list != null && list.size() != 0) {
//            return list;
//        }
//        else {
//            return null;
//        }
//    }
//
//    public Traveler getTravelerByUserId(Integer userId) {
//        Query query = getSession().createQuery("from Traveler where userId=?");
//        query.setParameter(0, userId);
//        List<Traveler> list = query.list();
//        if (list != null && list.size() != 0) {
//            return list.get(0);
//        }
//        else {
//            return null;
//        }
//    }
//}

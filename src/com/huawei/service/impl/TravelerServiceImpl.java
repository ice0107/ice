//package com.huawei.service.impl;
//
//import com.huawei.common.ConstUtil;
//import com.huawei.dao.*;
//import com.huawei.pojo.model.*;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Service
//public class TravelerServiceImpl implements TravelerService {
//
//    @Autowired
//    private TravelerDao travelerDao;
//    @Autowired
//    private FollowRelationDao followRelationDao;
//    @Autowired
//    private ArticleDao articleDao;
//    @Autowired
//    private ArticleCommentDao articleCommentDao;
//    @Autowired
//    private AnswerDao answerDao;
//    @Autowired
//    private QuestionDao questionDao;
//    @Autowired
//    private MyFollowQuestionDao myFollowQuestionDao;
//
//    @Transactional
//    public TravelerInfo login(String mail, String password) {
//        Traveler traveler = travelerDao.login(mail, password);
//
//        TravelerInfo travelerInfo = null;
//
//        if (null != traveler) {
//            travelerInfo = new TravelerInfo();
//            travelerInfo.setName(traveler.getUserName());
//            travelerInfo.setHeadPhoto(traveler.getHeadPhoto());
//            travelerInfo.setUserId(traveler.getUserId());
//        }
//
//        return travelerInfo;
//    }
//
//    @Transactional
//    public TravelerInfo register(String name, String password, String mail) {
//        Traveler traveler = new Traveler();
//        traveler.setUserName(name);
//        traveler.setPassword(password);
//        traveler.setEmail(mail);
//        traveler.setAnswerNum(0);
//        traveler.setFansNum(0);
//        traveler.setFollowNum(0);
//        traveler.setUserType(new UserType(1, "普通用户"));
//
//        int userId = (Integer) travelerDao.save(traveler);
//
//        TravelerInfo travelerInfo = new TravelerInfo();
//        travelerInfo.setName(name);
//        travelerInfo.setHeadPhoto(ConstUtil.HEADPHOTO_DEFAULT_URL);
//        travelerInfo.setUserId(userId);
//
//        return travelerInfo;
//    }
//
//    @Transactional
//    public List<TravelerInfo> getTop10Answers() {
//        TravelerInfo travelerInfo = null;
//        List<TravelerInfo> travelerInfoList = new ArrayList<TravelerInfo>();
//        List<Traveler> travelerList = travelerDao.getTop10Answers();
//
//        for (int i = 0; i < travelerList.size(); i ++) {
//            travelerInfo = new TravelerInfo();
//            travelerInfo.setName(travelerList.get(i).getUserName());
//            travelerInfo.setHeadPhoto(travelerList.get(i).getHeadPhoto());
//            travelerInfo.setUserId(travelerList.get(i).getUserId());
//            travelerInfo.setAnswerNum(travelerList.get(i).getAnswerNum());
//            travelerInfoList.add(travelerInfo);
//        }
//
//        return travelerInfoList;
//
//    }
//
//    @Transactional
//    public boolean followUsers(Integer userId, Integer followedId) {
//        FollowRelation followRelation = new FollowRelation();
//        Traveler traveler1 = travelerDao.getTravelerByUserId(userId);
//        Traveler traveler2 = travelerDao.getTravelerByUserId(followedId);
//
//        followRelation.setTravelerByFkUserId(traveler1);
//        followRelation.setTravelerByFkFollowerId(traveler2);
//
//        Integer frId = (Integer)followRelationDao.save(followRelation);
//
//        if(frId > 0) {
//            traveler1.setFollowNum(traveler1.getFollowNum() + 1);
//            traveler2.setFansNum(traveler2.getFansNum() + 1);
//            travelerDao.update(traveler1);
//            travelerDao.update(traveler2);
//            return true;
//        }
//        else
//            return false;
//
//    }
//
//    @Transactional
//    public boolean unFollowUsers(Integer userId, Integer followedId) {
//        FollowRelation followRelation = followRelationDao.getFollowRelationByTwoParam(userId, followedId);
//        Traveler traveler1 = travelerDao.getTravelerByUserId(userId);
//        Traveler traveler2 = travelerDao.getTravelerByUserId(followedId);
//
//        followRelationDao.delete(followRelation);
//
//        traveler1.setFollowNum(traveler1.getFollowNum() - 1);
//        traveler2.setFansNum(traveler2.getFansNum() - 1);
//        travelerDao.update(traveler1);
//        travelerDao.update(traveler2);
//        return true;
//    }
//
//    @Transactional
//    public NoteBean getTravelInfo(Integer userId, Integer page, Integer maxItem) {
//        NoteBean noteBean = new NoteBean();
//        Traveler traveler = travelerDao.getTravelerByUserId(userId);
//        noteBean.setFansNum(traveler.getFansNum());
//        noteBean.setFollowNum(traveler.getFollowNum());
//
//        List<Article> articleList = articleDao.getArticleListByUserId(userId, page, maxItem);
//        Integer articleNum = 0;
//        Integer allArticleNum = 0;
//        Integer allPage = 0;
//        List<Article> allArticleList = articleDao.getArticleListByUserId(userId, 1, 10000000);
//
//        if (null != allArticleList) {
//            allArticleNum = allArticleList.size();
//            allPage = (allArticleNum - 1) / maxItem + 1;
//        }
//
//
//        Integer articleCommentNum = 0;
//        //获取用户被评论的数量
//        List<ArticleComment> articleCommentList = articleCommentDao.getArticleCommentByUserId(userId);
//        if (articleCommentList != null)
//            articleCommentNum = articleCommentList.size();
//
//        noteBean.setArticleNum(allArticleNum);
//        noteBean.setAllPage(allPage);
//        noteBean.setArticleList(articleList);
//        noteBean.setCommentNum(articleCommentNum);
//
//        return noteBean;
//    }
//
//    @Transactional
//    public MyAnswerBean getMyAnswer(Integer userId) {
//        MyAnswerBean myAnswerBean = new MyAnswerBean();
//        Traveler traveler = travelerDao.getTravelerByUserId(userId);
//        List<Answer> answerList = answerDao.getAnswerListByUserId(userId);
//
//        myAnswerBean.setFollowNum(traveler.getFollowNum());
//        myAnswerBean.setFansNum(traveler.getFansNum());
//        myAnswerBean.setAnswerList(answerList);
//
//        return myAnswerBean;
//    }
//
//    @Transactional
//    public MyQuestionBean getMyQuestionBean(Integer userId) {
//        MyQuestionBean myQuestionBean = new MyQuestionBean();
//        Traveler traveler = travelerDao.getTravelerByUserId(userId);
//        List<Question> questionList = questionDao.getQuestionListByUserId(userId);
//
//        myQuestionBean.setFollowNum(traveler.getFollowNum());
//        myQuestionBean.setFansNum(traveler.getFansNum());
//        myQuestionBean.setQuestionList(questionList);
//
//        return myQuestionBean;
//    }
//
//    @Transactional
//    public FollowQuestionBean getFollowQuestionBean(Integer userId) {
//        FollowQuestionBean followQuestionBean = new FollowQuestionBean();
//        Traveler traveler = travelerDao.getTravelerByUserId(userId);
//        List<MyFollowQuestion> myFollowQuestionList = myFollowQuestionDao.getFollowQuestionListByUserIdFollowed(userId);
//
//        followQuestionBean.setFollowNum(traveler.getFollowNum());
//        followQuestionBean.setFansNum(traveler.getFansNum());
//        followQuestionBean.setMyFollowQuestionList(myFollowQuestionList);
//
//        return followQuestionBean;
//    }
//
//    public Traveler getTravelInfoSetting(Integer userId) {
//        return travelerDao.getTravelerByUserId(userId);
//    }
//
//    @Transactional
//    public boolean setTravelInfoSetting(Integer userId, String nickname, boolean sex, String email, String phone, String description) {
//        Traveler traveler = travelerDao.getTravelerByUserId(userId);
//        traveler.setUserName(nickname);
//        traveler.setEmail(email);
//        traveler.setSex(sex);
//        traveler.setContact(phone);
//        traveler.setDescription(description);
//
//        travelerDao.update(traveler);
//        return true;
//    }
//
//    @Transactional
//    public boolean modifyPassword(Integer userId, String password) {
//        Traveler traveler = travelerDao.getTravelerByUserId(userId);
//        traveler.setPassword(password);
//
//        travelerDao.update(traveler);
//
//        return true;
//    }
//}

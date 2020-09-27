package com.verizon.lambda.service;

import com.verizon.lambda.dao.UserActivityDao;
import com.verizon.lambda.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserActivityServiceImpl implements UserActivityService {

    private UserActivityDao userActivityDao;

    public UserActivityDao getUserActivityDao() {
        return userActivityDao;
    }

    @Autowired
    public void setUserActivityDao(UserActivityDao userActivityDao) {
        this.userActivityDao = userActivityDao;
    }

    @Override
    public UserActivityDetails addUserActivity(UserActivityDetails userActivityDetails)
    {
        getUserActivityDao().save(userActivityDetails);
        return userActivityDetails;
    }

    @Override
    public UserActivityDetails findByUserId(String uid){
        UserActivityDetails userActivityDetails=userActivityDao.findByUserId(uid);
        return userActivityDetails;
    }

    @Override
    public int updatePoints(String userId, Point points)
    {
        UserActivityDetails userActivityDetails = findByUserId(userId);
        userActivityDetails.setPoints(userActivityDetails.getPoints()+points.getPoints());
        getUserActivityDao().save(userActivityDetails);
        return points.getPoints();
    }

    @Override
    public UserActivityDetails updateQuestionId(String userId, QuestionId questionId)
    {
        UserActivityDetails userActivityDetails = findByUserId(userId);
        userActivityDetails.getQuestionIds().add(questionId.getQuestionIds());
        System.out.println(userActivityDetails.getQuestionIds());
        userActivityDetails.setQuestionIds(userActivityDetails.getQuestionIds());
        getUserActivityDao().save(userActivityDetails);
        return userActivityDetails;
    }

    @Override
    public UserActivityDetails deleteQuestionId(String userId, QuestionId questionId)
    {
        UserActivityDetails userActivityDetails = findByUserId(userId);
        userActivityDetails.getQuestionIds().remove(questionId.getQuestionIds());
        getUserActivityDao().save(userActivityDetails);
        return userActivityDetails;
    }
    @Override
    public UserActivityDetails updateAnswerId(String userId, AnswerId answerId)
    {
        UserActivityDetails userActivityDetails = findByUserId(userId);
        userActivityDetails.getAnswerIds().add(answerId.getAnswerIds());
        userActivityDetails.setAnswerIds(userActivityDetails.getAnswerIds());
        getUserActivityDao().save(userActivityDetails);
        return userActivityDetails;
    }

    @Override
    public UserActivityDetails deleteAnswerId(String userId, AnswerId answerId)
    {
        UserActivityDetails userActivityDetails = findByUserId(userId);
        userActivityDetails.getAnswerIds().remove(answerId.getAnswerIds());
        getUserActivityDao().save(userActivityDetails);
        return userActivityDetails;
    }

    @Override
    public UserActivityDetails updateFollowerId(String userId, Follower follower){
        UserActivityDetails userActivityDetails=findByUserId(userId);
        userActivityDetails.getFollowerIds().add(follower.getFollowerIds());
        userActivityDetails.setFollowerIds(userActivityDetails.getFollowerIds());
        getUserActivityDao().save(userActivityDetails);
        return userActivityDetails;
    }

    @Override
    public UserActivityDetails deleteFollowerId(String userId, Follower follower){
        UserActivityDetails userActivityDetails=findByUserId(userId);
        userActivityDetails.getFollowerIds().remove(follower.getFollowerIds());
        getUserActivityDao().save(userActivityDetails);
        return userActivityDetails;
    }

    @Override
    public UserActivityDetails updateFollowingUser(String userId, FollowingUser followingUser){
        UserActivityDetails userActivityDetails=findByUserId(userId);
        userActivityDetails.getFollowingUserIds().add(followingUser.getFollowingUserIds());
        userActivityDetails.setFollowingUserIds(userActivityDetails.getFollowingUserIds());
        getUserActivityDao().save(userActivityDetails);
        return userActivityDetails;
    }

    @Override
    public UserActivityDetails deleteFollowingUser(String userId, FollowingUser followingUser){
        UserActivityDetails userActivityDetails=findByUserId(userId);
        userActivityDetails.getFollowingUserIds().remove(followingUser.getFollowingUserIds());
        getUserActivityDao().save(userActivityDetails);
        return userActivityDetails;
    }

    @Override
    public UserActivityDetails updateFollowingQuestion(String userId, FollowingQuestion followingQuestion){
        UserActivityDetails userActivityDetails=findByUserId(userId);
        userActivityDetails.getFollowingQuestionIds().add(followingQuestion.getFollowingQuestionIds());
        userActivityDetails.setFollowingQuestionIds(userActivityDetails.getFollowingQuestionIds());
        getUserActivityDao().save(userActivityDetails);
        return userActivityDetails;
    }

    @Override
    public UserActivityDetails deleteFollowingQuestion(String userId, FollowingQuestion followingQuestion){
        UserActivityDetails userActivityDetails=findByUserId(userId);
        userActivityDetails.getFollowingQuestionIds().remove(followingQuestion.getFollowingQuestionIds());
        getUserActivityDao().save(userActivityDetails);
        return userActivityDetails;
    }

    @Override
    public UserActivityDetails updateFollowingTopic(String userId, FollowTopic followTopic){
        UserActivityDetails userActivityDetails=findByUserId(userId);
        userActivityDetails.getFollowingTopicIds().add(followTopic.getFollowingTopicIds());
        userActivityDetails.setFollowingTopicIds(userActivityDetails.getFollowingTopicIds());
        getUserActivityDao().save(userActivityDetails);
        return userActivityDetails;
    }

    @Override
    public UserActivityDetails deleteFollowingTopic(String userId, FollowTopic followTopic){
        UserActivityDetails userActivityDetails=findByUserId(userId);
        userActivityDetails.getFollowingTopicIds().remove(followTopic.getFollowingTopicIds());
        getUserActivityDao().save(userActivityDetails);
        return  userActivityDetails;
    }

    @Override
    public int updateAnswerReports(String userId, AnswerReport answerReport){
        UserActivityDetails userActivityDetails=findByUserId(userId);
        userActivityDetails.setAnswerReportCount(userActivityDetails.getAnswerReportCount()+answerReport.getAnswerReportCount());
        getUserActivityDao().save(userActivityDetails);
        return answerReport.getAnswerReportCount();
    }

    @Override
    public int updateQuestionReports(String userId, QuestionReport questionReport){
        UserActivityDetails userActivityDetails=findByUserId(userId);
        userActivityDetails.setQuestionReportCount(userActivityDetails.getQuestionReportCount()+questionReport.getQuestionReportCount());
        getUserActivityDao().save(userActivityDetails);
        return questionReport.getQuestionReportCount();
    }
}

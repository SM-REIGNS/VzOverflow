package com.verizon.lambda.service;

import com.verizon.lambda.entities.*;

public interface UserActivityService {

    UserActivityDetails addUserActivity(UserActivityDetails userActivityDetails);
    UserActivityDetails findByUserId(String uid);
    int updatePoints(String userId, Point points);
    UserActivityDetails updateQuestionId(String userId, QuestionId questionId);
    UserActivityDetails deleteQuestionId(String userId, QuestionId questionId);
    UserActivityDetails updateAnswerId(String userId, AnswerId answerId);
    UserActivityDetails deleteAnswerId(String userId, AnswerId answerId);
    UserActivityDetails updateFollowerId(String userId, Follower follower);
    UserActivityDetails deleteFollowerId(String userId, Follower follower);
    UserActivityDetails updateFollowingUser(String userId, FollowingUser followingUser);
    UserActivityDetails deleteFollowingUser(String userId, FollowingUser followingUser);
    UserActivityDetails updateFollowingQuestion(String userId, FollowingQuestion followingQuestion);
    UserActivityDetails deleteFollowingQuestion(String userId, FollowingQuestion followingQuestion);
    UserActivityDetails updateFollowingTopic(String userId, FollowTopic followTopic);
    UserActivityDetails deleteFollowingTopic(String userId, FollowTopic followTopic);
    int updateAnswerReports(String userId, AnswerReport answerReport);
    int updateQuestionReports(String userId, QuestionReport questionReport);
}

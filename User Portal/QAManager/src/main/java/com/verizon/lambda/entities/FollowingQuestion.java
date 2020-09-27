package com.verizon.lambda.entities;

public class FollowingQuestion {
    private String followingQuestionIds;

    public FollowingQuestion() {
    }

    public FollowingQuestion(String followingQuestionIds) {
        this.followingQuestionIds = followingQuestionIds;
    }

    public String getFollowingQuestionIds() {
        return followingQuestionIds;
    }

    public void setFollowingQuestionIds(String followingQuestionIds) {
        this.followingQuestionIds = followingQuestionIds;
    }

}

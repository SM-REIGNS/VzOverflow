package com.verizon.lambda.entities;

public class FollowTopic {
    private String followingTopicIds;


    public FollowTopic() {
    }

    public FollowTopic(String followingTopicIds) {
        this.followingTopicIds = followingTopicIds;

    }

    public String getFollowingTopicIds() {
        return followingTopicIds;
    }

    public void setFollowingTopicIds(String followingTopicIds) {
        this.followingTopicIds = followingTopicIds;
    }

}

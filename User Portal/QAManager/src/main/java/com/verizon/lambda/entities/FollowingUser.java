package com.verizon.lambda.entities;

public class FollowingUser {
    private String followingUserIds;


    public FollowingUser() {
    }

    public FollowingUser(String followingUserIds) {
        this.followingUserIds = followingUserIds;
    }

    public String getFollowingUserIds() {
        return followingUserIds;
    }

    public void setFollowingUserIds(String followingUserIds) {
        this.followingUserIds = followingUserIds;
    }


}

package com.verizon.lambda.entities;

public class Follower {
   private String followerIds;


    public Follower() {
    }

    public Follower(String followerIds) {
        this.followerIds = followerIds;
    }

    public String getFollowerIds() {
        return followerIds;
    }

    public void setFollowerIds(String followerIds) {
        this.followerIds = followerIds;
    }

}

package com.verizon.lambda.entities;

import java.util.Set;

import org.springframework.data.mongodb.core.mapping.Document;

@Document("useractivitydetails")
public class UserActivityDetails {

	 private String userId;
	    private int points;
	    private Set<String> questionIds;
	    private Set<String> answerIds;
	    private Set<String> followerIds;
	    private Set<String> followingUserIds;
	    private Set<String> followingQuestionIds;
	    private Set<String> followingTopicIds;
	    private int questionReportCount;
	    private int answerReportCount;
		public String getUserId() {
			return userId;
		}
		public void setUserId(String userId) {
			this.userId = userId;
		}
		public int getPoints() {
			return points;
		}
		public void setPoints(int points) {
			this.points = points;
		}
		
		public int getQuestionReportCount() {
			return questionReportCount;
		}
		public void setQuestionReportCount(int questionReportCount) {
			this.questionReportCount = questionReportCount;
		}
		public int getAnswerReportCount() {
			return answerReportCount;
		}
		public void setAnswerReportCount(int answerReportCount) {
			this.answerReportCount = answerReportCount;
		}
		
		public UserActivityDetails(String userId, int points, Set<String> questionIds, Set<String> answerIds,
				Set<String> followerIds, Set<String> followingUserIds, Set<String> followingQuestionIds,
				Set<String> followingTopicIds, int questionReportCount, int answerReportCount) {
			super();
			this.userId = userId;
			this.points = points;
			this.questionIds = questionIds;
			this.answerIds = answerIds;
			this.followerIds = followerIds;
			this.followingUserIds = followingUserIds;
			this.followingQuestionIds = followingQuestionIds;
			this.followingTopicIds = followingTopicIds;
			this.questionReportCount = questionReportCount;
			this.answerReportCount = answerReportCount;
		}
		public Set<String> getQuestionIds() {
			return questionIds;
		}
		public void setQuestionIds(Set<String> questionIds) {
			this.questionIds = questionIds;
		}
		public Set<String> getAnswerIds() {
			return answerIds;
		}
		public void setAnswerIds(Set<String> answerIds) {
			this.answerIds = answerIds;
		}
		public Set<String> getFollowerIds() {
			return followerIds;
		}
		public void setFollowerIds(Set<String> followerIds) {
			this.followerIds = followerIds;
		}
		public Set<String> getFollowingUserIds() {
			return followingUserIds;
		}
		public void setFollowingUserIds(Set<String> followingUserIds) {
			this.followingUserIds = followingUserIds;
		}
		public Set<String> getFollowingQuestionIds() {
			return followingQuestionIds;
		}
		public void setFollowingQuestionIds(Set<String> followingQuestionIds) {
			this.followingQuestionIds = followingQuestionIds;
		}
		public Set<String> getFollowingTopicIds() {
			return followingTopicIds;
		}
		public void setFollowingTopicIds(Set<String> followingTopicIds) {
			this.followingTopicIds = followingTopicIds;
		}
		public UserActivityDetails(){
			
		}
		
		
	
	
}

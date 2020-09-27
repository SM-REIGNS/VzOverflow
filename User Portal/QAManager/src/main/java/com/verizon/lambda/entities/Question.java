package com.verizon.lambda.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("questions")
public class Question implements Serializable {



	@Id
	private String id;
	private String question;
	private String postedBy;

	private String postedOn;

	private Set<String> answerIds = new HashSet<>();

	private Set<String> followers = new HashSet<>();

	private Set<String> topic = new HashSet<>();

	private Set<String> reportedBy = new HashSet<>();

	public Question() {

	}

	public String getId() {
		return id;
	}

	public String getPostedOn() {
		return postedOn;
	}


	public Question(String question, String postedBy, Set<String> answerIds, Set<String> followers, Set<String> topic,
					Set<String> reportedBy) {
		this.question = question;
		this.postedBy = postedBy;
		this.answerIds = answerIds;
		this.followers = followers;
		this.topic = topic;
		this.reportedBy = reportedBy;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (obj == null || !(obj instanceof Question)) {
			return false;
		}
		Question u = (Question) obj;
		return u.id.equals(this.id);
	}

	public Set<String> getAnswerIds() {
		return answerIds;
	}

	String getDateAndTime() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		return dtf.format(now);

	}

	public Set<String> getFollowers() {
		return followers;
	}


	public String getPostedBy() {
		return postedBy;
	}

	public String getQuestion() {
		return question;
	}

	public Set<String> getReportedBy() {
		return reportedBy;
	}

	public Set<String> getTopic() {
		return topic;
	}

	@Override
	public int hashCode() {
		if (id == null) {
			return 0;
		}
		return id.hashCode();
	}

	public void setAnswerIds(Set<String> answerIds) {
		this.answerIds = answerIds;
	}

	public void setFollowers(Set<String> followers) {
		this.followers = followers;
	}

	public void setId(String id) {

		this.postedOn = this.getDateAndTime();
		this.id = id;
	}

	public void setPostedBy(String postedBy) {
		this.postedBy = postedBy;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public void setReportedBy(Set<String> reportedBy) {
		this.reportedBy = reportedBy;
	}

	public void setTopic(Set<String> topic) {
		this.topic = topic;
	}

}

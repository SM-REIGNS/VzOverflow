package com.verizon.lambda.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("answers")
public class Answer implements Serializable {
	@Id
	private String id;

	private String answer;

	private String answeredBy;

	private String answeredOn;
	private String questionId;
	private Set<String> upvotes = new HashSet<>();
	private Set<String> reports = new HashSet<>();

	public Answer() {
	}

	public Answer(String id, String answer, String answeredBy, String questionId, Set<String> upvotes,
			Set<String> reports) {
		this.id = id;
		this.answer = answer;
		this.answeredBy = answeredBy;
		this.questionId = questionId;
		this.upvotes = upvotes;
		this.reports = reports;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (obj == null || !(obj.getClass().equals(Answer.class))) {
			return false;
		}
		Answer u = (Answer) obj;
		return u.id.equals(this.id);
	}

	public String getAnswer() {
		return answer;
	}

	public String getAnsweredBy() {
		return answeredBy;
	}

	String getDateAndTime() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		return dtf.format(now);

	}

	public String getId() {
		return id;
	}

	public String getQuestionId() {
		return questionId;
	}

	public Set<String> getReports() {
		return reports;
	}

	public Set<String> getUpvotes() {
		return upvotes;
	}

	@Override
	public int hashCode() {
		if (id == null) {
			return 0;
		}
		return id.hashCode();
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public void setAnsweredBy(String answeredBy) {
		this.answeredBy = answeredBy;
	}

	public void setAnsweredOn() {
		this.answeredOn = this.getDateAndTime();
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setQuestionId(String questionId) {
		this.questionId = questionId;
	}

	public void setReports(Set<String> reports) {
		this.reports = reports;
	}

	public void setUpvotes(Set<String> upvotes) {
		this.upvotes = upvotes;
	}

}

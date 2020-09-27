package com.verizon.lambda.entities;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.Document;

@Document("topics")
public class Topic implements Serializable {

	String topicName;

	public Topic() {

	}

	public Topic(String topicName) {

		this.topicName = topicName;
	}

	public String getTopicName() {
		return topicName;
	}

	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}

}

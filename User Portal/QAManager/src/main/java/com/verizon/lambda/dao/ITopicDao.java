package com.verizon.lambda.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.verizon.lambda.entities.Topic;

public interface ITopicDao extends MongoRepository<Topic, String> {

	void deleteByTopicName(String topicName);

	Topic findByTopicName(String topicName);

}

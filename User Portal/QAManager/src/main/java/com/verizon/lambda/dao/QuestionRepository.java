package com.verizon.lambda.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.verizon.lambda.entities.Question;

public interface QuestionRepository extends MongoRepository<Question, String> {

	// public List<Question> findByTopic(String topic);

	public List<Question> findByfollowers(String topic);

	public List<Question> findBypostedBy(String postedBy);

	public List<Question> findBytopic(String topicName);

}

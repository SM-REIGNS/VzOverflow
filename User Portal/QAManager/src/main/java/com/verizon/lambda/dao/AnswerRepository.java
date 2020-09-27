package com.verizon.lambda.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.verizon.lambda.entities.Answer;

public interface AnswerRepository extends MongoRepository<Answer, String> {
	public List<Answer> findByansweredBy(String id);
	public List<Answer> findByQuestionId(String id);
}

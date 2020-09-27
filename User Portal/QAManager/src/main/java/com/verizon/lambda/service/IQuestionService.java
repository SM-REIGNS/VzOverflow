package com.verizon.lambda.service;

import java.util.List;

import com.verizon.lambda.entities.Follow;
import com.verizon.lambda.entities.Question;
import com.verizon.lambda.entities.ReportQuestion;
import com.verizon.lambda.entities.ReportUser;

public interface IQuestionService {

	void add(Question e);

	Question findQuestionById(String id);

	List<Question> findQuestionsByTopic(String topic);

	List<Question> findQuestionsFollowedByEmployee(String follower);

	List<Question> findQuestionsPostedByEmployee(String empid);

	void followQuestion(Follow follow);

	String getNextSequence(String seqName);

	List<Question> findAllQuestions();

	void remove(String questionId);

	void reportQuestion(ReportQuestion reportQuestion);

	void updateQuestion(Question e, String id);

}

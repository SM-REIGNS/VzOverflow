package com.verizon.lambda.service;

import java.util.List;

import com.verizon.lambda.entities.Answer;
import com.verizon.lambda.entities.Report;
import com.verizon.lambda.entities.Upvote;
import org.springframework.http.ResponseEntity;

public interface IAnswerService {
	Answer findAnswerById(String id);

	List<Answer> findByAnsweredBy(String id);

	List<Answer> findAnswerByQuestioniId(String id);

	void remove(String id);
	public String getNextSequence(String seqName);

	Report report(Report report);

	Answer save(Answer answer);

	Answer updateAnswer(Answer answer, String id);

	void updateVotes(Upvote upvote);
}

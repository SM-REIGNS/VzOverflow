package com.verizon.lambda.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.verizon.lambda.dao.QuestionRepository;
import com.verizon.lambda.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.verizon.lambda.dao.AnswerRepository;
import com.verizon.lambda.exceptions.AnswerNotFoundException;

import javax.xml.ws.Response;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

@Service
@Transactional
public class AnswerServiceImpl implements IAnswerService {

	private AnswerRepository answerDao;

	@Autowired
	private MongoOperations mongo;

	@Autowired
	private UserActivityService userActivityService;

	@Override
	public String getNextSequence(String seqName) {
		AnswerSequenceCounter counter = mongo.findAndModify(query(where("_id").is(seqName)), new Update().inc("seq", 1),
				options().returnNew(true).upsert(true), AnswerSequenceCounter.class);
		return Integer.toString(counter.getSeq());
	}


	@Override
	public List<Answer> findAnswerByQuestioniId(String id) {
		if(id == null) {
			throw new AnswerNotFoundException("answer not found for question id=" + id);
		}
		else {
			List<Answer> answers = answerDao.findByQuestionId(id);
			return answers;
		}
	}


	@Override
	public Answer findAnswerById(String id) {
		System.out.println("inside findAnswerById(*), id=" + id);
		Optional<Answer> optional = answerDao.findById(id);
		if (!optional.isPresent()) {
			throw new AnswerNotFoundException("answer not found for id=" + id);

		}
		return optional.get();

	}

	@Override
	public List<Answer> findByAnsweredBy(String id) {
		List<Answer> list = answerDao.findByansweredBy(id);
		return list;
	}

	public AnswerRepository getAnswerDao() {
		return answerDao;
	}

	@Override
	public void remove(String empId) {
		getAnswerDao().deleteById(empId);
	}

	@Override
	public Report report(Report report) {
		Optional<Answer> optional = answerDao.findById(report.getaId());
		if (!optional.isPresent()) {
			throw new AnswerNotFoundException("answer not found for id=" + report.getaId());
		}
		Answer answer = optional.get();
		answer.getReports().add(report.getuId());
		answer.setReports(answer.getReports());
		getAnswerDao().save(answer);
		userActivityService.updateAnswerReports(answer.getAnsweredBy(),new AnswerReport(1));
		return report;
	}

	@Override
	public Answer save(Answer e) {
		e = getAnswerDao().save(e);
		userActivityService.updateAnswerId(e.getAnsweredBy(),new AnswerId(e.getId()));
		return e;
	}

	@Autowired
	public void setAnswerDao(AnswerRepository dao) {
		this.answerDao = dao;
	}

	@Override
	public Answer updateAnswer(Answer answer, String id) {
		getAnswerDao().save(answer);
		System.out.println(answer.getAnswer() + " " + answer.getAnsweredBy());
		return answer;
	}

	@Override
	public void updateVotes(Upvote upvote) {
		Optional<Answer> optional = answerDao.findById(upvote.getaId());
		if (!optional.isPresent()) {
			throw new AnswerNotFoundException("answer not found for id=" + upvote.getaId());
		}
		Answer answer = optional.get();
		answer.getUpvotes().add(upvote.getuId());
		answer.setUpvotes(answer.getUpvotes());
		userActivityService.updatePoints(answer.getAnsweredBy(),new Point(10));
		getAnswerDao().save(answer);
	}
}

package com.verizon.lambda.service;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.verizon.lambda.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.verizon.lambda.dao.QuestionRepository;
import com.verizon.lambda.exceptions.QuestionNotFoundException;

@Service
public class QuestionServiceImpl implements IQuestionService {

	private QuestionRepository dao;

	@Autowired
	private MongoOperations mongo;

	@Autowired
	private UserActivityService userActivityService;

	@Override
	public void add(Question question) {
		getDao().save(question);
		userActivityService.updateQuestionId(question.getPostedBy(),new QuestionId(question.getId()));

	}

	@Override
	public Question findQuestionById(String id) {
		Optional<Question> optional = dao.findById(id);
		if (!optional.isPresent()) {
			throw new QuestionNotFoundException("question not found for id=" + id);
		}
		Question question = optional.get();
		return question;
	}

	@Override
	public List<Question> findQuestionsFollowedByEmployee(String follower) {
		List<Question> list = dao.findByfollowers(follower);
		return list;
	}

	@Override
	public List<Question> findQuestionsPostedByEmployee(String empid) {

		List<Question> list = dao.findBypostedBy(empid);
		return list;
	}

	@Override
	public List<Question> findAllQuestions() {
		return dao.findAll();
	}

	@Override
	public void followQuestion(Follow follow) throws QuestionNotFoundException{
		Optional<Question> optional = dao.findById(follow.getqId());
		if (!optional.isPresent()) {
			throw new QuestionNotFoundException("question not found for id=" + follow.getqId());
		}
		Question question = optional.get();
		Set<String> followers = question.getFollowers();
		followers.add(follow.getuId());
		question.setFollowers(followers);
		getDao().save(question);
		userActivityService.updateFollowingQuestion(follow.getuId(),new FollowingQuestion(question.getId()));
	}

	public QuestionRepository getDao() {
		return dao;
	}

	@Override
	public String getNextSequence(String seqName) {
		SequenceCounter counter = mongo.findAndModify(query(where("_id").is(seqName)), new Update().inc("seq", 1),
				options().returnNew(true).upsert(true), SequenceCounter.class);
		return Integer.toString(counter.getSeq());
	}

	@Override
	public void remove(String questionId) {
		dao.deleteById(questionId);
	}

	@Override
	public void reportQuestion(ReportQuestion reportQuestion) {
		Optional<Question> optional = dao.findById(reportQuestion.getqId());
		if (!optional.isPresent()) {
			throw new QuestionNotFoundException("question not found for id=" + reportQuestion.getqId());
		}
		Question question = optional.get();
		question.getReportedBy().add(reportQuestion.getuId());
		question.setReportedBy(question.getReportedBy());
		getDao().save(question);
		userActivityService.updateQuestionReports(question.getPostedBy(),new QuestionReport(1));
	}

	@Autowired
	public void setDao(QuestionRepository dao) {
		this.dao = dao;
	}

	@Override
	public void updateQuestion(Question updatedQuestion, String id) {
		Optional<Question> question = getDao().findById(id);
		question.get().setQuestion(updatedQuestion.getQuestion());
		getDao().save(question.get());
	}

	 @Override
	 public List<Question> findQuestionsByTopic(String topic) {
		List<Question> list= getDao().findBytopic(topic);
	 return list;
	 }

}

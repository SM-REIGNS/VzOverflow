package com.verizon.lambda.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.verizon.lambda.dao.ITopicDao;
import com.verizon.lambda.entities.Topic;
import com.verizon.lambda.exceptions.TopicException;

@Service
public class TopicServiceImpl implements ITopicService {
	private ITopicDao topicDao;

	@Override
	public boolean addTopicName(Topic t) {
		if (t == null) {
			throw new TopicException("topic name argument can't be null");
		} else {

			t.setTopicName(t.getTopicName().toLowerCase());
			topicDao.save(t);
			return true;
		}
	}

	@Override
	public void deleteTopicByTopicName(String topicName) {
		topicDao.deleteByTopicName(topicName);
	}

	@Override
	public List<Topic> findAllTopics() {
		return topicDao.findAll();
	}

	@Override
	public Topic findTopicByTopicName(String topicName) {
		Topic topic = topicDao.findByTopicName(topicName);
		return topic;
	}

	public ITopicDao getTopicDao() {
		return topicDao;
	}

	@Autowired
	public void setTopicDao(ITopicDao topicDao) {
		this.topicDao = topicDao;
	}

}

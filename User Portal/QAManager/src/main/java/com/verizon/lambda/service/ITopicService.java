package com.verizon.lambda.service;


import com.verizon.lambda.entities.Topic;

import java.util.List;

public interface ITopicService {


     boolean addTopicName(Topic t);

   void deleteTopicByTopicName(String topicName);

    Topic findTopicByTopicName(String topicName);
    public List<Topic> findAllTopics();
}

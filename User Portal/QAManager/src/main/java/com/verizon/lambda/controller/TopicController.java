package com.verizon.lambda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.verizon.lambda.entities.Topic;
import com.verizon.lambda.exceptions.TopicException;
import com.verizon.lambda.service.ITopicService;

@RestController
public class TopicController {
	@Autowired
	private ITopicService topicService;


	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping(value = "/topic/add")
	public ResponseEntity<String> add(@RequestBody Topic topic) {
		topicService.addTopicName(topic);
		ResponseEntity<String> responseEntity = new ResponseEntity<>("added sucessfully", HttpStatus.OK);
		return responseEntity;
	}

	@DeleteMapping(value = "/topic/delete/{topicName}")
	public ResponseEntity<String> delete(@PathVariable String topicName) {
		topicService.deleteTopicByTopicName(topicName);
		ResponseEntity<String> responseEntity = new ResponseEntity<>("deleted sucessfully", HttpStatus.OK);
		return responseEntity;
	}

	@GetMapping(value = "/topic/find/{topicName}")
	public ResponseEntity<Topic> findTopic(@PathVariable String topicName) {
		Topic topic = topicService.findTopicByTopicName(topicName);
		if (topic == null) {
			throw new TopicException("Topic you searched for is not available");
		}
		ResponseEntity<Topic> responseEntity = new ResponseEntity<>(topic, HttpStatus.OK);
		return responseEntity;

	}

	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping(value = "/topic/findall")
	public ResponseEntity<List<Topic>> findTopics() {
		List<Topic> topics = topicService.findAllTopics();
		if (topics == null) {
			throw new TopicException("Topic you searched for is not available");
		}
		return new ResponseEntity<>(topics, HttpStatus.OK);

	}

	public ITopicService getTopicService() {
		return topicService;
	}

	public void setTopicService(ITopicService topicService) {
		this.topicService = topicService;
	}

}

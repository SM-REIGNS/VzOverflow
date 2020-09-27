package com.verizon.lambda.controller;

import java.util.List;
import java.util.Set;

import com.verizon.lambda.entities.Question;
import com.verizon.lambda.service.IQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.verizon.lambda.entities.Answer;
import com.verizon.lambda.entities.Report;
import com.verizon.lambda.entities.Upvote;
import com.verizon.lambda.service.IAnswerService;

@RestController
public class AnswerController {
	@Autowired
	IAnswerService answerService;

	@Autowired
	IQuestionService questionService;

	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping(value = "/answer/add")
	public ResponseEntity<String> addAnswer(@RequestBody Answer answer) {
		answer.setAnsweredOn();
		answer.setId(answerService.getNextSequence("RANDOM_KEY"));
		answerService.save(answer);

		Question question = questionService.findQuestionById(answer.getQuestionId());
		Set<String> answerIds = question.getAnswerIds();
		answerIds.add(answer.getId());
		question.setAnswerIds(answerIds);

		questionService.add(question);


		ResponseEntity<String> responseEntity = new ResponseEntity<>("answer added successfully", HttpStatus.OK);
		return responseEntity;
	}

	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("answer/findbyquestionid/{id}")
	public ResponseEntity<?> findByQuestionId(@PathVariable String id) {
//		String id = question.getId();
		List<Answer> answers = answerService.findAnswerByQuestioniId(id);
		return new ResponseEntity<>(answers,HttpStatus.OK);
	}


	@DeleteMapping(value = "/answer/deletebyid/{id}")
	public ResponseEntity<String> deleteAnswer(@PathVariable("id") String id) {
		answerService.remove(id);
		ResponseEntity<String> responseEntity = new ResponseEntity<>("removed the answer successfully", HttpStatus.OK);
		return responseEntity;
	}

	@GetMapping(value = "/answer/findbyid/{id}")
	public ResponseEntity<Answer> findAnswer(@PathVariable("id") String id) {
		Answer user = answerService.findAnswerById(id);
		ResponseEntity<Answer> responseEntity = new ResponseEntity<>(user, HttpStatus.OK);
		return responseEntity;
	}

	@GetMapping(value = "/answer/findanswersbyuser/{id}")
	public ResponseEntity<List<Answer>> findAnsweredBy(@PathVariable("id") String id) {
		List<Answer> user = answerService.findByAnsweredBy(id);
		ResponseEntity<List<Answer>> responseEntity = new ResponseEntity<>(user, HttpStatus.OK);
		return responseEntity;
	}

	@CrossOrigin(origins = "http://localhost:3000")
	@PutMapping(value = "/answer/report")
	public ResponseEntity<String> reportAnswer(@RequestBody Report report) {
		Answer answer1 = answerService.findAnswerById(report.getaId());
		if (answer1 == null) {
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}
		answerService.report(report);
		ResponseEntity<String> responseEntity = new ResponseEntity<>("reported successfully", HttpStatus.OK);
		return responseEntity;
	}

	@PutMapping(value = "/answer/updatebyid/{id}")
	public ResponseEntity<String> updateAnswer(@RequestBody Answer answer, @PathVariable("id") String id) {
		answer.setAnsweredOn();
		Answer answer1 = answerService.findAnswerById(id);
		if (answer1 == null) {
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}
		answerService.updateAnswer(answer, id);
		ResponseEntity<String> responseEntity = new ResponseEntity<>("answer updated successfully", HttpStatus.OK);
		return responseEntity;
	}

	@CrossOrigin(origins = "http://localhost:3000")
	@PutMapping(value = "/answer/upvote")
	public ResponseEntity<?> upvoteAnswer(@RequestBody Upvote upvote) {
		Answer answer = answerService.findAnswerById(upvote.getaId());
		if (answer == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		answerService.updateVotes(upvote);

		ResponseEntity<String> responseEntity = new ResponseEntity<>("upvoted successfully", HttpStatus.OK);
		return responseEntity;
	}
}

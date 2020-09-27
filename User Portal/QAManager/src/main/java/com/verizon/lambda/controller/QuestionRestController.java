package com.verizon.lambda.controller;

import java.util.List;

import com.verizon.lambda.entities.ReportQuestion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.verizon.lambda.entities.Follow;
import com.verizon.lambda.entities.Question;
import com.verizon.lambda.entities.ReportUser;
import com.verizon.lambda.service.IQuestionService;

@RestController
public class QuestionRestController {

	@Autowired
	private IQuestionService service;


	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/questions/postquestion")
	public ResponseEntity<String> add(@RequestBody Question q, @RequestHeader String token) {
		if (token != null) {
			q.setId(service.getNextSequence("RANDOM_KEY"));
			service.add(q);
			ResponseEntity<String> responseEntity = new ResponseEntity<>("question added successfully", HttpStatus.OK);
			return responseEntity;
		}
		ResponseEntity<String> responseEntity = new ResponseEntity<>("Please Validate a Token", HttpStatus.OK);
		return responseEntity;
	}

	@DeleteMapping("/questions/deleteByQuestionId/{qid}")
	public ResponseEntity<String> delete(@PathVariable String qid, @RequestHeader String token) {
		if (token != null) {
			service.remove(qid);
			ResponseEntity<String> responseEntity = new ResponseEntity<>("Delete SuccesFully", HttpStatus.OK);
			return responseEntity;
		}
		return null;
	}

	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/question/findById/{id}")
	public ResponseEntity<?> findById(@PathVariable String id, @RequestHeader String token) {
		if(id == null) {
			return new ResponseEntity<>("Invalid question ID",HttpStatus.BAD_REQUEST);
		}
		if (token != null) {
			Question question = service.findQuestionById(id);
			if(question!= null) {
				ResponseEntity<Question> responseEntity = new ResponseEntity<>(question, HttpStatus.OK);
				return responseEntity;
			}
			else {
				return new ResponseEntity<>("Question not found",HttpStatus.NOT_FOUND);
			}
		}
		else {
			return new ResponseEntity<>("Not Authorized",HttpStatus.UNAUTHORIZED);
		}
	}


	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/question/findall")
	public ResponseEntity<List<Question>> findAll(@RequestHeader String token) {
		if (token != null) {
		List<Question> questions = service.findAllQuestions();
			ResponseEntity<List<Question>> responseEntity = new ResponseEntity<>(questions, HttpStatus.OK);
			return responseEntity;
		}
		return null;
	}

	@GetMapping("/questions/findByEmployeeId/{empid}")
	public ResponseEntity<List<Question>> findQuestionsByEmployeeId(@PathVariable String empid,
			@RequestHeader String token) {
		if (token != null) {
			List<Question> list = service.findQuestionsPostedByEmployee(empid);
			ResponseEntity<List<Question>> responseEntity = new ResponseEntity<>(list, HttpStatus.OK);
			return responseEntity;
		}
		return null;
	}

	@GetMapping("/questions/findQuestionFollowedByEmployeeId/{empid}")
	public ResponseEntity<List<Question>> findQuestionsFollowedByEmployeeId(@PathVariable String empid,
			@RequestHeader String token) {
		if (token != null) {
			List<Question> list = service.findQuestionsFollowedByEmployee(empid);
			ResponseEntity<List<Question>> responseEntity = new ResponseEntity<>(list, HttpStatus.OK);
			return responseEntity;
		}
		return null;
	}

	@CrossOrigin(origins = "http://localhost:3000")
	@PutMapping("/question/followquestion")
	public ResponseEntity<?> followQuestion(@RequestBody Follow follow,
			@RequestHeader String token) {
		if (token != null) {
			service.followQuestion(follow);
			ResponseEntity<String> responseEntity = new ResponseEntity<>("Followed  SuccesFully", HttpStatus.OK);
			return responseEntity;
		}
		return new ResponseEntity<>("Error occured",HttpStatus.INTERNAL_SERVER_ERROR);
	}

	public IQuestionService getService() {
		return service;
	}

	@CrossOrigin(origins = "http://localhost:3000")
	@PutMapping("/question/reportquestion")
	public ResponseEntity<?> reportQuestion(@RequestBody ReportQuestion reportQuestion, @RequestHeader String token) {
		if (token != null) {
			service.reportQuestion(reportQuestion);
			ResponseEntity<String> responseEntity = new ResponseEntity<>("Reported  SuccesFully", HttpStatus.OK);
			return responseEntity;
		}
		return new ResponseEntity<>("Error occured",HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@Autowired
	public void setService(IQuestionService service) {
		this.service = service;
	}

	@PutMapping("/questions/updatequestion/{id}")
	public ResponseEntity<String> update(@RequestBody Question q, @RequestHeader String token,
			@PathVariable String id) {
		if (token != null) {
			Question answer1 = service.findQuestionById(id);
			if (answer1 == null) {
				return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
			}
			service.updateQuestion(q, id);
			ResponseEntity<String> responseEntity = new ResponseEntity<>("answer updated successfully", HttpStatus.OK);
			return responseEntity;
		}
		ResponseEntity<String> responseEntity = new ResponseEntity<>("Please Validate a Token", HttpStatus.OK);
		return responseEntity;
	}
	
	@GetMapping("/questions/findQuestionByTopic/{topic}")
	public ResponseEntity<List<Question>> findquestionbytopic(@PathVariable String topic,
			@RequestHeader String token) {
		if (token != null) {
			List<Question> list = service.findQuestionsByTopic(topic);
			ResponseEntity<List<Question>> responseEntity = new ResponseEntity<>(list, HttpStatus.OK);
			return responseEntity;
		}
		return null;
	}

}

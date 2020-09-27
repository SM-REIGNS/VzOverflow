package com.verizon.lambda.controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.verizon.lambda.entities.UserActivityDetails;
import com.verizon.lambda.responsemodel.LeaderBoardResponseModel;
import com.verizon.lambda.service.LeaderBoardService;

@RestController
public class LeaderBoardController {
	
	@Autowired
	private LeaderBoardService service;

	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping(path="/leaderboard/all")
	public ResponseEntity<ArrayList<LeaderBoardResponseModel>> getFullLeaderBoard(){
		
		List<UserActivityDetails> details = service.findAll();


		Comparator<UserActivityDetails> compareByPoints=(UserActivityDetails u1,UserActivityDetails u2)-> new Integer(u1.getPoints()).compareTo(new Integer(u2.getPoints()) );


		Collections.sort(details,compareByPoints);
		
		Collections.reverse(details);
		
		ArrayList<LeaderBoardResponseModel> list=new ArrayList<>();
		
		int rank=1;
		
		
		for(UserActivityDetails u:details){
			
			
			LeaderBoardResponseModel model=new 	LeaderBoardResponseModel(rank,u.getUserId(),u.getPoints());
			
			list.add(model);
			
			rank++;
			
		}

		ResponseEntity<ArrayList<LeaderBoardResponseModel>> response=new ResponseEntity<>(list,HttpStatus.OK);
		
		return response;
	}


	
	
	/*
	@GetMapping(path="/leaderboard/teams")
	public ResponseEntity<String> getTeamsLeaderBoard(){
		
	}
	*/
	
	
}

package com.verizon.lambda.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.verizon.lambda.DTO.AddTeamMembersrequest;
import com.verizon.lambda.DTO.Member;
import com.verizon.lambda.entities.Team;
import com.verizon.lambda.service.ITeamService;

@RestController
public class TeamRestController {

	@Autowired
	private ITeamService teamService;

	public ITeamService getTeamService() {
		return teamService;
	}

	public void setTeamService(ITeamService teamService) {
		this.teamService = teamService;
	}


	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/getteams/{uId}")
	public ResponseEntity<?> getTeams(@PathVariable String uId) {
		List<Team> teams = teamService.getAllTeams(uId);
		return new ResponseEntity<>(teams,HttpStatus.OK);
	}


	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/createTeam")
	public ResponseEntity<?> createTeam(@RequestBody Team t) {

		t.setId(teamService.getNextSequence("RANDOM_KEY"));


		Team addedteam = teamService.addTeam(t);



		if (addedteam != null)
			return new ResponseEntity<>("Team creation successful", HttpStatus.OK);

		else
			return new ResponseEntity<>("Error creating team",HttpStatus.INTERNAL_SERVER_ERROR);

	}

	@PostMapping("/addMembersToTeam/{tid}")
	public String addMembersToTeam(@RequestBody AddTeamMembersrequest req,@PathVariable("tid") String teamId) {

		System.out.println(req);
		
		Set<String> newMemberIds=req.getNewMemberIds();
		
		Team t = teamService.addMembers(teamId, newMemberIds);

		if (t != null) {

			return "members added successfully";
		}

		else

			return "members are not added";

	}

	@GetMapping("/deleteMembers/{tid}/{eid}")
	public String deleteMembersFromTeam(@PathVariable("tid") String teamId, @PathVariable("eid") String employeeId) {
		Team t = teamService.deleteMembers(teamId, employeeId);

		if (t != null) {
			return "member is deleted successfully";

		}

		else {
			return "member is not deleted";
		}
	}


	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/getteambyid/{teamID}")
	public ResponseEntity<?> getTeamMembers(@PathVariable("teamID") String teamId) {

		Team team = teamService.getTeamById(teamId);

		if(team == null ) {
			return new ResponseEntity<>("Team not found",HttpStatus.NOT_FOUND);
		}
		else {
			return new ResponseEntity<>(team,HttpStatus.OK);
		}

	}
}
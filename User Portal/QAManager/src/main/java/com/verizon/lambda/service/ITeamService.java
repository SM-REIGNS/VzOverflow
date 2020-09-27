package com.verizon.lambda.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.verizon.lambda.DTO.Member;
import com.verizon.lambda.entities.Team;

public interface ITeamService {

	public Team addTeam(Team t);

	Team addMembers(String teamId, Set<String> newMemberIds);
	
	
	Team deleteMembers(String teamId,String eid);
	
	
	Team getTeamById(String teamID);

	public String getNextSequence(String seqName);

	public List<Team> getAllTeams(String id);

	//public Team addMembers(Team t);


	//Team addMembers(String teamId,ArrayList<String> eids);


	
	
	
	
	
	
	
	
	
}

package com.verizon.lambda.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.verizon.lambda.entities.AnswerSequenceCounter;
import com.verizon.lambda.entities.TeamSequenceCounter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.verizon.lambda.DTO.Member;
import com.verizon.lambda.DTO.TeamMembers;
import com.verizon.lambda.dao.TeamRepository;
import com.verizon.lambda.entities.Team;
import com.verizon.lambda.entities.User;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;


@Service
public class TeamServiceImpl implements ITeamService{


	@Autowired
	private MongoOperations mongo;
	private TeamRepository teamDao;

	
	public TeamRepository getTeamDao() {
		return teamDao;
	}
	@Autowired
	public void setTeamDao(TeamRepository teamDao) {
		this.teamDao = teamDao;
	}
	
	
	
	private UserServiceImpl userService;
	

	public UserServiceImpl getUserService() {
		return userService;
	}
	
	@Autowired
	public void setUserService(UserServiceImpl userService) {
		this.userService = userService;
	}
	
	
	
	
	private TeamMembers teamMembers;

	public TeamMembers getTeamMembers() {
		return teamMembers;
	}
	
	@Autowired
	public void setTeamMembers(TeamMembers teamMembers) {
		this.teamMembers = teamMembers;
	}
	@Override
	public String getNextSequence(String seqName) {
		TeamSequenceCounter counter = mongo.findAndModify(query(where("_id").is(seqName)), new Update().inc("seq", 1),
				options().returnNew(true).upsert(true), TeamSequenceCounter.class);
		return Integer.toString(counter.getSeq());
	}
	
	
	@Override
	public Team addTeam(Team t) {
		
		
		return teamDao.save(t);
		
		
	}

	@Override
	public List<Team> getAllTeams(String uId){
		List<Team> allTeams = teamDao.findAll();
		List<Team> myTeams = new ArrayList<>();
		for(Team team : allTeams) {
			System.out.println(team.getId());
			System.out.println(team.getManagerId());
			if(uId.equals(team.getManagerId()) || team.getMemberIds().contains(uId)) {
				System.out.println(team.getManagerId());
				myTeams.add(team);
			}
		}
		return myTeams;
	}


	@Override
	public Team addMembers(String teamId,Set<String> eids) {
		
		Optional<Team> to=teamDao.findById(teamId);
		
		Team t = null;
		
		if(to.isPresent()){
			t=to.get();
		}
		
		Set<String> existingMembersList=t.getMemberIds();
		
		existingMembersList.addAll(eids);
		
		
		System.out.println("Inside add members to the team service");
		
//	for(String s: existingMembersList){
//		
//		System.out.println("the id is"+s);
//	}
		
	 t.setMemberIds(existingMembersList);
		
	Team t1=teamDao.save(t);
	 
		
		return t1;
	}
	
	
	
	
	@Override
	public Team deleteMembers(String teamId, String eid) {
		
Optional<Team> to=teamDao.findById(teamId);
		
		Team t = null;
		
		if(to.isPresent()){
			t=to.get();
		}
		
		Set<String> existingMembersList=t.getMemberIds();
		
		if(existingMembersList.remove(eid)){
			
			t.setMemberIds(existingMembersList);
			
		}
		
		
		Team t1=teamDao.save(t);
		
		
		return t1;
	}
	
	
	
	@Override
	public Team getTeamById(String teamID) {

		Optional<Team> team = teamDao.findById(teamID);
		
		return team.get();
	}
	
	
	
	
	
	


}
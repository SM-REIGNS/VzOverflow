package com.verizon.lambda.DTO;

import java.util.ArrayList;

import org.springframework.stereotype.Component;


@Component
public class TeamMembers {

	
	private ArrayList<Member> teamMembers;

	public ArrayList<Member> getTeamMembers() {
		return teamMembers;
	}

	public void setTeamMembers(ArrayList<Member> teamMembers) {
		this.teamMembers = teamMembers;
	}

	public TeamMembers(ArrayList<Member> teamMembers) {
		super();
		this.teamMembers = teamMembers;
	}

	public TeamMembers() {
		super();
		
	} 
	
	
	
	
	
	
	
	
	
	
}

package com.verizon.lambda.DTO;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class AddTeamMembersrequest {

	
	private Set<String> newMemberIds=new HashSet<String>();
	
	//private String teamId;

	public Set<String> getNewMemberIds() {
		return newMemberIds;
	}

	public void setNewMemberIds(Set<String> newMemberIds) {
		this.newMemberIds = newMemberIds;
	}
//
//	public String getTeamId() {
//		return teamId;
//	}
//
//	public void setTeamId(String teamId) {
//		this.teamId = teamId;
//	}

	public AddTeamMembersrequest(Set<String> newMemberIds) {
		super();
		this.newMemberIds = newMemberIds;
		//this.teamId = teamId;
	}

	public AddTeamMembersrequest() {
		super();
		// TODO Auto-generated constructor stub
	}




}

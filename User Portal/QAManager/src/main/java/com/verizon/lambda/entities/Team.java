package com.verizon.lambda.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Set;

import org.springframework.data.mongodb.core.mapping.Document;

@Document("team")
public class Team implements Serializable{
	
	private String id;
    private String teamName;
    private String managerId;
    private Set<String> memberIds;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public String getManagerId() {
		return managerId;
	}
	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}
	public Set<String> getMemberIds() {
		return memberIds;
	}
	public void setMemberIds(Set<String> memberIds) {
		this.memberIds = memberIds;
	}
	
	
	
	public Team(String id, String teamName, String managerId, Set<String> memberIds) {
		super();
		this.id = id;
		this.teamName = teamName;
		this.managerId = managerId;
		this.memberIds = memberIds;
	}


	
	
	public Team() {
		super();
		
	}
    
    
}

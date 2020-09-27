package com.verizon.lambda.responsemodel;

import java.io.Serializable;


public class LeaderBoardResponseModel implements Serializable{

	private int rank;
	private String name;
	private int points;
	
	public LeaderBoardResponseModel() {
	}
	
	public LeaderBoardResponseModel(int rank, String name, int points) {
		super();
		this.rank = rank;
		this.name = name;
		this.points = points;
		
	}


	public int getRank() {
		return rank;
	}


	public void setRank(int rank) {
		this.rank = rank;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getPoints() {
		return points;
	}


	public void setPoints(int points) {
		this.points = points;
	}
	
	
	
	
}

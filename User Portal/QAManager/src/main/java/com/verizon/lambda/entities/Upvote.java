package com.verizon.lambda.entities;

import java.util.HashSet;
import java.util.Set;

public class Upvote {
private String aId;
private String uId;

	public Upvote() {
	}

	public Upvote(String aId, String uId) {
		this.aId = aId;
		this.uId = uId;
	}

	public String getaId() {
		return aId;
	}

	public void setaId(String aId) {
		this.aId = aId;
	}

	public String getuId() {
		return uId;
	}

	public void setuId(String uId) {
		this.uId = uId;
	}
}

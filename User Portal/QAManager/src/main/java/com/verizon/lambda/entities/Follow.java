package com.verizon.lambda.entities;

import java.util.HashSet;
import java.util.Set;

public class Follow {
	String qId;
	String uId;

	public Follow() {
	}

	public Follow(String qId, String uId) {
		this.qId = qId;
		this.uId = uId;
	}

	public String getqId() {
		return qId;
	}

	public void setqId(String qId) {
		this.qId = qId;
	}

	public String getuId() {
		return uId;
	}

	public void setuId(String uId) {
		this.uId = uId;
	}
}

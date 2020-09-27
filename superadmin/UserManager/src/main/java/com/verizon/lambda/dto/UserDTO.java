package com.verizon.lambda.dto;

public class UserDTO {

	private String email;
	
	private String password;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserDTO(String id, String password) {
		super();
		this.email = id;
		this.password = password;
	}
	
	
	
	
	
}

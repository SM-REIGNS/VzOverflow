package com.verizon.lambda.service;

import org.springframework.stereotype.Service;

@Service
public class AdminServiceImp {

	public boolean authenticateSuperAdmin(String id,String password){
		if(id.equals("admin")&&password.equals("admin")){
			return true;
	    }
		else{
			return false;
		}
	}
	
	
	
}
	

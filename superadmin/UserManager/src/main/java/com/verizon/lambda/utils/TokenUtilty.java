package com.verizon.lambda.utils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

@Component
public class TokenUtilty {

	
	
	public String getToken(String secretkey,String id,String role) {

		String token = Jwts.builder().setId(id).claim("role", role).claim("userId", id)
				.claim("logged", "true")
				.signWith(SignatureAlgorithm.HS512, secretkey).compact();

		return token;
		
	}

	
	public String getTokenForAdmin(String secretkey, String id, String role){
		
		String token= Jwts.builder().setId(id).claim("role",role).claim("userId",id)
				.claim("logged","true")
				.signWith(SignatureAlgorithm.HS512,secretkey).compact();
	
		return token;
		
		
	}
	
	
	
	
	
}

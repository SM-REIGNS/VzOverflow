package com.verizon.lambda.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;


@Component
public class Utilities {
	
	
	String secretToken="jf9i4jgu83nfl0jfu57ejf7";
	

	
	public String generatePasswordResetToken(String userId) {

		String token=Jwts.builder()
				.setId(userId)
				.signWith(SignatureAlgorithm.HS512,secretToken)
				.compact();
		return token;
		
		
	}
	
	public Claims decodePasswordResetToken(String receivedToken){
		Claims claims = Jwts.parser().setSigningKey(secretToken).parseClaimsJws(receivedToken).getBody();
		return claims;
	}
	
	
	
	
	
}

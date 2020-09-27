package com.verizon.lambda.controller;

import com.verizon.lambda.dto.UserDTO;
import com.verizon.lambda.entity.Users;
import com.verizon.lambda.exceptions.UserManagerException;
import com.verizon.lambda.service.UserManagerService;
import com.verizon.lambda.utils.TokenUtilty;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JwtAuthenticationRestControllerUser {

	@Autowired
	private UserManagerService userService;

	@Autowired
	TokenUtilty tokenUtility;

	@Value("${jwt.secret}")
	private String secret;

	@CrossOrigin(origins = "http://localhost:3001", exposedHeaders = "token")
	@PostMapping("/login/authenticateuser")
	public ResponseEntity<String> loginAuthentication(@RequestBody UserDTO user) {

		String email = user.getEmail();

		String password = user.getPassword();

		Users databaseUser = userService.findUserByEmailId(email);

		System.out.println("got the details!!!!!!!");

		System.out.println(" the values from database" + databaseUser);

		if (databaseUser != null) {

			if (databaseUser.getContact().getEmail().equals(email) && databaseUser.getPassword().equals(password)) {

				String generatedToken = tokenUtility.getToken(secret, databaseUser.getId(),
						databaseUser.getRole());

				HttpHeaders responseHeaders = new HttpHeaders();
				responseHeaders.set("token", generatedToken);

				return new ResponseEntity<>("You have successfully logged in", responseHeaders, HttpStatus.OK);

			} else {
				return new ResponseEntity<String>("Incorrect Username or password", HttpStatus.UNAUTHORIZED);
			}

		}

		else {
//			throw new UserManagerException("User Not Found");
			return new ResponseEntity<String>("User not found", HttpStatus.UNAUTHORIZED);
		}

	}

	@PostMapping("/user/home") // ResponseEntity<String>
	public ResponseEntity<String> sayHello(@RequestHeader("token") String token) {

		if (token == null) {
			return new ResponseEntity<>("You are Not allowed to visit", HttpStatus.UNAUTHORIZED);
		}
		Claims claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();

		String username = (String) claims.get("username");
		String role = (String) claims.get("role");

		return new ResponseEntity<>("Welcome to the web site, " + username, HttpStatus.OK);

	}

}

package com.verizon.lambda.controller;

import com.verizon.lambda.dto.AdminDTO;
import com.verizon.lambda.entity.Users;
import com.verizon.lambda.service.AdminServiceImp;
import com.verizon.lambda.service.UserManagerService;
import com.verizon.lambda.utils.TokenUtilty;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3001", exposedHeaders = "token")
public class JwtAuthenticationControllerAdmin {

	@Autowired
	private AdminServiceImp adminService;

	@Autowired
	private UserManagerService userManagerService;

	@Autowired
	TokenUtilty tokenUtility;

	@Value("${jwt.secret}")
	private String secret;

	@PostMapping("/login/authenticateadmin")
	public ResponseEntity<String> adminAuthentication(@RequestBody AdminDTO admin) {

		String email = admin.getEmail();
		String password = admin.getPassword();

		Users userAdmin = userManagerService.findUserByEmailId(email);

		if (userAdmin != null) {
			if (userAdmin.getContact().getEmail().equals(email) && userAdmin.getPassword().equals(password)) {

				String generatedToken = tokenUtility.getTokenForAdmin(secret, userAdmin.getId(), userAdmin.getRole());

				HttpHeaders responseHeaders = new HttpHeaders();
				responseHeaders.set("token", generatedToken);
				System.out.println(responseHeaders);
				return new ResponseEntity<>(userAdmin.getId(), responseHeaders, HttpStatus.OK);

			} else {
				return new ResponseEntity<String>("Incorrect Username or password", HttpStatus.UNAUTHORIZED);

			}
		} else {
			return new ResponseEntity<String>("User not found", HttpStatus.UNAUTHORIZED);

		}

	}

	@CrossOrigin(origins = "http://localhost:3001")
	@PostMapping("/admin/home")
	public ResponseEntity<String> sayHelloToAdmin(@RequestHeader("token") String token) {

		if (token == null) {
			return new ResponseEntity<>("You are Not allowed to visit", HttpStatus.UNAUTHORIZED);
		}
		Claims claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();

		System.out.println(token);

		String role = (String) claims.get("role");
		// role from here can be used to restrict access to some pages
		if (role.equals("admin")) {
			return new ResponseEntity<>("Welcome to the web site Admin", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("You are not authorized to access this page", HttpStatus.UNAUTHORIZED);
		}

	}
}

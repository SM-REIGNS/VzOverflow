package com.verizon.lambda.controller;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.verizon.lambda.entity.*;
import com.verizon.lambda.exceptions.UserManagerException;
import com.verizon.lambda.utils.TokenUtilty;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
// import org.apache.catalina.User;
import org.json.JSONString;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.verizon.lambda.service.UserManagerService;
import javax.validation.constraints.NotNull;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

@RestController
public class UserManagerRestController {
	@Autowired
	private UserManagerService userManagerService;
	@Autowired
	private RabbitTemplate rabbitTemplate;
	@Autowired
	private DirectExchange directExchange;
	@Autowired
	private TokenUtilty tokenUtility;
	@Value("${jwt.secret}")
	private String secret;

//	@PostMapping(value = "/sendnotification")
//	public String sendMessage() {
//		rabbitTemplate.convertAndSend(directExchange.getName(), "invitationKey",
//				"This is a direct exchange message sent to notification service");
//		return "message sent successfully!";
//	}
//
//	@GetMapping(value = "/receiveresponse")
//	public String receiveMessage() throws UserManagerException {
//		Message message = rabbitTemplate.receive("userManagerQueue");
//		if (message == null) {
//			return "No new messages";
//		} else {
//			return new String(message.getBody());
//		}
//	}

	@CrossOrigin(origins = "http://localhost:3001")
	@PostMapping(value = "/admin/adduser")
	public ResponseEntity<String> addUser(@RequestBody Request req, @RequestHeader("token") String token) throws IOException {
		System.out.println("inside adduser " + token);
		System.out.println("continuing..... " + req.toString());

		Claims claims;
		try {
			claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
		} catch (Exception ex) {
			throw new UserManagerException(ex.getMessage().toString());
		}

		String id = (String) claims.get("id");
		String role = (String) claims.get("role");
		 System.out.println("continuing..... " + role + " " + id);
		System.out.println(req);
		if (role.equals("admin")) {
			System.out.println("continuing..... " + req.getId() + ", " + req.getFirstName()+req.getEmail());
			Users user = new Users();
			String password = token.split("[.]")[2].substring(0,10).toLowerCase();
			user.setId(req.getId());
			user.setPassword(password);
			user.setDob(req.getDob());
			user.setDepartment(req.getDepartment());
			user.setDoj(req.getDoj());
			user.setFirstName(req.getFirstName());
			user.setMiddleName(req.getMiddleName());
			user.setLastName(req.getLastName());
			user.setDesignation(req.getDesignation());
			user.setRole(req.getRole());
			user.setQualification(req.getQualification());
			user.setContact(new Contact(req.getEmail(),req.getPhoneNo()));
			user.setAddress(new Address(req.getAddressLine1(),
					req.getAddressLine2(),req.getCity(), req.getPincode(),req.getCountry()));

			String msg = userManagerService.addUser(user);
			System.out.println("continuing..... " + msg);
			InviteBody inviteBody = new InviteBody(user.getContact().getEmail(),password,req.getFirstName());
			ObjectMapper objectMapper = new ObjectMapper();
			rabbitTemplate.convertAndSend(directExchange.getName(), "invitationKey",
					objectMapper.writeValueAsString(inviteBody));
			ResponseEntity<String> responseEntity = new ResponseEntity<>(msg, HttpStatus.OK);
			return responseEntity;
		} else {

			ResponseEntity<String> responseEntity = new ResponseEntity<>("You are not authorized to access this page.",
					HttpStatus.UNAUTHORIZED);
			return responseEntity;
		}

	}

	@CrossOrigin(origins = "http://localhost:3001")
	@PutMapping(value = "/admin/updateuser")
	public String updateUser(@RequestBody Users user, @RequestHeader("token") String token) {
		Claims claims;
		try {
			claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
		} catch (Exception ex) {
			throw new UserManagerException(ex.getMessage().toString());
		}

		String id = (String) claims.get("id");
		String role = (String) claims.get("role");

		if (role.equals("admin")) {
			String response = userManagerService.updateUserDetails(user);
			return response;
		} else {

			ResponseEntity<String> responseEntity = new ResponseEntity<>("You are not authorized to access this page.",
					HttpStatus.OK);
			return responseEntity.getBody();

		}
	}

	@CrossOrigin(origins = "http://localhost:3001")
	@GetMapping(value = "/admin/finduserbyid/{id}")
	public ResponseEntity<Users> findUser(@PathVariable("id") String id, @RequestHeader("token") String token) {
		Claims claims;
		try {
			claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
		} catch (Exception ex) {
			throw new UserManagerException(ex.getMessage().toString());
		}

		String fetchedId = (String) claims.get("id");
		String role = (String) claims.get("role");
		if (role.equals("admin")) {

			Users user = userManagerService.findUserById(id);
			if (user == null) {
				throw new UserManagerException("User not found");

			}
			ResponseEntity<Users> responseEntity = new ResponseEntity<>(user, HttpStatus.OK);
			return responseEntity;
		} else {
			throw new UserManagerException("You are not authorized to access this page.");
		}

	}




@CrossOrigin(origins = "http://localhost:3001")
	@GetMapping(value = "/finduserbyid/{id}")
	public ResponseEntity<?> findUserFromUser(@PathVariable("id") String id, @RequestHeader("token") String token) {
		Claims claims;
		try {
			claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
		} catch (Exception ex) {
			throw new UserManagerException(ex.getMessage().toString());
		}

		String fetchedId = (String) claims.get("id");
		String role = (String) claims.get("role");
		if (role.equals("employee") || role.equals("manager")) {

			Users user = userManagerService.findUserById(id);
			if (user == null) {
				//throw new UserManagerException("User not found");
				return new ResponseEntity<>("User not found",HttpStatus.NOT_FOUND);

			}
			ResponseEntity<Users> responseEntity = new ResponseEntity<>(user, HttpStatus.OK);
			return responseEntity;
		} else {
			//throw new UserManagerException("You are not authorized to access this page.");
			return new ResponseEntity<>("You are not authorized to access this page.",HttpStatus.UNAUTHORIZED);
		}

	}









	@CrossOrigin(origins = "http://localhost:3001")
	@DeleteMapping(value = "/admin/deleteuserbyid/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable("id") String id, @RequestHeader("token") String token) {
		Claims claims;
		try {
			claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
		} catch (Exception ex) {
			throw new UserManagerException(ex.getMessage().toString());
		}
		String fetchedId = (String) claims.get("id");
		String role = (String) claims.get("role");
		if (role.equals("admin")) {

			String msg = userManagerService.removeUserById(id);
			ResponseEntity<String> responseEntity = new ResponseEntity<>(msg, HttpStatus.OK);
			return responseEntity;
		} else {
			ResponseEntity<String> responseEntity = new ResponseEntity<>("You are not authorized to access this page.",
					HttpStatus.UNAUTHORIZED);
			return responseEntity;
		}
	}

	@CrossOrigin(origins = "http://localhost:3001")
	@GetMapping(value = "/admin/findallusers")
	public ResponseEntity<List<Users>> allUsers(@RequestHeader("token") String token) {
		Claims claims;
		try {
			claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
		} catch (Exception ex) {
			throw new UserManagerException(ex.getMessage().toString());
		}

		String fetchedId = (String) claims.get("id");
		String role = (String) claims.get("role");
		if (role.equals("admin")) {

			List<Users> users = userManagerService.showAllUsers();
			ResponseEntity<List<Users>> responseEntity = new ResponseEntity<>(users, HttpStatus.OK);
			return responseEntity;
		} else {
			throw new UserManagerException("You are not authorized to access this page.");
		}
	}

@CrossOrigin(origins = "http://localhost:3001")
	@GetMapping(value = "/findallusers")
	public ResponseEntity<List<Users>> findAllUsers(@RequestHeader("token") String token) {
		Claims claims;
		try {
			claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
		} catch (Exception ex) {
			throw new UserManagerException(ex.getMessage().toString());
		}

		String fetchedId = (String) claims.get("id");
		String role = (String) claims.get("role");
		if (role.equals("employee") || role.equals("manager")) {

			List<Users> users = userManagerService.showAllUsers();
			ResponseEntity<List<Users>> responseEntity = new ResponseEntity<>(users, HttpStatus.OK);
			return responseEntity;
		} else {
			throw new UserManagerException("You are not authorized to access this page.");
		}
	}
	@CrossOrigin(origins = "http://localhost:3001")
	@PostMapping(value = "/admin/finduserbyemailid")
	public ResponseEntity<Users> findUserByEmailId(@RequestBody Email email, @RequestHeader("token") String token) {
		System.out.println(email.getEmail());
		Claims claims;
		try {
			claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
		} catch (Exception ex) {
			throw new UserManagerException(ex.getMessage().toString());
		}
		String fetchedId = (String) claims.get("id");
		String role = (String) claims.get("role");
		if (role.equals("admin")) {

			Users user = userManagerService.findUserByEmailId(email.getEmail());
			if (user != null) {
				ResponseEntity<Users> responseEntity = new ResponseEntity<>(user, HttpStatus.OK);
				return responseEntity;
			} else {
				throw new UserManagerException("User Not found with given email.");
			}
		} else {
			throw new UserManagerException("You are not authorized to access this page.");
		}
	}

	@CrossOrigin(origins = "http://localhost:3001")
	@PostMapping(path = "/user/resetpassword")
	public String userPasswordReset(@RequestBody Email email) throws IOException{

		System.out.println(email.getEmail());

//		Claims claims;
//		try {
//			claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
//		} catch (Exception ex) {
//			throw new UserManagerException(ex.getMessage().toString());
//		}
//		String fetchedId = (String) claims.get("id");
//		String role = (String) claims.get("role");
//		if (role.equals("employee") || role.equals("manager")) {
        System.out.println(email.getEmail());
        String generatedToken = userManagerService.requestPasswordReset(email.getEmail());
        System.out.println(generatedToken);
		ResetPasswordRequest resetPasswordRequest = new ResetPasswordRequest(email.getEmail(),generatedToken);
		ObjectMapper objectMapper = new ObjectMapper();
		rabbitTemplate.convertAndSend(directExchange.getName(), "userManagerKey",
				objectMapper.writeValueAsString(resetPasswordRequest));


			return "Password reset link sent to your mail.";
//		} else {
//			return "You are not authorized to access this page.";
//		}

	}

	@CrossOrigin(origins = "http://localhost:3001")
	@PostMapping(path = "/user/updatepassword")
	public String userUpdatePassword(@RequestBody UpdatePassword updatePassword, @RequestHeader("token") String token)
			throws UnsupportedEncodingException {
		System.out.println(updatePassword.getPassword());
		System.out.println(updatePassword.getConfirmPassword());
		System.out.println(updatePassword.getToken());


		Claims claims;
		try {
			claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
		} catch (Exception ex) {
			throw new UserManagerException(ex.getMessage().toString());
		}
		String fetchedId = (String) claims.get("id");
		String role = (String) claims.get("role");
		if (role.equals("employee") || role.equals("manager")) {
			System.out.println("here");
			String response = userManagerService.requestTokenValidate(updatePassword.getPassword(),
					updatePassword.getConfirmPassword(), updatePassword.getToken());
			return response;
		} else {
			return "You are not authorized to access this page.";
		}
	}

	@CrossOrigin(origins = "http://localhost:3001")
	@PostMapping(path = "/admin/resetpassword")
	public String adminPasswordReset(@RequestBody Email email) throws IOException{
//		System.out.println(email.getEmail());
//		Claims claims;
//		try {
//			claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
//		} catch (Exception ex) {
//			throw new UserManagerException(ex.getMessage().toString());
//		}
//		String fetchedId = (String) claims.get("id");
//		String role = (String) claims.get("role");
//		if (role.equals("admin")) {

//			String email = userManagerService.findUsersByRole("admin").get(0).getContact().getEmail();

			String sendToken = userManagerService.requestPasswordReset(email.getEmail());
			System.out.println(sendToken);
//			rabbitTemplate.convertAndSend(directExchange.getName(),"notificationServiceKey",sendToken);
			ResetPasswordRequest resetPasswordRequest = new ResetPasswordRequest(email.getEmail(),sendToken);
			ObjectMapper objectMapper = new ObjectMapper();
			rabbitTemplate.convertAndSend(directExchange.getName(), "userManagerKey",
					objectMapper.writeValueAsString(resetPasswordRequest));

			return "Password reset link sent to your mail.";
//		} else {
//			return "You are not authorized to access this page.";
//		}
	}

	@CrossOrigin(origins = "http://localhost:3001")
	@PostMapping(path = "/admin/updatepassword")
	public String adminUpdatePassword(@RequestBody UpdatePassword updatePassword, @RequestHeader("token") String token)
			throws UnsupportedEncodingException {
		Claims claims;
		try {
			claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
		} catch (Exception ex) {
			throw new UserManagerException(ex.getMessage().toString());
		}
		String fetchedId = (String) claims.get("id");
		String role = (String) claims.get("role");
		System.out.println(role);
		if (role.equals("admin")) {

			String response = userManagerService.requestTokenValidate(updatePassword.getPassword(),
					updatePassword.getConfirmPassword(), updatePassword.getToken());
			return response;
		} else {
			return "You are not authorized to access this page.";
		}
	}

	@ExceptionHandler(UserManagerException.class)
	public String handleException(UserManagerException ex) {
		return ex.getMessage().toString();
	}

}

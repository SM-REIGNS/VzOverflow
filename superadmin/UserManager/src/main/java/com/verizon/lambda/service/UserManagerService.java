 package com.verizon.lambda.service;

import com.verizon.lambda.entity.Users;

import java.io.UnsupportedEncodingException;
import java.util.List;

 public interface UserManagerService {

	 public String addUser(Users user);

	 public String removeUserById(String Id);

	 public Users findUserById(String Id);

	 public List<Users> showAllUsers();

	 public Users findUserByEmailId(String email);

	 public String updateUserDetails(Users user);

	 public String requestPasswordReset(String email);

	 public List<Users> findUsersByRole(String role);

     Users findUsersByRoleAndId(String role,String id);

     String requestTokenValidate(String password, String confirmPassword, String token) throws UnsupportedEncodingException;


 }

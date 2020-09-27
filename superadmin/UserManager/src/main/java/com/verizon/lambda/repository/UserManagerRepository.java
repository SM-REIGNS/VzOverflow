package com.verizon.lambda.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.verizon.lambda.entity.Users;

import java.util.List;

@Repository
public interface UserManagerRepository extends MongoRepository<Users,String> {
	Users findByContactEmail(String emailId);
	Users findByContactPhoneNo(String phoneNo);
	List<Users> findByRole(String role);

	Users findByRoleAndId(String role,String id);
}




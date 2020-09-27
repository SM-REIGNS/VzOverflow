package com.verizon.lambda.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.verizon.lambda.entities.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

	
}

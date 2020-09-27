package com.verizon.lambda.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.verizon.lambda.entities.UserActivityDetails;

public interface UserActivityDetailsDao extends MongoRepository<UserActivityDetails,Object> {



}

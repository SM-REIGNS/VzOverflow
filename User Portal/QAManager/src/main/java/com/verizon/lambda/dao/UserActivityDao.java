package com.verizon.lambda.dao;

import com.verizon.lambda.entities.UserActivityDetails;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserActivityDao extends MongoRepository<UserActivityDetails,Object> {
    public UserActivityDetails findByUserId(String uid);
}

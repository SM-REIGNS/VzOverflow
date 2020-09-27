package com.verizon.lambda.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.verizon.lambda.entities.Team;

@Repository
public interface TeamRepository extends MongoRepository<Team, String> {
}
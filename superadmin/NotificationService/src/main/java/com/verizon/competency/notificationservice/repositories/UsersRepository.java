package com.verizon.competency.notificationservice.repositories;

import com.verizon.competency.notificationservice.model.Users;
import org.springframework.data.mongodb.repository.MongoRepository;



public interface UsersRepository extends MongoRepository<Users,String> {
    Users findByRole(String role);
}

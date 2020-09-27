package com.verizon.competency.notificationservice.service;

import com.verizon.competency.notificationservice.repositories.UsersRepository;
import com.verizon.competency.notificationservice.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class UserServiceImplementation implements UserServiceInterface {

    private UsersRepository usersRepository;

    public UsersRepository getUsersDao() {
        return usersRepository;
    }

    @Autowired
    public void setUsersDao(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    private MongoOperations mongoTemplate;

    public MongoOperations getMongoTemplate() {
        return mongoTemplate;
    }

    @Autowired
    public void setMongoTemplate(MongoOperations mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public Users findUserById(String empId) {
        Optional<Users> user = getUsersDao().findById(empId);
        return user.get();
    }

    @Override
    public Users findUserByRole(String role) {
        Users user = getUsersDao().findByRole("Employee");
        return user;
    }

    @Override
    public Users save(Users user) {
        Users userInserted =getUsersDao().save(user);
        return userInserted;

    }
}

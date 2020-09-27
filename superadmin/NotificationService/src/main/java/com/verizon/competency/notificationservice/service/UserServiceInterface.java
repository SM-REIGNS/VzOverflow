package com.verizon.competency.notificationservice.service;

import com.verizon.competency.notificationservice.model.Users;


public interface UserServiceInterface {

    Users findUserById(String empId);

    Users findUserByRole(String role);

    Users save(Users user);

}

package com.verizon.lambda.service;

import com.verizon.lambda.entity.ResetPasswordRequest;
import com.verizon.lambda.utils.Utilities;
import io.jsonwebtoken.Claims;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.verizon.lambda.entity.Users;
import com.verizon.lambda.exceptions.UserManagerException;
import com.verizon.lambda.repository.UserManagerRepository;

import javax.swing.text.html.Option;
import javax.validation.constraints.Null;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserManagerServiceImpl implements UserManagerService {

    @Autowired
    private UserManagerRepository userManagerRepository;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    String sendingToken = "";
    String receivedToken = "";

    public UserManagerRepository getUserManagerRepository() {
        return userManagerRepository;
    }

    public void setUserManagerRepository(UserManagerRepository userManagerRepository) {
        this.userManagerRepository = userManagerRepository;
    }

    @Override
    public String addUser(Users user) {

        if (!userManagerRepository.findById(user.getId()).isPresent()) {
             if(userManagerRepository.findByContactEmail(user.getContact().getEmail()) ==
             null ) {
             if(userManagerRepository.findByContactPhoneNo(user.getContact().getPhoneNo())
             == null ) {
            userManagerRepository.save(user);
            return "User added successfully.";
             } else {
             return "User with same phone number already exist.";
             }
             }else

             {
             return "User with same email already exist.";
             }
        } else {
            return "User with same Id already exist.";
        }
    }

    @Override
    public String removeUserById(String Id) {
        Optional<Users> user = userManagerRepository.findById(Id);
        if (user.isPresent()) {
            userManagerRepository.delete(user.get());
            return "User deleted successfully";
        } else {
            return "User with given id doesn't exist.";
        }
    }

    @Override
    public Users findUserById(String Id) {
        if (Id == null) {
            throw new UserManagerException("Id can't be null.");
        }

        Optional<Users> response = userManagerRepository.findById(Id);

        if (!response.isPresent()) {
            throw new UserManagerException("user not found with the given id");
        }

        Users user = response.get();
        return user;
    }

    @Override
    public List<Users> showAllUsers() {

        List<Users> users = userManagerRepository.findAll();

        return users;
    }

    @Override
    public String updateUserDetails(Users user) {

        Optional<Users> fetchedUser = userManagerRepository.findById(user.getId());

        if (!fetchedUser.isPresent()) {
            return "User with given id doesn't exist";
        } else {
            String id1;
            String id2;

            if (user.getContact() != null) {
                if (user.getContact().getEmail() != null && user.getContact().getPhoneNo() == null) {
                    if (userManagerRepository.findByContactEmail(user.getContact().getEmail()) != null) {
                        id1 = userManagerRepository.findByContactEmail(user.getContact().getEmail()).getId();
                        if (id1.equals(user.getId())) {
                            userManagerRepository.save(user);
                            return "User details updated successfully";
                        } else {
                            return "Email Id already exist";
                        }
                    } else {
                        userManagerRepository.save(user);
                        return "User details updated successfully";
                    }
                } else if (user.getContact().getEmail() == null && user.getContact().getPhoneNo() != null) {
                    if (userManagerRepository.findByContactEmail(user.getContact().getPhoneNo()) != null) {
                        id2 = userManagerRepository.findByContactEmail(user.getContact().getPhoneNo()).getId();
                        if (id2.equals(user.getId())) {
                            userManagerRepository.save(user);
                            return "User details updated successfully";
                        } else {
                            return "Phone no already exist";
                        }
                    } else {
                        userManagerRepository.save(user);
                        return "User details updated successfully";
                    }
                } else {
                    if (userManagerRepository.findByContactEmail(user.getContact().getEmail()) != null) {
                        id1 = userManagerRepository.findByContactEmail(user.getContact().getEmail()).getId();
                        if (userManagerRepository.findByContactPhoneNo(user.getContact().getPhoneNo()) != null) {
                            id2 = userManagerRepository.findByContactPhoneNo(user.getContact().getPhoneNo()).getId();
                            if (id1.equals(user.getId())) {
                                if (id2.equals(user.getId())) {
                                    userManagerRepository.save(user);
                                    return "User details updated successfully";
                                } else {
                                    return "Phone no already exist";
                                }
                            } else {
                                return "Email Id already exist";
                            }
                        } else {
                            if (id1.equals(user.getId())) {
                                userManagerRepository.save(user);
                                return "User details updated successfully";
                            } else {
                                return "Email Id already exist";
                            }
                        }

                    } else {
                        if (userManagerRepository.findByContactPhoneNo(user.getContact().getPhoneNo()) != null) {
                            id2 = userManagerRepository.findByContactPhoneNo(user.getContact().getPhoneNo()).getId();
                            if (id2.equals(user.getId())) {
                                userManagerRepository.save(user);
                                return "User details updated successfully";
                            } else {
                                return "Phone no already exist";
                            }
                        } else {
                            userManagerRepository.save(user);
                            return "User details updated successfully";
                        }
                    }
                }
            } else {
                userManagerRepository.save(user);
                return "User details updated successfully";
            }
        }

    }

    @Override
    public Users findUserByEmailId(String email) {
        Users user = userManagerRepository.findByContactEmail(email);
        return user;
    }

    @Override
    public String requestPasswordReset(String email) {

        Users user = userManagerRepository.findByContactEmail(email);

        if (user != null) {
            sendingToken = new Utilities().generatePasswordResetToken(user.getId());
            return sendingToken;
        } else {
            return "User with given Email-Id not found";
        }

    }

    @Override
    public String requestTokenValidate(String password, String confirmPassword, String token)
            throws UnsupportedEncodingException {

        receivedToken = token;
        sendingToken = rabbitTemplate.receiveAndConvert("notificationServiceQueue").toString();
        ResetPasswordRequest resetPasswordRequest = new ResetPasswordRequest();
        System.out.println("l"+sendingToken+"l");
        System.out.println("ansddd---");
        System.out.println(receivedToken);

        if (sendingToken.equals(receivedToken)) {
            Claims claims = new Utilities().decodePasswordResetToken(receivedToken);

            if (password.equals(confirmPassword)) {
                Optional<Users> user = userManagerRepository.findById(claims.getId());
                Users fetchedUser = user.get();
                fetchedUser.setPassword(password);
//                rabbitTemplate.convertAndSend("competencyPortalExchange", "notificationServiceKey",
//                        fetchedUser.getContact().getEmail() + "," + "Your password has been updated successfully.");
                userManagerRepository.save(fetchedUser);
                return "Your password is successfully updated";
            } else {
                return "Password and confirm password should be same";
            }

        }

        return "You are not authorized to reset password";

    }

    @Override
    public List<Users> findUsersByRole(String role) {
        List<Users> users = userManagerRepository.findByRole(role);
        return users;
    }

    @Override
    public Users findUsersByRoleAndId(String role, String id) {
        Users users = userManagerRepository.findByRoleAndId(role, id);
        return users;
    }

}

package com.verizon.lambda.service;

import com.verizon.lambda.dao.UserActivityDetailsDao;
import com.verizon.lambda.entities.UserActivityDetails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class LeaderBoardServiceImpl implements LeaderBoardService {


	@Autowired
    private UserActivityDetailsDao dao;



    @Override
    public UserActivityDetails save(UserActivityDetails u) {
       u=dao.save(u);
        return u;
    }


    @Override
    public List<UserActivityDetails> findAll() {
        
        List<UserActivityDetails> userDetails =dao.findAll();
        
        return userDetails;
    }



    


   

}

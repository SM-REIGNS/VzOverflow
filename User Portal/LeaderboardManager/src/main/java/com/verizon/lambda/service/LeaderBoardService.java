package com.verizon.lambda.service;

import java.util.List;


import com.verizon.lambda.entities.UserActivityDetails;

public interface LeaderBoardService {

    UserActivityDetails save( UserActivityDetails u);

    List<UserActivityDetails> findAll();
	//List<UserActivityDetails> getLeaderBoardByPoints();


}

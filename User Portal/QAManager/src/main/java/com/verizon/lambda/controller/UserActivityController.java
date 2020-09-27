package com.verizon.lambda.controller;

import com.verizon.lambda.entities.*;
import com.verizon.lambda.service.UserActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserActivityController {
    @Autowired
    UserActivityService userActivityService;


    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping(value="/useractivity/add")
    public ResponseEntity<String> addUserActivity(@RequestBody UserActivityDetails userActivityDetails) {
    userActivityService.addUserActivity(userActivityDetails);
        ResponseEntity<String> responseEntity = new ResponseEntity<>("added sucessfully", HttpStatus.OK);
        return responseEntity;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(value="/useractivity/findbyid/{uid}")
    public ResponseEntity<UserActivityDetails> display(@PathVariable String uid){
       UserActivityDetails userActivityDetails= userActivityService.findByUserId(uid);
        ResponseEntity<UserActivityDetails> responseEntity=new ResponseEntity<>(userActivityDetails,HttpStatus.OK);
        return responseEntity;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping(value="/useractivity/updatepoints/{uid}")
    public ResponseEntity<String> updatePoints(@RequestBody Point points, @PathVariable String uid) {
        userActivityService.updatePoints(uid,points);
        ResponseEntity<String> responseEntity = new ResponseEntity<>("updated sucessfully", HttpStatus.OK);
        return responseEntity;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping(value="/useractivity/updatequestion/{uid}")
    public ResponseEntity<String> updatequestion(@RequestBody QuestionId question, @PathVariable String uid){
        userActivityService.updateQuestionId(uid,question);
        ResponseEntity<String> responseEntity = new ResponseEntity<>("updated sucessfully", HttpStatus.OK);
        return responseEntity;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping(value="/useractivity/deletequestion/{uid}")
    public ResponseEntity<String>  deletequestion(@RequestBody QuestionId question, @PathVariable String uid){
        userActivityService.deleteQuestionId(uid,question);
        ResponseEntity<String> responseEntity = new ResponseEntity<>("deleted sucessfully", HttpStatus.OK);
        return responseEntity;
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping(value="/useractivity/updateanswer/{uid}")
    public ResponseEntity<String> updateAnswer(@RequestBody AnswerId answer, @PathVariable String uid){
        userActivityService.updateAnswerId(uid,answer);
        ResponseEntity<String> responseEntity = new ResponseEntity<>("updated sucessfully", HttpStatus.OK);
        return responseEntity;
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping(value="/useractivity/deleteanswer/{uid}")
    public ResponseEntity<String>  deleteanswer(@RequestBody AnswerId answer, @PathVariable String uid){
        userActivityService.deleteAnswerId(uid,answer);
        ResponseEntity<String> responseEntity = new ResponseEntity<>("deleted sucessfully", HttpStatus.OK);
        return responseEntity;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping(value="/useractivity/updatefollower/{uid}")
    public ResponseEntity<String> updateFollower(@RequestBody Follower follower,@PathVariable String uid){
        userActivityService.updateFollowerId(uid,follower);
        userActivityService.updateFollowingUser(follower.getFollowerIds(),new FollowingUser(uid));
        ResponseEntity<String> responseEntity = new ResponseEntity<>("updated sucessfully", HttpStatus.OK);
        return responseEntity;
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping(value="/useractivity/deletefollower/{uid}")
    public ResponseEntity<String>  deletefollower(@RequestBody Follower follower,@PathVariable String   uid){
        userActivityService.deleteFollowerId(uid,follower);
        userActivityService.deleteFollowingUser(follower.getFollowerIds(),new FollowingUser(uid));
        ResponseEntity<String> responseEntity = new ResponseEntity<>("deleted sucessfully", HttpStatus.OK);
        return responseEntity;
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping(value="/useractivity/updatefollowinguser/{uid}")
    public ResponseEntity<String> updatefollowinguser(@RequestBody FollowingUser followingUser,@PathVariable String uid){
        userActivityService.updateFollowingUser(uid,followingUser);
        userActivityService.updateFollowerId(followingUser.getFollowingUserIds(),new Follower(uid));
        ResponseEntity<String> responseEntity = new ResponseEntity<>("updated sucessfully", HttpStatus.OK);
        return responseEntity;
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping(value="/useractivity/deletefollowinguser/{uid}")
    public ResponseEntity<String>  deletefollowinguser(@RequestBody FollowingUser followingUser,@PathVariable String uid){
        userActivityService.deleteFollowingUser(uid,followingUser);
        userActivityService.deleteFollowerId(followingUser.getFollowingUserIds(),new Follower(uid));

        ResponseEntity<String> responseEntity = new ResponseEntity<>("deleted sucessfully", HttpStatus.OK);
        return responseEntity;
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping(value="/useractivity/updatefollowingquestion/{uid}")
    public ResponseEntity<String> updatefollowingquestion(@RequestBody FollowingQuestion followingQuestion,@PathVariable String uid){
        userActivityService.updateFollowingQuestion(uid,followingQuestion);
        ResponseEntity<String> responseEntity = new ResponseEntity<>("updated sucessfully", HttpStatus.OK);
        return responseEntity;
    }

    @DeleteMapping(value="/useractivity/deletefollowingquestion/{uid}")
    public ResponseEntity<String>  deletefollowingquestion(@RequestBody FollowingQuestion followingQuestion,@PathVariable String uid){
        userActivityService.deleteFollowingQuestion(uid,followingQuestion);
        ResponseEntity<String> responseEntity = new ResponseEntity<>("deleted sucessfully", HttpStatus.OK);
        return responseEntity;
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping(value="/useractivity/updatefollowingtopic/{uid}")
    public ResponseEntity<String> updatefollowingtopic(@RequestBody FollowTopic followTopic,@PathVariable String uid) {
        userActivityService.updateFollowingTopic(uid, followTopic);
        ResponseEntity<String> responseEntity = new ResponseEntity<>("updated sucessfully", HttpStatus.OK);
        return responseEntity;
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping(value = "/useractivity/deletefollowingtopic/{uid}")
    public ResponseEntity<String> deletefollowtopic(@RequestBody FollowTopic followTopic,@PathVariable String uid){
        userActivityService.deleteFollowingTopic(uid,followTopic);
        ResponseEntity<String> responseEntity = new ResponseEntity<>("deleted sucessfully", HttpStatus.OK);
        return responseEntity;
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping(value="/useractivity/updateanswerreports/{uid}")
    public ResponseEntity<String> updateanswerreports(@RequestBody AnswerReport answerReport,@PathVariable String uid){
        userActivityService.updateAnswerReports(uid,answerReport);
        ResponseEntity<String> responseEntity = new ResponseEntity<>("updated sucessfully", HttpStatus.OK);
        return responseEntity;
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping (value="/useractivity/updatequestionreports/{uid}")
    public ResponseEntity<String> updatequestionreports(@RequestBody QuestionReport questionReport,@PathVariable String uid){
        userActivityService.updateQuestionReports(uid,questionReport);
        ResponseEntity<String> responseEntity = new ResponseEntity<>("deleted sucessfully", HttpStatus.OK);
        return responseEntity;
    }
}

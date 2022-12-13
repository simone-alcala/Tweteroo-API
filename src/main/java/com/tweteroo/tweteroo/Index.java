package com.tweteroo.tweteroo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.util.JSONPObject;

@Controller
public class Index {

  List<User> users = new ArrayList<User>();
  List<Tweet> tweets = new ArrayList<Tweet>();
    
  @GetMapping("/health")
  @ResponseBody
  public ResponseEntity<Object> health() {
    return ResponseEntity.status(HttpStatus.OK).body("I am alive!");
  }
  
  @PostMapping("/sign-up")
  @ResponseBody
  public ResponseEntity<Object> signUp(@RequestBody User user) {
    
    for (int i = 0; i < users.size(); i++) {
      if (users.get(i).getUsername().equals(user.getUsername())) {    
        users.get(i).setAvatar(user.getAvatar());
        return ResponseEntity.status(HttpStatus.CREATED).body("OK");
      }
    } 
       
    users.add(user);
    return ResponseEntity.status(HttpStatus.CREATED).body("OK");
  }

  @GetMapping("/users")
  @ResponseBody
  public ResponseEntity<Object> usersList() {
    return ResponseEntity.status(HttpStatus.OK).body(users);
  }

  @PostMapping("/tweets")
  @ResponseBody
  public ResponseEntity<Object> addTweet (@RequestBody Tweet tweet) {
    
    if (!userExists(tweet)) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Username not found");
    } 
       
    tweets.add(tweet);
        
    return ResponseEntity.status(HttpStatus.CREATED).body("OK");
  }

  
  @GetMapping("/tweets")
  @ResponseBody
  public ResponseEntity<Object> tweetsList () {
    List<UsersTweet> listToReturn = new ArrayList<UsersTweet>();
    for (int i = 0; i < tweets.size(); i++) {
      for (int j = 0; j < users.size(); j++) {
        if (users.get(j).getUsername().equals(tweets.get(i).getUsername())) {    
          listToReturn.add( 
            new UsersTweet( 
              users.get(j).getUsername(), 
              users.get(j).getAvatar(),
              tweets.get(i).getTweet() 
            )
          );
        }
      }
    }
    return ResponseEntity.status(HttpStatus.OK).body(listToReturn);
  }
  
  public Boolean userExists(Tweet tweet) {
    for (int i = 0; i < users.size(); i++) {
      if (users.get(i).getUsername().equals(tweet.getUsername())) {    
        return true;
      }
    } 
    return false;
  }
}

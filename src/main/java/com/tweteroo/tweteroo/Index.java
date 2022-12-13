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
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class Index {

  List<User> users = new ArrayList<User>();
    
  @GetMapping("/health")
  @ResponseBody
  public ResponseEntity<Object> health() {
    return ResponseEntity.status(HttpStatus.OK).body("I am alive!");
  }
  
  @PostMapping("/sign-up")
  @ResponseBody
  @ResponseStatus(value = HttpStatus.CREATED)
  public ResponseEntity<Object> signUp(@RequestBody User user) {
    /*
    for (int i = 0; i < users.size(); i++) {
      if (users.get(i).getUsername().equals(user.getUsername())) {    
        return ResponseEntity.status(HttpStatus.CONFLICT).body("Username already exists");
      }
    } 
    */   
    users.add(user);
    return ResponseEntity.status(HttpStatus.CREATED).body("OK");
  }

  @GetMapping("/users")
  @ResponseBody
  public ResponseEntity<Object> usersList() {
    return ResponseEntity.status(HttpStatus.OK).body(users);
  }
  
}

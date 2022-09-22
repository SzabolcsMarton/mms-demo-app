package com.tsystems.mms.demoapp.user;

import java.net.URI;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 * RESTful API controller for managing users.
 */
@RestController
@RequestMapping(value ="/api/v1.0",produces = "application/json", method = {RequestMethod.GET, RequestMethod.DELETE, RequestMethod.POST, RequestMethod.PUT})
public class UserController {

  private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping("/user")
  public ResponseEntity getUsers() {

    LOGGER.info("Get all users from the database");
    return ResponseEntity.ok(userService.getAll());
  }
  
  @GetMapping("/user/{userId}")
  public ResponseEntity<User> getOneUser(@PathVariable Long userId ){
      User user = userService.getUserById(userId);
      if(user == null)
	  throw new UserNotFoundException("Cannot find user with id: " + userId);
      LOGGER.info("Get user from the database with id: " + userId);
      return ResponseEntity.ok(user);
  }
  
  @PostMapping("/user")
  public ResponseEntity<User> createUser(@RequestBody User user){
      User savedUser = userService.insert(user);
      HttpHeaders httpHeaders = new HttpHeaders();
      httpHeaders.add("user", "/api/v1.0/user/" + savedUser.getId().toString());
      return new ResponseEntity(savedUser, httpHeaders, HttpStatus.CREATED);

  }
  
  @DeleteMapping("/user/{userId}")
  public ResponseEntity<User> deleteUser(@PathVariable Long userId) {
      userService.deleteUser(userId);
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
  
  @PutMapping("user/{userId}")
  public ResponseEntity<User> updateUser(@PathVariable("userId") Long userId, @RequestBody User user){
      userService.updateUser(userId, user);
      return new ResponseEntity<>(userService.getUserById(userId), HttpStatus.OK);
  }
  
  
  
  
 
}
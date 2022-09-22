package com.tsystems.mms.demoapp.user;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * This service manages all user.
 */
@Service
@Transactional
public class UserService {

  private final UserRepository userRepository;

  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

 //Get All users
  public List<User> getAll() {
    return userRepository.findAll();
  }
  //Get one user
  public User getUserById(Long id) {
      return userRepository.findById(id).get();
  }
  //Create user
  public User insert(User user) {
      return userRepository.save(user);
  }
  //Update user
  public void updateUser(Long id, User user) {
      User userFromDb = userRepository.findById(id).get();
      userFromDb.setEmail(user.getEmail());
      userRepository.save(userFromDb);   
  }
 
  //Delete user
  public void deleteUser(Long id) {
      userRepository.deleteById(id);
  }
}

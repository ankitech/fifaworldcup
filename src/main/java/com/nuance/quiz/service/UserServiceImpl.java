package com.nuance.quiz.service;

import com.nuance.quiz.entity.User;
import com.nuance.quiz.repository.UserRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
  private final UserRepository userRepository;

  public UserServiceImpl(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public List<User> getAllUsers() {
    return userRepository.findAll();
  }

  @Override
  public User getUser(Integer userId) {
    return userRepository.findById(userId)
        .orElseThrow(() -> new IllegalArgumentException("Userid incorrect"));
  }
}

package com.nuance.quiz.service;

import com.nuance.quiz.entity.User;
import java.util.List;
import org.springframework.data.util.Pair;

public interface UserService {

  List<User> getAllUsers();

  User getUser(Integer userId);

  User createUser(User user);

  Pair<String,User> authenticateUser(String username, String password);
}

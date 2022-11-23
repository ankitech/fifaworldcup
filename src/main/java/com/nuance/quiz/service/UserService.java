package com.nuance.quiz.service;

import com.nuance.quiz.entity.User;
import com.nuance.quiz.exception.GeneralException;
import java.util.List;
import org.springframework.data.util.Pair;

public interface UserService {

  List<User> getAllUsers();

  User getUser(Integer userId) throws GeneralException;

  User createUser(User user);

  Pair<String,User> authenticateUser(String username, String password) throws GeneralException;
}

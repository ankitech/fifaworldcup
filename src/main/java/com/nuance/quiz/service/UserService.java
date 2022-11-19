package com.nuance.quiz.service;

import com.nuance.quiz.entity.User;
import java.util.List;

public interface UserService {

  List<User> getAllUsers();

  User getUser(Integer userId);
}

package com.nuance.quiz.service;

import com.nuance.quiz.entity.User;
import com.nuance.quiz.exception.GeneralException;
import com.nuance.quiz.repository.UserRepository;
import com.nuance.quiz.util.JwtTokenUtil;
import java.util.List;
import org.springframework.data.util.Pair;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
  private final UserRepository userRepository;

  private final JwtTokenUtil jwtTokenUtil;

  public UserServiceImpl(UserRepository userRepository, JwtTokenUtil jwtTokenUtil) {
    this.userRepository = userRepository;
    this.jwtTokenUtil = jwtTokenUtil;
  }

  @Override
  public List<User> getAllUsers() {
    return userRepository.findAll();
  }

  @Override
  public User getUser(Integer userId) throws GeneralException {
    return userRepository.findById(userId)
        .orElseThrow(() -> new GeneralException(HttpStatus.UNAUTHORIZED,"Userid incorrect"));
  }

  @Override
  public User createUser(User user) {
    return userRepository.save(user);
  }
  @Override
  public Pair<String,User> authenticateUser(String username, String password)
      throws GeneralException {
    User user = userRepository.findByEmail(username)
        .orElseThrow(() -> new GeneralException(HttpStatus.UNAUTHORIZED,"User Not found"));
    if(user.getPassword().equals(password)) {
      return Pair.of(jwtTokenUtil.generateToken(user), user);
    } else {
      throw new GeneralException(HttpStatus.UNAUTHORIZED,"User Not found");
    }
  }

  //TODO: controller advise
  //TODO: leaderboard
}

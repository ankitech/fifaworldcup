package com.nuance.quiz.controller;

import com.nuance.quiz.entity.Prediction;
import com.nuance.quiz.entity.User;
import com.nuance.quiz.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import org.springframework.data.util.Pair;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@Api(value = "User Controller")
@RestController
@RequestMapping("/users")
public class UserController {

  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }
  @GetMapping
  @ApiOperation(value = "Get all users", response = User.class, responseContainer = "List",
      produces = MediaType.APPLICATION_JSON_VALUE)
  public List<User> getAllUsers() {
    return userService.getAllUsers();
  }

  @PostMapping("/signup")
  @ApiOperation(value = "sign up user", response = Prediction.class,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public User createUser(@RequestBody User user) {
    return userService.createUser(user);
  }

  @PostMapping("/login")
  @ApiOperation(value = "sign up user", response = Prediction.class,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public User autheticateUser(@RequestHeader(value = "username") String username,
                                              @RequestHeader(value = "password") String password) {

    Pair<String,User> token = userService.authenticateUser(username, password);
    HttpHeaders responseHeaders = new HttpHeaders();
    responseHeaders.set("token", token.getFirst());

    User user = token.getSecond();
    User result = User.builder()
        .userId(user.getUserId())
        .email(user.getEmail())
        .fname(user.getFname())
        .lname(user.getLname())
        .team(user.getTeam())
        .totalPoints(user.getTotalPoints())
        .token(token.getFirst())
        .build();

    return result;
  }
}

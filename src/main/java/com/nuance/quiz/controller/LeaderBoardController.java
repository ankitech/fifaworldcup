package com.nuance.quiz.controller;

import com.nuance.quiz.entity.LeaderBoard;
import com.nuance.quiz.service.LeaderBoardService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@Api(value = "Leader Board Controller")
@RestController
@RequestMapping("/leaderboard")
public class LeaderBoardController {

  private final LeaderBoardService leaderBoardService;

  public LeaderBoardController(LeaderBoardService leaderBoardService) {
    this.leaderBoardService = leaderBoardService;
  }


  @GetMapping
  @ApiOperation(value = "Get all leaders", response = LeaderBoard.class, responseContainer = "List",
      produces = MediaType.APPLICATION_JSON_VALUE)
  public List<LeaderBoard> getAllLeaderBoard() {
    return leaderBoardService.getAllLeaderBoard();
  }

}

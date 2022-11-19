package com.nuance.quiz.controller;

import com.nuance.quiz.entity.Match;
import com.nuance.quiz.service.MatchService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin
@Api(value = "Match Controller")
@RestController
@RequestMapping("/match")
public class MatchController {

  private MatchService matchService;

  public MatchController(MatchService matchService) {
    this.matchService = matchService;
  }

  @GetMapping
  @ApiOperation(value = "Get all matches", response = Match.class, responseContainer = "List",
      produces = MediaType.APPLICATION_JSON_VALUE)
  public List<Match> getAllMatch() {
    return matchService.getAllMatches();
  }
}

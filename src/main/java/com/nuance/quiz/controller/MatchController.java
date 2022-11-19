package com.nuance.quiz.controller;

import com.nuance.quiz.entity.Match;
import com.nuance.quiz.service.MatchService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/match")
public class MatchController {

  private MatchService matchService;

  public MatchController(MatchService matchService) {
    this.matchService = matchService;
  }

  @GetMapping
  public List<Match> getAllMatch() {
    return matchService.getAllMatches();
  }
}

package com.nuance.quiz.service;

import com.nuance.quiz.entity.Match;
import java.util.List;

public interface MatchService {

  List<Match> getAllMatches();
  List<Match> getCurrentMatches();

  Match getMatch(Integer matchId);
}

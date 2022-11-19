package com.nuance.quiz.service;

import com.nuance.quiz.entity.Match;
import java.util.List;

public interface MatchService {

  List<Match> getAllMatches();

  Match getMatch(Integer matchId);
}

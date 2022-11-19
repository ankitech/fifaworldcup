package com.nuance.quiz.service;

import com.nuance.quiz.entity.Match;
import com.nuance.quiz.repository.MatchRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class MatchServiceImpl implements MatchService{
  private MatchRepository matchRepository;

  public MatchServiceImpl(MatchRepository matchRepository) {
    this.matchRepository = matchRepository;
  }

  @Override
  public List<Match> getAllMatches() {
    return matchRepository.findAll();
  }

  @Override
  public Match getMatch(Integer matchId) {
    return matchRepository.findById(matchId)
        .orElseThrow(() -> new IllegalArgumentException("matchId incorrect"));
  }
}

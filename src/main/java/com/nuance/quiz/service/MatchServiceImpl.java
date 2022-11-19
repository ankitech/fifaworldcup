package com.nuance.quiz.service;

import com.nuance.quiz.entity.Match;
import com.nuance.quiz.repository.MatchRepository;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MatchServiceImpl implements MatchService{
  private MatchRepository matchRepository;

  @Value("${match.cutoff}")
  private int cutoffMins;

  @Value("${match.window}")
  private int windowHours;

  public MatchServiceImpl(MatchRepository matchRepository) {
    this.matchRepository = matchRepository;
  }

  @Override
  public List<Match> getAllMatches() {
    return matchRepository.findAll();
  }
  @Override
  public List<Match> getCurrentMatches() {

    LocalDateTime localDateTime = LocalDateTime.now(ZoneId.of("GMT"));

    LocalDateTime startTime = localDateTime.minusMinutes(cutoffMins);
    LocalDateTime endTime = localDateTime.plusHours(windowHours);

    return matchRepository.findAllWithMatchTsBetween(startTime, endTime);
  }

  @Override
  public Match getMatch(Integer matchId) {
    return matchRepository.findById(matchId)
        .orElseThrow(() -> new IllegalArgumentException("matchId incorrect"));
  }
}

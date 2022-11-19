package com.nuance.quiz.repository;

import com.nuance.quiz.entity.Match;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MatchRepository extends JpaRepository<Match, Integer> {

  @Query(value = "select m FROM Match m WHERE m.matchTs > :startTime AND m.matchTs < :endTime")
  List<Match> findAllWithMatchTsBetween(
      @Param(value = "startTime") LocalDateTime startTime,
      @Param(value = "endTime") LocalDateTime endTime);
}

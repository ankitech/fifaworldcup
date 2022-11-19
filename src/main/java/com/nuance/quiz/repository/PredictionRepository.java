package com.nuance.quiz.repository;

import com.nuance.quiz.entity.Match;
import com.nuance.quiz.entity.Prediction;
import com.nuance.quiz.entity.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PredictionRepository extends JpaRepository<Prediction, Integer> {
  Optional<Prediction> findByUserAndMatch(User user, Match match);
}

package com.nuance.quiz.repository;

import com.nuance.quiz.entity.Prediction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PredictionRepository extends JpaRepository<Prediction, Integer> {
}

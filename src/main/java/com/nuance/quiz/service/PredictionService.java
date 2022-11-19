package com.nuance.quiz.service;

import com.nuance.quiz.entity.Prediction;
import java.util.List;

public interface PredictionService {
  
  List<Prediction> getPrediction();

  Prediction createPrediction(Integer userId, Integer matchId, Prediction prediction);
}

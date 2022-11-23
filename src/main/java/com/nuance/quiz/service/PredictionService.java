package com.nuance.quiz.service;

import com.nuance.quiz.entity.Prediction;
import com.nuance.quiz.exception.GeneralException;
import java.util.List;
import java.util.Map;

public interface PredictionService {
  
  List<Prediction> getAllPrediction();

  Prediction createPrediction(Integer userId, Integer matchId, Prediction prediction)
      throws GeneralException;

  Map<Integer, Integer> getPredictionByUserId(int userId) throws GeneralException;
}

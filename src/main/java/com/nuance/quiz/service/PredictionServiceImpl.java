package com.nuance.quiz.service;

import com.nuance.quiz.entity.Match;
import com.nuance.quiz.entity.Prediction;
import com.nuance.quiz.entity.User;
import com.nuance.quiz.repository.PredictionRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class PredictionServiceImpl implements PredictionService{

  private PredictionRepository predictionRepository;
  private MatchService matchService;
  private UserService userService;

  public PredictionServiceImpl(PredictionRepository predictionRepository, MatchService matchService,
                               UserService userService) {
    this.predictionRepository = predictionRepository;
    this.matchService = matchService;
    this.userService = userService;
  }

  @Override
  public List<Prediction> getPrediction() {
    return predictionRepository.findAll();
  }

  @Override
  public Prediction createPrediction(Integer userId, Integer matchId, Prediction prediction) {
    //TODO: validate if already predicted and match is valid for prediction
    Match match = matchService.getMatch(matchId);
    User user = userService.getUser(userId);
    prediction.setMatch(match);
    prediction.setUser(user);
//    prediction.setMatch_id(matchId);
//    prediction.setUser_id(userId);
    return predictionRepository.save(prediction);
  }
}

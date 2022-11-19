package com.nuance.quiz.service;

import com.nuance.quiz.entity.Match;
import com.nuance.quiz.entity.Prediction;
import com.nuance.quiz.entity.User;
import com.nuance.quiz.repository.PredictionRepository;
import java.util.List;
import java.util.Optional;
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
    User user = userService.getUser(userId);
    Match match = matchService.getMatch(matchId);
    Optional<Prediction> predictionOptional = predictionRepository.findByUserAndMatch(user, match);
    if(predictionOptional.isPresent()){
      throw new IllegalArgumentException("prediction already done for userid: " + userId + " matchid: "+ matchId);
    } else {
      prediction.setUser(user);
      prediction.setMatch(match);
      return predictionRepository.save(prediction);
    }
  }
}

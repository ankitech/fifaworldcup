package com.nuance.quiz.service;

import static java.util.stream.Collectors.toMap;

import com.nuance.quiz.entity.Match;
import com.nuance.quiz.entity.Prediction;
import com.nuance.quiz.entity.User;
import com.nuance.quiz.exception.GeneralException;
import com.nuance.quiz.repository.PredictionRepository;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.http.HttpStatus;
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
  public List<Prediction> getAllPrediction() {
    return predictionRepository.findAll();
  }

  @Override
  public Prediction createPrediction(Integer userId, Integer matchId, Prediction prediction)
      throws GeneralException {
    User user = userService.getUser(userId);
    Match match = matchService.getMatch(matchId);
    Optional<Prediction> predictionOptional = predictionRepository.findByUserAndMatch(user, match);
    if(predictionOptional.isPresent()){
      throw new GeneralException(HttpStatus.CONFLICT,"prediction already done for userid: " + userId + " matchid: "+ matchId);
    } else {
      prediction.setUser(user);
      prediction.setMatch(match);
      return predictionRepository.save(prediction);
    }
  }

  @Override
  public Map<Integer, Integer> getPredictionByUserId(int userId) throws GeneralException {
    User user = userService.getUser(userId);
    List<Prediction> userPredictions = predictionRepository.findByUser(user);

    return userPredictions
        .stream()
        .collect(toMap(prediction -> prediction.getMatch().getMatchId(), Prediction::getPrediction)
    );
  }
}

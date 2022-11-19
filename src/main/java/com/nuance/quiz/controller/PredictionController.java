package com.nuance.quiz.controller;

import com.nuance.quiz.entity.Prediction;
import com.nuance.quiz.service.PredictionService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/predict")
public class PredictionController {

  private PredictionService predictionService;

  public PredictionController(PredictionService predictionService) {
    this.predictionService = predictionService;
  }

  @GetMapping
  public List<Prediction> getAllPrediction() {
    return predictionService.getPrediction();
  }

  @PostMapping(value = "/user/{userId}/match/{matchId}", consumes = {"application/json"})
  public Prediction addPrediction(@PathVariable int userId, @PathVariable int matchId, @RequestBody Prediction prediction) {
    //TODO: validate if already predicted and match is valid for prediction
    return predictionService.createPrediction(userId, matchId, prediction);
  }
}

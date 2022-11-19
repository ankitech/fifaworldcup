package com.nuance.quiz.controller;

import com.nuance.quiz.entity.Prediction;
import com.nuance.quiz.service.PredictionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "Prediction Controller")
@RestController
@RequestMapping("/predict")
public class PredictionController {

  private PredictionService predictionService;

  public PredictionController(PredictionService predictionService) {
    this.predictionService = predictionService;
  }

  @GetMapping
  @ApiOperation(value = "Get all predictions", response = Prediction.class, responseContainer = "List",
      produces = MediaType.APPLICATION_JSON_VALUE)
  public List<Prediction> getAllPrediction() {
    return predictionService.getPrediction();
  }

  @PostMapping(value = "/user/{userId}/match/{matchId}", consumes = {"application/json"})
  @ApiOperation(value = "add new prediction", response = Prediction.class,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public Prediction addPrediction(@PathVariable int userId, @PathVariable int matchId, @RequestBody Prediction prediction) {
    //TODO: validate if user id same as logged in user
    return predictionService.createPrediction(userId, matchId, prediction);
  }
}

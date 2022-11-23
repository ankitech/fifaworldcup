package com.nuance.quiz.controller;

import com.nuance.quiz.entity.Prediction;
import com.nuance.quiz.exception.GeneralException;
import com.nuance.quiz.service.PredictionService;
import com.nuance.quiz.util.CommonUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@Api(value = "Prediction Controller")
@RestController
@RequestMapping("/predict")
public class PredictionController {

  private PredictionService predictionService;

  public PredictionController(PredictionService predictionService) {
    this.predictionService = predictionService;
  }

  @GetMapping
  @Deprecated
  @ApiOperation(value = "Get all predictions", response = Prediction.class, responseContainer = "List",
      produces = MediaType.APPLICATION_JSON_VALUE)
  public List<Prediction> getAllPrediction() {
    return predictionService.getAllPrediction();
  }

  @GetMapping(value = "/user/{userId}")
  @ApiOperation(value = "Get prediction by id", response = Map.class,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public Map<Integer, Integer> getPrediction(@PathVariable int userId) throws GeneralException {

    //validate if user id same as logged in user
    String username = CommonUtils.getContext().getUsername();
    if(!username.equals(String.valueOf(userId))){
      throw new GeneralException(HttpStatus.UNAUTHORIZED, "user id is incorrect");
    }

    return predictionService.getPredictionByUserId(userId);
  }

  @PostMapping(value = "/user/{userId}/match/{matchId}", consumes = {"application/json"})
  @ApiOperation(value = "add new prediction", response = Prediction.class,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public Prediction addPrediction(@PathVariable int userId, @PathVariable int matchId, @RequestBody Prediction prediction)
      throws GeneralException {

    //validate if user id same as logged in user
    String username = CommonUtils.getContext().getUsername();
    if(!username.equals(String.valueOf(userId))){
      throw new GeneralException(HttpStatus.UNAUTHORIZED, "user id is incorrect");
    }

    return predictionService.createPrediction(userId, matchId, prediction);
  }
}

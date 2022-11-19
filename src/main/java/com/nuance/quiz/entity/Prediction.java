package com.nuance.quiz.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;

@Getter
@Setter
@Builder
@Entity
@Table(name = "user_prediction")
@NoArgsConstructor
@AllArgsConstructor
public class Prediction {

  @Id
  @GeneratedValue
  private int predictionId;

  @ManyToOne
  @JoinColumn(name="user_id")
  @JsonIgnoreProperties("predictions")
  private User user;

  @ManyToOne
  @JoinColumn(name="match_id")
  @JsonIgnoreProperties("predictions")
  private Match match;

  private Integer prediction;

  @Nullable
  private Integer pointPerMatch;
}

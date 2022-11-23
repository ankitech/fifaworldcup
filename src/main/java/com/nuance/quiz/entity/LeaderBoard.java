package com.nuance.quiz.entity;

import io.swagger.annotations.ApiModel;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@ApiModel(description = "leaderboard details object")
@Getter
@Setter
@Builder
@Entity
@Table(name = "leaderboard")
@NoArgsConstructor
@AllArgsConstructor
public class LeaderBoard {

  @Id
  private int userId;

  private String fname;

  private String lname;

  private int points;
}

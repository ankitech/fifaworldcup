package com.nuance.quiz.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.annotations.ApiModel;
import java.time.LocalDateTime;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;

@ApiModel(description = "Match details object")
@Getter
@Setter
@Builder
@Entity
@Table(name = "match_master")
@NoArgsConstructor
@AllArgsConstructor
public class Match {

  @Id
  @GeneratedValue
  private int matchId;
  private String team_A;
  private String team_B;
  private LocalDateTime matchTs;
  @Nullable
  private Integer result;
  private Integer points;

  @OneToMany(mappedBy = "match")
  @JsonIgnoreProperties("match")
  private Set<Prediction> predictions;
}

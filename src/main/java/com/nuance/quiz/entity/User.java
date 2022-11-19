package com.nuance.quiz.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
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

@ApiModel(description = "User details object")
@Getter
@Setter
@Builder
@Entity
@Table(name = "user_master")
@NoArgsConstructor
@AllArgsConstructor
public class User {

  @Id
  @GeneratedValue
  private int user_id;
  private String userEmail;
  private String password;
  private String fname;
  private String lname;
  private Integer totalPoints;

  @OneToMany(mappedBy = "user")
  @JsonIgnoreProperties("user")
  private Set<Prediction> predictions;

}

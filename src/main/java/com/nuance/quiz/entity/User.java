package com.nuance.quiz.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;

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
  private int userId;
  @Column(name = "user_email")
  private String email;
  private String password;
  private String fname;
  private String lname;
  private String team;
  @Nullable
  private Integer totalPoints;
  @OneToMany(mappedBy = "user")
  @JsonIgnoreProperties("user")
  private Set<Prediction> predictions;
  @JsonInclude
  @Transient
  private String token;

}

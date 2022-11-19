package com.nuance.quiz.repository;

import com.nuance.quiz.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Integer> {

  @Query(value = "select u FROM User u WHERE u.userEmail = :email")
  User findByUserEmail(@Param(value = "email") String email);
}

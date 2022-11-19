package com.nuance.quiz.repository;

import com.nuance.quiz.entity.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

  Optional<User> findByUserEmail(String email);
}

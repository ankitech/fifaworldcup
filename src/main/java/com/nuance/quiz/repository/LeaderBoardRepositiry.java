package com.nuance.quiz.repository;

import com.nuance.quiz.entity.LeaderBoard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeaderBoardRepositiry extends JpaRepository<LeaderBoard, Integer> {
}

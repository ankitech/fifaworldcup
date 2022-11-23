package com.nuance.quiz.service;

import com.nuance.quiz.entity.LeaderBoard;
import com.nuance.quiz.repository.LeaderBoardRepositiry;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class LeaderBoardServiceImpl implements LeaderBoardService {

  private final LeaderBoardRepositiry leaderBoardRepositiry;

  public LeaderBoardServiceImpl(LeaderBoardRepositiry leaderBoardRepositiry) {
    this.leaderBoardRepositiry = leaderBoardRepositiry;
  }

  @Override
  public List<LeaderBoard> getAllLeaderBoard() {
    return leaderBoardRepositiry.findAll();
  }
}

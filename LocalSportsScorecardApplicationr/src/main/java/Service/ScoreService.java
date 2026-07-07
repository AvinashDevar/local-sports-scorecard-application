package com.example.demo.Service;

import com.example.demo.Entity.Score;

public interface ScoreService {

	
	Score saveScore(Score score);
	
	 Score updateScore(int id,Score score);

	 void deleteScore(int id);     

	  Score getScoreByMatch(int matchId);
	
	
}

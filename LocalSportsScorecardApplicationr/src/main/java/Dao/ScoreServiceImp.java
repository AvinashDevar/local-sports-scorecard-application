package com.example.demo.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Score;
import com.example.demo.Repository.ScoreRepository;
import com.example.demo.Service.ScoreService;

@Service
public class ScoreServiceImp implements ScoreService {

	@Autowired
	private ScoreRepository scoreRepo;
	@Override
	public Score saveScore(Score score) {
		// TODO Auto-generated method stub
		return scoreRepo.save(score);
	}

	@Override
	public Score updateScore(int id,Score score) {
		 Score existing=scoreRepo.findById(id).orElseThrow(() -> new RuntimeException("Score not found"));
		 existing.setTeam1Score(score.getTeam1Score());
		 existing.setTeam2Score(score.getTeam2Score());
		return scoreRepo.save(score);
	}

	@Override
	public void deleteScore(int id) {
		 Score existing=scoreRepo.findById(id).orElseThrow(() -> new RuntimeException("Score not found"));
		
		
	}

	@Override
	public Score getScoreByMatch(int matchId) {
		// TODO Auto-generated method stub
		return scoreRepo.findByMatchId(matchId);
	}

}

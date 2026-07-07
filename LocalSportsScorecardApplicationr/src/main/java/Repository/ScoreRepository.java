package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.Score;

public interface ScoreRepository extends JpaRepository<Score, Integer>{
	
	
    List<Score> findByResult(String result);
    Score findByMatchId(int matchId);

}

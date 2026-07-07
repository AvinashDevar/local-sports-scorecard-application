package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.Match;

public interface MatchRepository extends JpaRepository<Match, Integer> {
	
	
	List<Match> findByMatchDate(String matchDate);
	

}

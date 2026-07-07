package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.Tournament;

public interface TournamentRepository extends JpaRepository<Tournament, Integer> {
	
	
	

}

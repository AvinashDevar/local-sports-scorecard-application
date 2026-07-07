package com.example.demo.Service;

import java.util.List;

import com.example.demo.Entity.Tournament;

public interface TournamentService {

	
	Tournament createTournament(Tournament tournament);
	List<Tournament> getAllTournamnet();
	Tournament getById(int id);
	Tournament updateTournament(int id,Tournament tournament);
	void deletTournament(int id);
	
}

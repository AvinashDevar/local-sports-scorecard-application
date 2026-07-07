package com.example.demo.Service;

import java.util.List;

import com.example.demo.Entity.Match;

public interface MatchService {
	
	 Match createMatch(Match match);

	    Match updateMatch(int id, Match match);   

	    void deleteMatch(int id);                 

	    List<Match> getMatchesByTournament(int tournamentId);

	    Match getMatchOrThrow(int id);

}

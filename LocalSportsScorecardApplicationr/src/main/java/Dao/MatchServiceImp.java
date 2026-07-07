package com.example.demo.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Match;
import com.example.demo.Entity.Tournament;
import com.example.demo.Repository.MatchRepository;
import com.example.demo.Repository.TournamentRepository;
import com.example.demo.Service.MatchService;
@Service
public class MatchServiceImp implements MatchService{
	
	@Autowired
	private MatchRepository matchRepo;
	@Autowired
	private TournamentRepository tournamentRepo;

	@Override
	public Match createMatch(Match match) {
		   if (match.getTeam1() == null || match.getTeam2() == null) {
		        throw new RuntimeException("Both teams must be provided");
		    }
		 if (match.getTeam1().getId() == match.getTeam2().getId()) {
	            throw new RuntimeException("Both teams cannot be same");
	        }
		 Tournament tournament = tournamentRepo.findById(match.getTournament().getId())
		            .orElseThrow(() -> new RuntimeException("Tournament not found"));
		 match.setTournament(tournament);
		
		return matchRepo.save(match);
	}

	@Override
	public Match updateMatch(int id, Match match) {

        Match existing = matchRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Match not found"));

        existing.setTeam1(match.getTeam1());
        existing.setTeam2(match.getTeam2());
        existing.setTournament(match.getTournament());
      

        return matchRepo.save(existing);
	}

	@Override
	public void deleteMatch(int id) {
		   Match existing = matchRepo.findById(id)
	                .orElseThrow(() -> new RuntimeException("Match not found"));
		   matchRepo.delete(existing);
		
		
	}

	@Override
	public List<Match> getMatchesByTournament(int tournamentId) {
		if (tournamentId <= 0) {
	        throw new RuntimeException("Invalid tournament ID");
	    }
		return matchRepo.findAll();
	}

	@Override
	public Match getMatchOrThrow(int id) {
	    return matchRepo.findById(id)
	        .orElseThrow(() -> new RuntimeException("Match not found with id: " + id));
	}

}

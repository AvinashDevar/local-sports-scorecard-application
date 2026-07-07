package com.example.demo.Dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Tournament;
import com.example.demo.Repository.TournamentRepository;
import com.example.demo.Service.TournamentService;

@Service
public class TournamentServiceimp implements TournamentService
{
	
	@Autowired
	private TournamentRepository tournamentRepo;

	@Override
	public Tournament createTournament(Tournament tournament) {
		// TODO Auto-generated method stub
		return tournamentRepo.save(tournament);
	}

	@Override
	public List<Tournament> getAllTournamnet() {
		// TODO Auto-generated method stub
		return tournamentRepo.findAll();
	}

	@Override
	public Tournament getById(int id) {
		
		
		return tournamentRepo.findById(id).orElseThrow(() -> new NullPointerException("tournament not found"));
	           
	}

	@Override
	public Tournament updateTournament(int id, Tournament tournament) {
	Tournament existing=	tournamentRepo.findById(id).orElseThrow(() -> new NullPointerException("tournament not found")); 
	
	existing.setName(tournament.getName());
	existing.setHost(tournament.getHost());
	existing.setLocation(tournament.getLocation());
	
	return tournamentRepo.save(existing);	
			

	}

	@Override
	public void deletTournament(int id) {
		Tournament existing=tournamentRepo.findById(id).orElseThrow(() -> new  NullPointerException("tournamnet not found"));
		tournamentRepo.delete(existing);
		
	}

}

package com.example.demo.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Team;
import com.example.demo.Repository.TeamRepository;
import com.example.demo.Service.TeamService;

@Service
public class TeamServiceImp  implements TeamService{

	@Autowired
	private TeamRepository teamRepo;
	@Override
	public Team saveTeam(Team team) {
		
		return teamRepo.save(team);
	}

	@Override
	public List<Team> getAllteam() {
		// TODO Auto-generated method stub
		return  teamRepo.findAll();
	}

	@Override
	public Team getById(int id) {
		
		return teamRepo.findById(id)
        .orElseThrow(() -> new RuntimeException("Team not found"));
	}

	@Override
	public void deleteTeam(int id) {
		 Team existing = teamRepo.findById(id)
			        .orElseThrow(() -> new RuntimeException("Team not found"));
		 teamRepo.delete(existing);
		
	}

	@Override
	public Team UpdateTeam(int id, Team team) {
		 Team existing = teamRepo.findById(id)
			        .orElseThrow(() -> new RuntimeException("Team not found"));

        existing.setName(team.getName());

        return teamRepo.save(existing);
	}

}

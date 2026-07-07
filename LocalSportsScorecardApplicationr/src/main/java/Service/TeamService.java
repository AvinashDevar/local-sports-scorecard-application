package com.example.demo.Service;

import java.util.List;

import com.example.demo.Entity.Team;

public interface TeamService {
	
	Team saveTeam(Team team);
	List<Team> getAllteam();
	Team getById(int id);
	void deleteTeam(int id);
	Team UpdateTeam(int id , Team team);
	
	

}

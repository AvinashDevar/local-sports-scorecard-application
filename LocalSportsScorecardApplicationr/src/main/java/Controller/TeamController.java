package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Team;
import com.example.demo.Service.TeamService;
import com.example.demo.response.ResponceStructure;

@RestController
@RequestMapping("/teams")
public class TeamController {
    
	@Autowired
    private  TeamService service;

    

	 @PostMapping
	    public ResponseEntity<ResponceStructure<Team>> createTeam(@RequestBody Team team) {

	        Team saved = service.saveTeam(team);

	        ResponceStructure<Team> rs = new ResponceStructure<>();
	        rs.setMessage("Team created successfully");
	        rs.setData(saved);
	        rs.setStatusCode(201);

	        return new ResponseEntity<>(rs, HttpStatus.CREATED);
	    }

	    @GetMapping
	    public ResponseEntity<ResponceStructure<List<Team>>> getAllTeams() {

	        List<Team> list = service.getAllteam();

	        ResponceStructure<List<Team>> rs = new ResponceStructure<>();
	        rs.setMessage("Teams fetched");
	        rs.setData(list);
	        rs.setStatusCode(200);

	        return new ResponseEntity<>(rs, HttpStatus.OK);
	        
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<ResponceStructure<Team>> getTeam(@PathVariable int id) {

	        Team team = service.getById(id);

	        ResponceStructure<Team> rs = new ResponceStructure<>();
	        rs.setMessage("Team found");
	        rs.setData(team);
	        rs.setStatusCode(200);

	        return new ResponseEntity<>(rs, HttpStatus.OK);
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<ResponceStructure<Team>> updateTeam(@PathVariable int id, @RequestBody Team team) {

	        Team updated = service.UpdateTeam(id, team);

	        ResponceStructure<Team> rs = new ResponceStructure<>();
	        rs.setMessage("Team updated");
	        rs.setData(updated);
	        rs.setStatusCode(200);

	        return new ResponseEntity<>(rs, HttpStatus.OK);
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<ResponceStructure<String>> deleteTeam(@PathVariable int id) {

	        service.deleteTeam(id);

	        ResponceStructure<String> rs = new ResponceStructure<>();
	        rs.setMessage("Team deleted");
	        rs.setData(null);
	        rs.setStatusCode(200);

	        return new ResponseEntity<>(rs, HttpStatus.OK);
	    }
	}


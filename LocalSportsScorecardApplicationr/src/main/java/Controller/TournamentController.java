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
import org.springframework.web.service.annotation.PutExchange;

import com.example.demo.Entity.Tournament;
import com.example.demo.Service.TournamentService;
import com.example.demo.response.ResponceStructure;

@RestController
@RequestMapping("/tournament")
public class TournamentController {
	@Autowired
	private TournamentService service;
	
	@PostMapping
	public ResponseEntity<ResponceStructure<Tournament>> SaveTournament(@RequestBody Tournament tournament){
		
		Tournament save=service.createTournament(tournament);
		
		ResponceStructure<Tournament> rs=new ResponceStructure<>();
		rs.setMessage("data saved succfully");
		rs.setData(save);
		rs.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<> (rs, HttpStatus.OK);
		
	}
	
	@GetMapping
	public ResponseEntity<ResponceStructure<List<Tournament>>> getAllTournament(){
		
		List<Tournament> list=service.getAllTournamnet();
		
		ResponceStructure<List<Tournament>> rs=new ResponceStructure<>();
		rs.setData(list);
		rs.setMessage("Tournamnet fatch succefully");
		rs.setStatusCode(HttpStatus.OK.value());
		
		return new ResponseEntity<>(rs , HttpStatus.OK);
		
	}
	@GetMapping("/{id}")
	public ResponseEntity<ResponceStructure<Tournament>> getTournamentById(@PathVariable int id){
		
		Tournament tournament=service.getById(id);
		ResponceStructure<Tournament> rs= new ResponceStructure<>();
		rs.setData(tournament);
		rs.setMessage("Rournament fatch Successfully");
		rs.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<>(rs,HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ResponceStructure<Tournament>> updateTournament(@PathVariable int id,@RequestBody Tournament tournament){
		
		Tournament update=service.updateTournament(id, tournament);
		
		ResponceStructure<Tournament> rs=new ResponceStructure<>();
		rs.setData(update);
		rs.setMessage("updated Successfully");
		rs.setStatusCode(HttpStatus.OK.value());
		
		return new  ResponseEntity<>(rs, HttpStatus.OK);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ResponceStructure<String>> deleteTournament(@PathVariable int id){
		
		service.deletTournament(id);
		ResponceStructure<String> rs=new ResponceStructure<>();
		rs.setData(null);
		rs.setMessage("Tournament deleted");
		rs.setStatusCode(HttpStatus.OK.value());
		
		return new ResponseEntity<>(rs,HttpStatus.OK);
		
	}

}

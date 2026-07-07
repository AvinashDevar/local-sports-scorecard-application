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

import com.example.demo.Entity.Player;
import com.example.demo.Service.PlayerService;
import com.example.demo.response.ResponceStructure;

@RestController
@RequestMapping("/players")
public class PlayerController {

	@Autowired
    private  PlayerService service;

   

    @PostMapping
    public ResponseEntity<ResponceStructure<Player>> addPlayer(@RequestBody Player player) {

        Player saved = service.savePlayer(player);

        ResponceStructure<Player> rs = new ResponceStructure<>();
        rs.setMessage("Player added");
        rs.setData(saved);
        rs.setStatusCode(201);

        return new ResponseEntity<>(rs, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponceStructure<Player>> updatePlayer(@PathVariable int id, @RequestBody Player player) {

        Player updated = service.updatePlayer(id, player);

        ResponceStructure<Player> rs = new ResponceStructure<>();
        rs.setMessage("Player updated");
        rs.setData(updated);
        rs.setStatusCode(200);

        return new ResponseEntity<>(rs, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponceStructure<String>> deletePlayer(@PathVariable int id) {

        service.deletePlayer(id);

        ResponceStructure<String> rs = new ResponceStructure<>();
        rs.setMessage("Player deleted");
        rs.setData(null);
        rs.setStatusCode(200);

        return new ResponseEntity<>(rs, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<ResponceStructure<List<Player>>> getAllPlayers() {

        List<Player> players = service.getAllPlayer();

        ResponceStructure<List<Player>> rs = new ResponceStructure<>();
        rs.setMessage("Players fetched successfully");
        rs.setData(players);
        rs.setStatusCode(200);

        return new ResponseEntity<>(rs, HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<ResponceStructure<Player>> getPlayerById(@PathVariable int id){
    	
    	Player player=service.getbyId(id);
    	ResponceStructure<Player> rs=new ResponceStructure<>();
    	  rs.setMessage("Players fetched successfully");
          rs.setData(player);
          rs.setStatusCode(200);
          
          return new ResponseEntity<>(rs , HttpStatus.OK);

    	
    }
}

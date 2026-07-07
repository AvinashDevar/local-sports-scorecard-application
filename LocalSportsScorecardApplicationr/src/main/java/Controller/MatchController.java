package com.example.demo.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.Entity.Match;
import com.example.demo.Service.MatchService;
import com.example.demo.response.ResponceStructure;


@RestController
@RequestMapping("/matches")
public class MatchController {

	@Autowired
    private  MatchService service;

   
    // ✅ CREATE MATCH
    @PostMapping
    public ResponseEntity<ResponceStructure<Match>> createMatch(@RequestBody Match match) {

        Match saved = service.createMatch(match);

        ResponceStructure<Match> rs = new ResponceStructure<>();
        rs.setMessage("Match created successfully");
        rs.setData(saved);
        rs.setStatusCode(201);

        return new ResponseEntity<>(rs, HttpStatus.CREATED);
    }

    // ✅ UPDATE MATCH
    @PutMapping("/{id}")
    public ResponseEntity<ResponceStructure<Match>> updateMatch(
            @PathVariable int id,
            @RequestBody Match match) {

        Match updated = service.updateMatch(id, match);

        ResponceStructure<Match> rs = new ResponceStructure<>();
        rs.setMessage("Match updated successfully");
        rs.setData(updated);
        rs.setStatusCode(200);

        return new ResponseEntity<>(rs, HttpStatus.OK);
    }

    // ✅ DELETE MATCH
    @DeleteMapping("/{id}")
    public ResponseEntity<ResponceStructure<String>> deleteMatch(@PathVariable int id) {

        service.deleteMatch(id);

        ResponceStructure<String> rs = new ResponceStructure<>();
        rs.setMessage("Match deleted successfully");
        rs.setData(null);
        rs.setStatusCode(200);

        return new ResponseEntity<>(rs, HttpStatus.OK);
    }

    // ✅ GET MATCH BY ID
    @GetMapping("/{id}")
    public ResponseEntity<ResponceStructure<Match>> getMatch(@PathVariable int id) {

        Match match = service.getMatchOrThrow(id);

        ResponceStructure<Match> rs = new ResponceStructure<>();
        rs.setMessage("Match fetched successfully");
        rs.setData(match);
        rs.setStatusCode(200);

        return new ResponseEntity<>(rs, HttpStatus.OK);
    }

    // ✅ GET MATCHES BY TOURNAMENT
    @GetMapping("/tournament/{tournamentId}")
    public ResponseEntity<ResponceStructure<List<Match>>> getMatchesByTournament(
            @PathVariable int tournamentId) {

        List<Match> matches = service.getMatchesByTournament(tournamentId);

        ResponceStructure<List<Match>> rs = new ResponceStructure<>();
        rs.setMessage("Matches fetched successfully");
        rs.setData(matches);
        rs.setStatusCode(200);

        return new ResponseEntity<>(rs, HttpStatus.OK);
    }
}
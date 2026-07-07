package com.example.demo.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.Entity.Score;
import com.example.demo.Service.ScoreService;
import com.example.demo.response.ResponceStructure;


@RestController
@RequestMapping("/scores")
public class ScoreController {

    private final ScoreService service;

    public ScoreController(ScoreService service) {
        this.service = service;
    }

   
    @PostMapping
    public ResponseEntity<ResponceStructure<Score>> saveScore(@RequestBody Score score) {

        Score saved = service.saveScore(score);

        ResponceStructure<Score> rs = new ResponceStructure<>();
        rs.setMessage("Score saved successfully");
        rs.setData(saved);
        rs.setStatusCode(201);

        return new ResponseEntity<>(rs, HttpStatus.CREATED);
    }

   
    @PutMapping("/{id}")
    public ResponseEntity<ResponceStructure<Score>> updateScore( @PathVariable int id, @RequestBody Score score) {

        Score updated = service.updateScore(id, score);

        ResponceStructure<Score> rs = new ResponceStructure<>();
        rs.setMessage("Score updated successfully");
        rs.setData(updated);
        rs.setStatusCode(200);

        return new ResponseEntity<>(rs, HttpStatus.OK);
    }

 
    @DeleteMapping("/{id}")
    public ResponseEntity<ResponceStructure<String>> deleteScore(@PathVariable int id) {

        service.deleteScore(id);

        ResponceStructure<String> rs = new ResponceStructure<>();
        rs.setMessage("Score deleted successfully");
        rs.setData(null);
        rs.setStatusCode(200);

        return new ResponseEntity<>(rs, HttpStatus.OK);
    }

    
    @GetMapping("/match/{matchId}")
    public ResponseEntity<ResponceStructure<Score>> getScoreByMatch(
            @PathVariable int matchId) {

        Score score = service.getScoreByMatch(matchId);

        ResponceStructure<Score> rs = new ResponceStructure<>();
        rs.setMessage("Score fetched successfully");
        rs.setData(score);
        rs.setStatusCode(200);

        return new ResponseEntity<>(rs, HttpStatus.OK);
    }
}
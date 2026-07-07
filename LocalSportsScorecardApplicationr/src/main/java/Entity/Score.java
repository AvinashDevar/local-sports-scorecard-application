package com.example.demo.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Score {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id;
	    private int team1Score;
	    private int team2Score;
	    private String result;
	    
	    @OneToOne
	    @JoinColumn(name = "match_id")
	    private Match match;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public int getTeam1Score() {
			return team1Score;
		}

		public void setTeam1Score(int team1Score) {
			this.team1Score = team1Score;
		}

		public int getTeam2Score() {
			return team2Score;
		}

		public void setTeam2Score(int team2Score) {
			this.team2Score = team2Score;
		}

		public String getResult() {
			return result;
		}

		public void setResult(String result) {
			this.result = result;
		}

		public Match getMatch() {
			return match;
		}

		public void setMatch(Match match) {
			this.match = match;
		}

}

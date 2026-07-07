package com.example.demo.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Player;
import com.example.demo.Repository.PlayerRepository;
import com.example.demo.Service.PlayerService;

@Service
public class PlayerServiceimp implements PlayerService {
	@Autowired
	 private final PlayerRepository playerRepo;

	    public  PlayerServiceimp (PlayerRepository playerRepo) {
	        this.playerRepo = playerRepo;

 }

		@Override
		public Player savePlayer(Player player) {
			// TODO Auto-generated method stub
			return playerRepo.save(player);
		}

		@Override
		public List<Player> getAllPlayer() {
			// TODO Auto-generated method stub
			return playerRepo.findAll();
		}

		@Override
		public Player getbyId(int id) {
			// TODO Auto-generated method stub
			return playerRepo.findById(id)
					   .orElseThrow(() -> new RuntimeException("player not found"));
		}

		@Override
		public Player updatePlayer(int id, Player player) {
			 
			Player existing = playerRepo.findById(id)
					   .orElseThrow(() -> new RuntimeException("player not found"));
			
			   existing.setName(player.getName());
		        existing.setRole(player.getRole());
		        existing.setTeam(player.getTeam());

		        return playerRepo.save(existing);
			 
		}

		@Override
		public void deletePlayer(int id) {
			 Player existing = playerRepo.findById(id)
					   .orElseThrow(() -> new RuntimeException("player not found"));

		        playerRepo.delete(existing);
			
		}
}

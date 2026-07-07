package com.example.demo.Service;

import java.util.List;

import com.example.demo.Entity.Player;

public interface PlayerService {
	
	Player savePlayer(Player player);
	List<Player> getAllPlayer();
	Player getbyId(int id);
	Player updatePlayer(int id,Player player);
	void deletePlayer (int id);
	
	

}

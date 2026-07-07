package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.Player;

public interface PlayerRepository extends JpaRepository<Player, Integer> {
	
	
	
	List<Player> findByRole(String role);
	
	List<Player> findByName(String name);

}

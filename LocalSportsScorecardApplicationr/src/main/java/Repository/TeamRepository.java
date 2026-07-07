package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.Team;
import java.util.List;


public interface TeamRepository extends JpaRepository<Team, Integer> {
	
	List<Team> findByName(String name);

	
	
}

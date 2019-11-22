package com.leaguedataaccess;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leaguedataaccess.jdbc.OwnerDAO;
import com.leaguedataaccess.jdbc.StatsDAO;
import com.leaguedataaccess.model.Owner;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class LeagueDataAccessController {

	private OwnerDAO ownerDAO;
	private StatsDAO statsDAO;
	
	@Autowired
	public LeagueDataAccessController(OwnerDAO ownerDAO, StatsDAO statsDAO) {
		this.ownerDAO = ownerDAO;
		this.statsDAO = statsDAO;
	}
	
	@GetMapping("/owners")
	public List<Owner> getListOfAllOwners() {
		return ownerDAO.getAllOwners();
	}
}

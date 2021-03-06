package com.leaguedataaccess.jdbc;

import java.util.List;

import com.leaguedataaccess.model.Owner;

public interface OwnerDAO {
	
	public List<Owner> getAllOwners();
	public Owner getOwnerById(int id);
	public List<Owner> getOwnersBySeason(int season);
	public List<Integer> getAllSeasons();
}

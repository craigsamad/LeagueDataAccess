package com.leaguedataaccess;

import java.util.List;

public interface OwnerDAO {
	
	public List<Owner> getAllOwners();
	public List<Owner> getOwnersBySeason(int season);
	public List<Integer> getAllSeasons();
}

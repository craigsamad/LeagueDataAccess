package com.leaguedataaccess;

public interface StatsDAO {

	public OwnerStats getHeadToHeadStats(Owner one, Owner two);
	public OwnerStats getTotalStatsForOneOwner(Owner one);
	public OwnerStats getRecordForOneOwnerOneSeason(Owner owner, int season);
}

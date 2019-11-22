package com.leaguedataaccess.jdbc;

import com.leaguedataaccess.model.Owner;
import com.leaguedataaccess.model.OwnerStats;

public interface StatsDAO {

	public OwnerStats getHeadToHeadStats(Owner one, Owner two);
	public OwnerStats getTotalStatsForOneOwner(Owner one);
	public OwnerStats getRegSeasonRecordForOneOwnerOneSeason(Owner owner, int season);
}

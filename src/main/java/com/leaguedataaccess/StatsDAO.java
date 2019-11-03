package com.leaguedataaccess;

public interface StatsDAO {

	public OwnerStats getHeadToHeadStats(Owner one, Owner two);
	public OwnerStats getTotalStatsForOneOwner(Owner one);
	public int getNumberOfWinsVsSelectedOwnerRegularSeason(Owner one, Owner two);
	public int getNumberOfWinsVsSelectedOwnerPostSeason(Owner one, Owner two);
	public double getTotalScoreVsSelectedOwnerRegularSeason(Owner one, Owner two);
	public double getTotalScoreVsSelectedOwnerPostSeason(Owner one, Owner two);
}

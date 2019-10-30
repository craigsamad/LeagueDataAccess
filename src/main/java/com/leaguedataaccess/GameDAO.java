package com.leaguedataaccess;

public interface GameDAO {

	public int getNumberOfWinsVsSelectedOwner(Owner one, Owner two);
	public double getTotalScoreVsSelectedOwner(Owner one, Owner two);
}

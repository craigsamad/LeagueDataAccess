package com.leaguedataaccess.jdbc;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.leaguedataaccess.model.Owner;
import com.leaguedataaccess.model.OwnerStats;

public class JDBCStatsDAO implements StatsDAO {

private JdbcTemplate jdbcTemplate;
	
	public JDBCStatsDAO(BasicDataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public OwnerStats getHeadToHeadStats(Owner one, Owner two) {
		OwnerStats hths = new OwnerStats();
		String sql = "SELECT os.score AS owner_one_score, g.type, OS2.score AS owner_two_score, "
				       + "CASE WHEN os.score > os2.score AND type = 1 THEN 1 ELSE 0 END AS reg_wins, "
				       + "CASE WHEN os.score < os2.score AND type = 1 THEN 1 ELSE 0 END AS reg_losses, "
				       + "CASE WHEN os.score = os2.score AND type = 1 THEN 1 ELSE 0 END AS reg_ties, "
				       + "CASE WHEN os.score > os2.score AND type != 1 THEN 1 ELSE 0 END AS post_wins, "
				       + "CASE WHEN os.score < os2.score AND type != 1 THEN 1 ELSE 0 END AS post_losses "
					+ "FROM owner_score os "
					+ "JOIN game g ON os.game_id = g.game_id "
					+ "JOIN owner_score os2 ON g.game_id = os2.game_id AND os2.owner_id = ? "
					+ "WHERE OS.owner_id = ?";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, two.getOwnerId(), one.getOwnerId());
		
		while (results.next()) {
			if (results.getInt("type") == 1) {
				hths.setRegScoreFor(results.getDouble("owner_one_score"));
				hths.setRegScoreAgainst(results.getDouble("owner_two_score"));
				hths.setRegWins(results.getInt("reg_wins"));
				hths.setRegLosses(results.getInt("reg_losses"));
				hths.setRegTies(results.getInt("reg_ties"));
			}
			else if (results.getInt("type") == 2 || results.getInt("type") == 4) {
				hths.setPostScoreFor(results.getDouble("owner_one_score"));
				hths.setPostScoreAgainst(results.getDouble("owner_two_score"));
				hths.setPostWins(results.getInt("post_wins"));
				hths.setPostLosses(results.getInt("post_losses"));
			}
		}	
		
		return hths;
	}
	
	public OwnerStats getTotalStatsForOneOwner(Owner one) {
		OwnerStats stats = new OwnerStats();

		String sql = "SELECT os.score AS owner_one_score, g.type, os2.owner_id, os2.score AS owner_two_score, "
				       + "CASE WHEN os.score > os2.score AND type = 1 THEN 1 ELSE 0 END AS reg_wins, "
				       + "CASE WHEN os.score < os2.score AND type = 1 THEN 1 ELSE 0 END AS reg_losses, "
				       + "CASE WHEN os.score = os2.score AND type = 1 THEN 1 ELSE 0 END AS reg_ties, "
				       + "CASE WHEN os.score > os2.score AND type != 1 THEN 1 ELSE 0 END AS post_wins, "
				       + "CASE WHEN os.score < os2.score AND type != 1 THEN 1 ELSE 0 END AS post_losses "
					+ "FROM owner_score os "
					+ "JOIN game g ON os.game_id = g.game_id "
					+ "JOIN owner_score os2 ON g.game_id = os2.game_id AND os2.owner_id != ? "
					+ "WHERE os.owner_id = ?";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, one.getOwnerId(), one.getOwnerId());
		
		while (results.next()) {
			if (results.getInt("type") == 1) {
				stats.setRegScoreFor(results.getDouble("owner_one_score"));
				stats.setRegScoreAgainst(results.getDouble("owner_two_score"));
				stats.setRegWins(results.getInt("reg_wins"));
				stats.setRegLosses(results.getInt("reg_losses"));
				stats.setRegTies(results.getInt("reg_ties"));
				if (results.getDouble("owner_one_score") > stats.getHighestRegScore() || stats.getHighestRegScore() == 0) {
					stats.setHighestRegScore(results.getDouble("owner_one_score"));
				}
				if (results.getDouble("owner_one_score") < stats.getLowestRegScore() || stats.getLowestRegScore() == 0) {
					stats.setLowestRegScore(results.getDouble("owner_one_score"));
				}
			}
			else if (results.getInt("type") == 2 || results.getInt("type") == 4) {
				stats.setPostScoreFor(results.getDouble("owner_one_score"));
				stats.setPostScoreAgainst(results.getDouble("owner_two_score"));
				stats.setPostWins(results.getInt("post_wins"));
				stats.setPostLosses(results.getInt("post_losses"));
			}
		}
		return stats;
	}
	
	public OwnerStats getRegSeasonRecordForOneOwnerOneSeason(Owner owner, int season) {
		OwnerStats record = new OwnerStats();
		String sql = "SELECT SUM(CASE WHEN os.score > os2.score AND type = 1 THEN 1 ELSE 0 END) AS wins, "
			              + "SUM(CASE WHEN os.score < os2.score AND type = 1 THEN 1 ELSE 0 END) AS losses, "
			              + "SUM(CASE WHEN os.score = os2.score AND type = 1 THEN 1 ELSE 0 END) AS ties "
			              + "FROM owner_score os "
			              + "JOIN game g ON os.game_id = g.game_id "
			              + "JOIN owner_score os2 ON g.game_id = os2.game_id AND os2.owner_id != ? "
			              + "WHERE os.owner_id = ? AND type = 1 AND SEASON = ?";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, owner.getOwnerId(), owner.getOwnerId(), season);
		
		if (results.next()) {
			record.setRegWins(results.getInt("wins"));
			record.setRegLosses(results.getInt("losses"));
			record.setRegTies(results.getInt("ties"));
		}
		
		return record;
	}
}

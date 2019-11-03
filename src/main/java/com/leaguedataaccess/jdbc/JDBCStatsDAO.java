package com.leaguedataaccess.jdbc;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.leaguedataaccess.StatsDAO;
import com.leaguedataaccess.OwnerStats;
import com.leaguedataaccess.Owner;

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
	
	public int getNumberOfWinsVsSelectedOwnerRegularSeason(Owner one, Owner two) {
		int numOfWins = 0;
		String sql = "select count(*) "
				+ "from owner_score a "
				+ "join owner_score b on a.game_id = b.game_id "
				+ "join game on game.game_id = a.game_id "
				+ "where a.owner_id = ? and b.owner_id = ? and a.score > b.score and type = 1";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, one.getOwnerId(), two.getOwnerId());
		
		if (results.next()) {
			numOfWins = results.getInt("count");
		}
		return numOfWins;
	}
	
	public int getNumberOfWinsVsSelectedOwnerPostSeason(Owner one, Owner two) {
		int numOfWins = 0;
		String sql = "select count(*) "
				+ "from owner_score a "
				+ "join owner_score b on a.game_id = b.game_id "
				+ "join game on game.game_id = a.game_id "
				+ "where a.owner_id = ? and b.owner_id = ? and a.score > b.score and type != 1";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, one.getOwnerId(), two.getOwnerId());
		
		if (results.next()) {
			numOfWins = results.getInt("count");
		}
		return numOfWins;
	}
	
	public double getTotalScoreVsSelectedOwnerRegularSeason(Owner one, Owner two) {
		double totalScore = 0;
		String sql = "select sum(score) "
				+ "from owner_score "
				+ "join game on game.game_id = owner_score.game_id "
				+ "where owner_id = ? and opponent_id = ? and type = 1";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, one.getOwnerId(), two.getOwnerId());
		
		if (results.next()) {
			totalScore += results.getDouble("sum");
		}
		
		return totalScore;
	}
	
	public double getTotalScoreVsSelectedOwnerPostSeason(Owner one, Owner two) {
		double totalScore = 0;
		String sql = "select sum(score) "
				+ "from owner_score "
				+ "join game on game.game_id = owner_score.game_id "
				+ "where owner_id = ? and opponent_id = ? and type != 1";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, one.getOwnerId(), two.getOwnerId());
		
		if (results.next()) {
			totalScore += results.getDouble("sum");
		}
		
		return totalScore;
	}
}

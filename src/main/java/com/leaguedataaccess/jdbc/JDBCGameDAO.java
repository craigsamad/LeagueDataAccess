package com.leaguedataaccess.jdbc;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.leaguedataaccess.GameDAO;
import com.leaguedataaccess.Owner;

public class JDBCGameDAO implements GameDAO {

private JdbcTemplate jdbcTemplate;
	
	public JDBCGameDAO(BasicDataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public int getNumberOfWinsVsSelectedOwner(Owner one, Owner two) {
		int numOfWins = 0;
		String sql = "select count(*) "
				+ "from game "
				+ "where win = true and owner_id = ? and opponent_id = ?";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, one.getOwnerId(), two.getOwnerId());
		
		if (results.next()) {
			numOfWins = results.getInt("count");
		}
		return numOfWins;
	}
}

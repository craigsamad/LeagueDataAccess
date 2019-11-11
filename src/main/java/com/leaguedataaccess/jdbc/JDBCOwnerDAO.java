package com.leaguedataaccess.jdbc;

import java.util.LinkedList;
import java.util.List;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.leaguedataaccess.Owner;
import com.leaguedataaccess.OwnerDAO;

public class JDBCOwnerDAO implements OwnerDAO {

	private JdbcTemplate jdbcTemplate;
	
	public JDBCOwnerDAO(BasicDataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public List<Owner> getAllOwners() {
		List<Owner> listOfAllOwners = new LinkedList<Owner>();
		String sql = "select owner_id, first_name, last_name "
				+ "from owner "
				+ "ORDER BY owner_id";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql); 
		
		while(results.next()) {
			Owner selectedOwner = mapRowsToOwner(results);
			listOfAllOwners.add(selectedOwner);
		}
		
		return listOfAllOwners;
	}
	
	public List<Owner> getOwnersBySeason(int season) {
		List<Owner> ownerList = new LinkedList<Owner>();
		String sql = "SELECT o.owner_id, o.first_name, o.last_name FROM owner o "
				   + "WHERE o.owner_id in (SELECT DISTINCT os.owner_id FROM owner_score os "
				   + "JOIN game g ON os.game_id = g.game_id	WHERE SEASON = ?)";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, season); 
		
		while(results.next()) {
			Owner selectedOwner = mapRowsToOwner(results);
			ownerList.add(selectedOwner);
		}
		
		return ownerList;
	}
	
	//move to season DAO?
	public List<Integer> getAllSeasons() {
		List<Integer> seasonList = new LinkedList<Integer>();
		String sql = "SELECT DISTINCT season " 
					+ "FROM game "
					+ "ORDER BY season";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql); 
		
		while(results.next()) {
			seasonList.add(results.getInt("season"));
		}
		
		return seasonList;		
	}

	private Owner mapRowsToOwner(SqlRowSet results) {
		Owner selectedOwner = new Owner();
		selectedOwner.setOwnerId(results.getInt("owner_id"));
		selectedOwner.setFirstName(results.getString("first_name"));
		selectedOwner.setLastName(results.getString("last_name"));
		return selectedOwner;
	}
	
	
}

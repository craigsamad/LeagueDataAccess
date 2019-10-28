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

	private Owner mapRowsToOwner(SqlRowSet results) {
		Owner selectedOwner = new Owner();
		selectedOwner.setOwnerId(results.getInt("owner_id"));
		selectedOwner.setFirstName(results.getString("first_name"));
		selectedOwner.setLastName(results.getString("last_name"));
		return selectedOwner;
	}
	
	
}

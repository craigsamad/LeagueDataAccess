package com.leaguedataaccess.jdbc;

import java.util.LinkedList;
import java.util.List;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import com.leaguedataaccess.model.MessageBoardPost;
import com.leaguedataaccess.model.Owner;

@Component
public class JDBCMessageBoardDAO implements MessageBoardDAO {

	private JdbcTemplate jdbcTemplate;
	
	public JDBCMessageBoardDAO(BasicDataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public List<MessageBoardPost> getAllPosts() {
		List<MessageBoardPost> listOfPosts = new LinkedList<MessageBoardPost>();
		String sql = "select id, poster, post_text "
				+ "from board_posts";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql); 
		
		while(results.next()) {
			MessageBoardPost post = new MessageBoardPost();
			post.setPostId(results.getInt("id"));
			post.setPosterName(results.getString("poster"));
			post.setPostText(results.getString("post_text"));
			listOfPosts.add(post);
		}
		
		return listOfPosts;
	}
	
	public MessageBoardPost getPostById(int id) {
		MessageBoardPost post = new MessageBoardPost();
		String sql = "select id, poster, post_text "
				+ "from board_posts "
				+ "where id = ?";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id); 
		
		while(results.next()) {
			post.setPostId(results.getInt("id"));
			post.setPosterName(results.getString("poster"));
			post.setPostText(results.getString("post_text"));
		}
		
		return post;
	}
	
	public MessageBoardPost createNewPost(MessageBoardPost post) {
		String sql = "INSERT INTO board_posts (poster, post_text) VALUES (?, ?)";
		
		jdbcTemplate.update(sql, post.getPosterName(), post.getPostText());
		
		return post;
	}
	
	public void deletePost(int id) {
		String sql = "DELETE FROM board_posts WHERE id = ?";
		
		jdbcTemplate.update(sql, id);
	}

}

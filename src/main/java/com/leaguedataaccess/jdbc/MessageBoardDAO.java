package com.leaguedataaccess.jdbc;

import java.util.List;

import com.leaguedataaccess.model.MessageBoardPost;

public interface MessageBoardDAO {

	public List<MessageBoardPost> getAllPosts();
	public MessageBoardPost createNewPost(MessageBoardPost post);
	public MessageBoardPost getPostById(int id);
	public void deletePost(int id);
	public MessageBoardPost updatePost(MessageBoardPost post);
}

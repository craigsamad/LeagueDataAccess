package com.leaguedataaccess.model;

public class MessageBoardPost {
	
	private int postId;
	private String posterName;
	private String postText;
	
	public MessageBoardPost() {
		
	}

	public MessageBoardPost(int postId,String posterName, String postText) {
		this.setPostId(postId);
		this.posterName = posterName;
		this.postText = postText;
	}
	
	public String getPosterName() {
		return posterName;
	}

	public void setPosterName(String posterName) {
		this.posterName = posterName;
	}

	public String getPostText() {
		return postText;
	}

	public void setPostText(String postText) {
		this.postText = postText;
	}

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}
}

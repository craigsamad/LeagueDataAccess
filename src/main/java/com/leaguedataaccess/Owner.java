package com.leaguedataaccess;

public class Owner {
	
	private int ownerId;
	private String firstName;
	private String lastName;

	public Owner() {
		
	}
	
	public Owner(int ownerId, String firstName, String lastName) {
		this.setOwnerId(ownerId);
		this.setFirstName(firstName);
		this.setLastName(lastName);
	}

	public int getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getFullName() {
		return firstName + " " + lastName;
	}
}

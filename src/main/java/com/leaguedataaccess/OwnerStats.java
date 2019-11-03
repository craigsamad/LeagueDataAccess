package com.leaguedataaccess;

public class OwnerStats {

	private int regWins;
	private int regLosses;
	private int regTies;
	private double regScoreFor;
	private double regScoreAgainst;
	private int postWins;
	private int postLosses;
	private double postScoreFor;
	private double postScoreAgainst;
	
	public OwnerStats (int regWins, int regLosses, int regTies, double regScoreFor, double regScoreAgainst, int postWins, int postLosses, double postScoreFor, double postScoreAgainst) {
		this.setRegWins(regWins);
		this.setRegLosses(regLosses);
		this.setRegTies(regTies);
		this.setRegScoreFor(regScoreFor);
		this.setRegScoreAgainst(regScoreAgainst);
		this.setPostWins(postWins);
		this.setPostLosses(postLosses);
		this.setPostScoreFor(postScoreFor);
		this.setPostScoreAgainst(postScoreAgainst);
	}

	public OwnerStats() {
		regWins = 0;
		regLosses = 0;
		regTies = 0;
		regScoreFor = 0;
		regScoreAgainst = 0;
		postWins = 0;
		postLosses = 0;
		postScoreFor = 0;
		postScoreAgainst = 0;
	}

	public int getRegWins() {
		return regWins;
	}

	public void setRegWins(int regWins) {
		this.regWins = this.regWins + regWins;
	}

	public int getRegLosses() {
		return regLosses;
	}

	public void setRegLosses(int regLosses) {
		this.regLosses = this.regLosses + regLosses;
	}

	public int getRegTies() {
		return regTies;
	}

	public void setRegTies(int regTies) {
		this.regTies = this.regTies + regTies;
	}

	public double getRegScoreFor() {
		return regScoreFor;
	}

	public void setRegScoreFor(double regScoreFor) {
		this.regScoreFor = this.regScoreFor + regScoreFor;
	}

	public double getRegScoreAgainst() {
		return regScoreAgainst;
	}

	public void setRegScoreAgainst(double regScoreAgainst) {
		this.regScoreAgainst = this.regScoreAgainst + regScoreAgainst;
	}

	public int getPostWins() {
		return postWins;
	}

	public void setPostWins(int postWins) {
		this.postWins = this.postWins + postWins;
	}

	public int getPostLosses() {
		return postLosses;
	}

	public void setPostLosses(int postLosses) {
		this.postLosses = this.postLosses + postLosses;
	}

	public double getPostScoreFor() {
		return postScoreFor;
	}

	public void setPostScoreFor(double postScoreFor) {
		this.postScoreFor = this.postScoreFor + postScoreFor;
	}

	public double getPostScoreAgainst() {
		return postScoreAgainst;
	}

	public void setPostScoreAgainst(double postScoreAgainst) {
		this.postScoreAgainst = this.postScoreAgainst + postScoreAgainst;
	}
}

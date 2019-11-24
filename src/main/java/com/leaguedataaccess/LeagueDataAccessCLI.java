package com.leaguedataaccess;

import java.util.List;

import org.apache.commons.dbcp2.BasicDataSource;

import com.leaguedataaccess.jdbc.JDBCStatsDAO;
import com.leaguedataaccess.jdbc.OwnerDAO;
import com.leaguedataaccess.jdbc.StatsDAO;
import com.leaguedataaccess.model.Owner;
import com.leaguedataaccess.model.OwnerStats;
import com.leaguedataaccess.jdbc.JDBCOwnerDAO;
import com.leaguedataaccess.view.Menu;

public class LeagueDataAccessCLI {
	
	private static final String MAIN_MENU_START_SEARCH_BY_OWNER = "Start a search based on an Owner";
	private static final String MAIN_MENU_START_SEARCH_BY_SEASON = "Start a search based on a Season";
	private static final String MAIN_MENU_OPTION_EXIT = "Quit";
	private static final String[] MAIN_MENU = {MAIN_MENU_START_SEARCH_BY_OWNER, MAIN_MENU_START_SEARCH_BY_SEASON, MAIN_MENU_OPTION_EXIT};

	@SuppressWarnings("unused")
	private static final String MENU_OPTION_RETURN_TO_PREVIOUS_SCREEN = "Return to previous screen";
	private static final String MENU_OPTION_RETURN_TO_MAIN = "Return to main menu";
	
	private static final String OWNER_MENU_SHOW_TOTAL_STATS = "Show owner's total stats";
	private static final String COMPARE_TO_ANOTHER_OWNER = "Compare to another owner";
	private static String[] OWNER_MENU = {OWNER_MENU_SHOW_TOTAL_STATS, COMPARE_TO_ANOTHER_OWNER,MENU_OPTION_RETURN_TO_MAIN};

	private Menu menu;
	private OwnerDAO ownerDAO;
	private StatsDAO statsDAO;
	
	public LeagueDataAccessCLI() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/steelersrbad");
		dataSource.setUsername("postgres");
		dataSource.setPassword("postgres1");

		this.menu = new Menu(System.in, System.out);
		ownerDAO = new JDBCOwnerDAO(dataSource);
		statsDAO = new JDBCStatsDAO(dataSource);
	}

	public static void main(String[] args) {
		LeagueDataAccessCLI application = new LeagueDataAccessCLI();
		application.run();
	}
	
	public void run() {
		loadMainMenu();
	}

	private void loadMainMenu() {
		boolean keepRunning = true;
		while (keepRunning) {
			printHeading("Main Menu");
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU);
			if (choice.equals(MAIN_MENU_START_SEARCH_BY_OWNER)) {
				displayOwnersAsMenu();
			} else if (choice.equals(MAIN_MENU_START_SEARCH_BY_SEASON)) {
				displaySeasonsAsMenu();				
			} else if (choice.equals(MAIN_MENU_OPTION_EXIT)) {
				System.out.println("Quitting...");
				keepRunning = false;
				System.exit(0);
			} 
		}
	}

	private void handleSeasonSelection(int selectedSeason) {
		List<Owner> allOwners = ownerDAO.getOwnersBySeason(selectedSeason);
		for (Owner owner : allOwners) {
			OwnerStats stats = statsDAO.getRegSeasonRecordForOneOwnerOneSeason(owner, selectedSeason);
			System.out.println(owner.getFullName() + ": " + stats.getRegWins() + "-" + stats.getRegLosses());
		}
	}

	private void displaySeasonsAsMenu() {
		printHeading("Season Menu");
		System.out.println("Please select a season:");
		List<Integer> allSeasons = ownerDAO.getAllSeasons();
		Object[] seasonList = allSeasons.toArray(new Object[allSeasons.size()]);
		
		Object choice = menu.getChoiceFromOptions(seasonList);
		
		handleSeasonSelection((Integer)choice);
	}
	
	private void displayOwnersAsMenu() {
		printHeading("Owners Menu");
		System.out.println("Please select an owner:");
		List<Owner> allOwners = ownerDAO.getAllOwners();
		Object[] ownerList = allOwners.toArray(new Object[allOwners.size()]);
		
		Object choice = menu.getChoiceFromOptions(ownerList);

		handleOwnerSelection((Owner)choice);
	
	}
	
	public void handleOwnerSelection(Owner selectedOwner) {
		boolean stayInOwnerMenu = true;
		while (stayInOwnerMenu) {
			System.out.println("You selected: " + selectedOwner.getFullName());
			System.out.println();
			System.out.println("Select a Command");
			Object choice = menu.getChoiceFromOptions(OWNER_MENU);
			if (choice.equals(OWNER_MENU_SHOW_TOTAL_STATS)) {
				
				OwnerStats totalOwnerStats = statsDAO.getTotalStatsForOneOwner(selectedOwner);
				
				System.out.println();
				System.out.println("Total Stats For " + selectedOwner.getFirstName() + ":");
				System.out.println();
				System.out.println("Regular Season Stats");
				double regScoreFor = totalOwnerStats.getRegScoreFor();
				int regWins = totalOwnerStats.getRegWins();
				int regLosses = totalOwnerStats.getRegLosses();
				double avgPointsPerGame = regScoreFor/(regWins+regLosses);
				double regScoreAgainst = totalOwnerStats.getRegScoreAgainst();
				double highestRegScore = totalOwnerStats.getHighestRegScore();
				double lowestRegScore = totalOwnerStats.getLowestRegScore();
				String record = Integer.toString(regWins) + "-" + Integer.toString(regLosses);
				System.out.printf("%-20s %-10s\n", "Record: ", record);
				System.out.printf("%-20s %-10.2f\n", "Points Scored: ", regScoreFor);
				System.out.printf("%-20s %-10.2f\n", "Points Against: ", regScoreAgainst);
				System.out.printf("%-20s %-10.2f\n", "Points Per Game: ", avgPointsPerGame);
				System.out.printf("%-20s %-10.2f\n", "Highest Score: ", highestRegScore);
				System.out.printf("%-20s %-10.2f\n", "Lowest Score: ", lowestRegScore);
				System.out.println();
				double postScoreFor = totalOwnerStats.getPostScoreFor();
				int postWins = totalOwnerStats.getPostWins();
				int postLosses = totalOwnerStats.getPostLosses();
				avgPointsPerGame = postScoreFor/(postWins+postLosses);
				double postScoreAgainst = totalOwnerStats.getPostScoreAgainst();
				System.out.println("Post Season Stats");
				record = Integer.toString(postWins) + "-" + Integer.toString(postLosses);
				System.out.printf("%-20s %-10s\n", "Record: ", record);
				System.out.printf("%-20s %-10.2f\n", "Points Scored: ", postScoreFor);
				System.out.printf("%-20s %-10.2f\n", "Points Against: ", postScoreAgainst);
				System.out.printf("%-20s %-10.2f\n", "Points Per Game: ", avgPointsPerGame);
				System.out.println();
				avgPointsPerGame = (regScoreFor+postScoreFor)/(regWins+regLosses+postWins+postLosses);
				System.out.println("Total Stats");
				record = Integer.toString((regWins + postWins)) + "-" + Integer.toString((regLosses + postLosses));
				System.out.printf("%-20s %-10s\n", "Record: ", record);
				System.out.printf("%-20s %-10.2f\n", "Points Scored: ", (regScoreFor + postScoreFor));
				System.out.printf("%-20s %-10.2f\n", "Points Against: ", (regScoreAgainst + postScoreAgainst));
				System.out.printf("%-20s %-10.2f\n", "Points Per Game: ", avgPointsPerGame);
				
				stayInOwnerMenu = false;

			} else if (choice.equals(COMPARE_TO_ANOTHER_OWNER)) {
				System.out.println("Select an owner to compare " + selectedOwner.getFirstName() + " to.");
				System.out.println();
				List<Owner> listOfAllOwnersWithoutOwnerOne = ownerDAO.getAllOwners();
				listOfAllOwnersWithoutOwnerOne.remove(selectedOwner.getOwnerId() - 1);
				Object[] ownerListTwo = listOfAllOwnersWithoutOwnerOne.toArray(new Object[listOfAllOwnersWithoutOwnerOne.size()]);

				choice = menu.getChoiceFromOptions(ownerListTwo);
				
				OwnerStats headToHeadResults = statsDAO.getHeadToHeadStats(selectedOwner, (Owner) choice);
				
				System.out.printf("%-20s %-10s %s\n", "", selectedOwner.getFirstName(), ((Owner) choice).getFirstName());
				System.out.println("Regular Season Stats");
				int regWins = headToHeadResults.getRegWins();
				int regLosses = headToHeadResults.getRegLosses();
				System.out.println("Games Played: " + (regWins + regLosses));
				System.out.printf("%-20s %-10s %s\n", "Wins: ", regWins, regLosses);
				double regScoreFor = headToHeadResults.getRegScoreFor();
				double regScoreAgainst = headToHeadResults.getRegScoreAgainst();
				System.out.printf("%-20s %-10.2f %.2f\n", "Total Score: ", regScoreFor, regScoreAgainst);
				System.out.println();
				System.out.println("Post Season Stats");
				int postWins = headToHeadResults.getPostWins();
				int postLosses = headToHeadResults.getPostLosses();
				System.out.println("Games Played: " + (postWins + postLosses));
				System.out.printf("%-20s %-10s %s\n", "Wins: ", postWins, postLosses);
				double postScoreFor = headToHeadResults.getPostScoreFor();
				double postScoreAgainst = headToHeadResults.getPostScoreAgainst();
				System.out.printf("%-20s %-10.2f %.2f\n", "Total Score: ", postScoreFor, postScoreAgainst);
				System.out.println();
				System.out.println("Total Stats");
				System.out.println("Games Played: " + ((regWins + postWins) + (regLosses + postLosses)));
				System.out.printf("%-20s %-10s %s\n", "Wins: ", regWins + postWins, regLosses + postLosses);
				System.out.printf("%-20s %-10.2f %.2f\n", "Total Score: ", regScoreFor + postScoreFor, regScoreAgainst + postScoreAgainst);
				
				stayInOwnerMenu = false; 

			} else if (choice.equals(MENU_OPTION_RETURN_TO_MAIN)) {
				stayInOwnerMenu = false;
			}
		}
	}
	
	private void printHeading(String headingText) {
		System.out.println("\n" + headingText);
		for (int i = 0; i < headingText.length(); i++) {
			System.out.print("-");
		}
		System.out.println();
	}

}

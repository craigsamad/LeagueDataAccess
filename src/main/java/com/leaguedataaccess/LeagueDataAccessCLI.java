package com.leaguedataaccess;

import java.util.List;

import org.apache.commons.dbcp2.BasicDataSource;

import com.leaguedataaccess.jdbc.JDBCGameDAO;
import com.leaguedataaccess.jdbc.JDBCOwnerDAO;
import com.leaguedataaccess.view.Menu;

public class LeagueDataAccessCLI {
	
	private static final String MAIN_MENU_START_SEARCH_BY_OWNER = "Start a search based on an Owner";
	private static final String MAIN_MENU_START_SEARCH_BY_SEASON = "Start a search based on a Season";
	private static final String MAIN_MENU_OPTION_EXIT = "Quit";
	private static final String[] MAIN_MENU = {MAIN_MENU_START_SEARCH_BY_OWNER, MAIN_MENU_START_SEARCH_BY_SEASON, MAIN_MENU_OPTION_EXIT};

	private static final String MENU_OPTION_RETURN_TO_PREVIOUS_SCREEN = "Return to previous screen";
	private static final String MENU_OPTION_RETURN_TO_MAIN = "Return to main menu";
	
	private static final String OWNER_MENU_SHOW_TOTAL_STATS = "Show owner's total stats";
	private static final String COMPARE_TO_ANOTHER_OWNER = "Compare to another owner";
	private static String[] OWNER_MENU = {OWNER_MENU_SHOW_TOTAL_STATS, COMPARE_TO_ANOTHER_OWNER,MENU_OPTION_RETURN_TO_MAIN};

	private Menu menu;
	private OwnerDAO ownerDAO;
	private GameDAO gameDAO;
	
	public LeagueDataAccessCLI() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/steelersrbad");
		dataSource.setUsername("postgres");
		dataSource.setPassword("postgres1");

		this.menu = new Menu(System.in, System.out);
		ownerDAO = new JDBCOwnerDAO(dataSource);
		gameDAO = new JDBCGameDAO(dataSource);
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

			} else if (choice.equals(MAIN_MENU_OPTION_EXIT)) {
				System.out.println("Quitting...");
				keepRunning = false;
				System.exit(0);
			} 
		}
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

			} else if (choice.equals(COMPARE_TO_ANOTHER_OWNER)) {
				System.out.println("Select an owner to compare " + selectedOwner.getFirstName() + " to.");
				System.out.println();
				List<Owner> listOfAllOwnersWithoutOwnerOne = ownerDAO.getAllOwners();
				listOfAllOwnersWithoutOwnerOne.remove(selectedOwner.getOwnerId() - 1);
				Object[] ownerListTwo = listOfAllOwnersWithoutOwnerOne.toArray(new Object[listOfAllOwnersWithoutOwnerOne.size()]);

				choice = menu.getChoiceFromOptions(ownerListTwo);

				System.out.printf("%-20s %-10s %s\n", "", selectedOwner.getFirstName(), ((Owner) choice).getFirstName());
				System.out.printf("%-20s %-10s %s\n", "Wins: ", gameDAO.getNumberOfWinsVsSelectedOwner(selectedOwner, (Owner) choice), 
															    gameDAO.getNumberOfWinsVsSelectedOwner((Owner) choice, selectedOwner));
				System.out.printf("%-20s %-10s %s\n", "Score: ", gameDAO.getTotalScoreVsSelectedOwner(selectedOwner, (Owner) choice), 
						 										 gameDAO.getTotalScoreVsSelectedOwner((Owner) choice, selectedOwner));
				
				stayInOwnerMenu = false; //remove later

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

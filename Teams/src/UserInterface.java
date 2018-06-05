import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import ecs100.UI;

public class UserInterface {

	/** array lists used in methods */
	private ArrayList<Team> teamlist = new ArrayList<Team>();// stores team
	// names as
	// objects
	private ArrayList<String> teamstring = new ArrayList<String>();// stores
	// team
	// names as
	// strings
	private ArrayList<People> peoplelist = new ArrayList<People>();// stores
	// coaches
	// and
	// players
	// as
	// objects
	// of type
	// people

	public UserInterface() {

		/** user interface */
		UI.initialise();
		UI.addButton("List teams", this::listTeams);
		UI.addButton("List coaches", this::listTeamsWithCoaches);
		UI.addButton("List team players", this::listTeamPlayers);
		UI.addButton("List players by position", this::listPositionPlayersOnTeam);
		UI.addButton("Search by height", this::listHeights);
		UI.addButton("Check team lineup", this::checkSelection);
		UI.addButton("Graph player heights", this::graphHeights);

		/** Reads files and collects data */
		try {
			Scanner scanner = new Scanner(new File("teams.txt")); // Sets
			// scanner
			// to read
			// teams.txt
			while (scanner.hasNext()) { // will scan everything in document
				ArrayList<Player> playerlist = new ArrayList<Player>();
				String team = scanner.nextLine(); // Collects line with team name
				String coach = scanner.nextLine(); // Collects line with coach name
				int teamSize = scanner.nextInt(); // Collects team size

				for (int i = 0; i < teamSize; i++) { // loop runs for length of team size
					String tempPos = scanner.next(); // Collects positions for player
					String[] p = tempPos.split(","); // Splits string positions into multiple strings stored in array
					ArrayList<String> positions = new ArrayList<String>();
					for (int j = 0; j < p.length; j++) { // loop runs for length of array size
						positions.add(p[j]); // adds each string in array to array list
					}

					String playerName = scanner.nextLine(); // Collects line
					// with player name
					String actualPlayerName = playerName.substring(1); // creates a string for the player name WITHOUT the first space
					int height = scanner.nextInt(); // Collects line with height
					scanner.nextLine(); // Goes to next line
					String homeTown = scanner.nextLine(); // Collects line detailing birthplace
					Player newPlayer = new Player(actualPlayerName, positions, height, homeTown, team); // Creates new player object with appropriate parameters
					peoplelist.add(newPlayer); // Adds new player to people list
					playerlist.add(newPlayer); // Adds new player to player list
				}

				teamstring.add(team); // Adds team to list of teams
				Coaches newcoach = new Coaches(coach, team); // Creates new coach object with variables collected from file
				peoplelist.add(newcoach); // Adds new coach to people list
				Team newteam = new Team(team, newcoach, teamSize, playerlist);// Creates new team object with variable collected from file
				teamlist.add(newteam); // Adds new team to team list
			} // loop will continue until file has been exhausted.
			scanner.close();
		} catch (FileNotFoundException e) {
			UI.printf("Error loading file: %s%n", e);
		}
	}

	public void listTeams() {
		UI.clearText();
		for (int i = 0; i < teamstring.size(); i++) { // loop runs for length of
													// the amount of teams
			UI.println(teamstring.get(i)); // prints to text pane each team
		}
	}

	public void listTeamsWithCoaches() {
		UI.clearText();
		for (int i = 0; i < teamlist.size(); i++) { // loop runs for length of the amount of teams
			UI.println(teamlist.get(i).getTeamName()); // gets team name from team list identification and prints
			UI.println(teamlist.get(i).getCoach().getName()); // gets coach name from team list and prints
			UI.println(); // provides space between each team & captain
		}
	}

	public void listTeamPlayers() {
		UI.clearText();
		String team = UI.askString("Which team?");
		UI.println();
		if (teamstring.contains(team)) { // if user input equals a team that exists, then:
			for (int i = 0; i < teamlist.size(); i++) { // loop through length of teams list
				if (team.equals((teamlist.get(i).getTeamName()))) { // and find the team with a name string that matches the input 
					ArrayList<Player> playerlist = new ArrayList<Player>(teamlist.get(i).getListOfPlayers()); //and assign the playerlist to the player list of that team
					for (int j = 0; j < playerlist.size(); j++) {
						UI.println(playerlist.get(j).getName());
						UI.println(playerlist.get(j).getBirth());
						UI.println();
					}
				}
			}

		} else {
			UI.println("This is an invalid team");
		}
	}

	public void listPositionPlayersOnTeam() {
		UI.clearText();
		String team = UI.askString("Which team?");
		if (teamstring.contains(team)) {
			for (int i = 0; i < teamlist.size(); i++) {
				if (team.equals((teamlist.get(i).getTeamName()))) {
					String position = UI.askString("Which position?");		//this code is similar to the code before it, it runs through the position list of each player
					ArrayList<Player> playerlist = new ArrayList<Player>(teamlist.get(i).getListOfPlayers()); //and only prints a player if it finds a match for the input
					for (int j = 0; j < playerlist.size(); j++) {
						if (playerlist.get(j).getPositions().contains(position)) {
							UI.println(playerlist.get(j).getName());
						}
					}
				}

			}
		}
	}

	public void listHeights() {
		ArrayList<Player> playerlist = new ArrayList<Player>();
		UI.clearText();
		int min = UI.askInt("Taller than?");
		int max = UI.askInt("Shorter than?");
		for (int i = 0; i < peoplelist.size(); i++) { // going through everyone
			if (peoplelist.get(i) instanceof Player) { // only taking those who are players
				playerlist.add((Player) peoplelist.get(i)); // adding them to a list
			}
		}

		for (int j = 0; j < playerlist.size(); j++) {
			if (playerlist.get(j).getHeight() < max && playerlist.get(j).getHeight() > min) { // excluding people outside the range
				UI.println(playerlist.get(j).getName() + " (" + playerlist.get(j).getTeam() + ")"); // printing the remaining players
			}
		}
	}

	public void checkSelection() {
		UI.clearText();

		ArrayList<String> possiblepositions = new ArrayList<String>(); // this should almost be its own private field
		String[] a = { "GK", "WA", "C", "GD", "GS", "GA", "WD" };
		for (int u = 0; u < a.length; u++) {
			possiblepositions.add(a[u]);
		}

		ArrayList<Player> lineUp = new ArrayList<Player>(); // list to store our line-up
		ArrayList<Player> teamplayers = new ArrayList<Player>(); // all the possible players on a team
		ArrayList<String> tempPos = new ArrayList<String>(possiblepositions); // didn't want to disrupt the original position list 
		ArrayList<String> playerstring = new ArrayList<String>(); // toString array, basically

		String team = UI.askString("Which team?");
		if (teamstring.contains(team)) {
			for (int i = 0; i < teamlist.size(); i++) { // making sure the input
														// team exists, and then
														// setting our possible
														// list of players
				if (team.equals((teamlist.get(i).getTeamName()))) {
					teamplayers = (teamlist.get(i).getListOfPlayers());
				}
			}
		}

		for (int j = 0; j < teamplayers.size(); j++) {
			for (int p = 0; p < tempPos.size(); p++) {
				if ((teamplayers.get(j).getPositions()).size() == 1) { 	//want to go through the members who can only fill one role first
					if (teamplayers.get(j).getPositions().contains(tempPos.get(p))) { 	// check if player positions match any available roles																				
						if (!lineUp.contains(teamplayers.get(j)) && lineUp.size() < 8) { 	// if that player is not already on the list, and the line-up isn't full, then
							String pos = tempPos.get(p); 		// add that player to the list, and remove the role from the search
							lineUp.add(teamplayers.get(j));
							playerstring.add(teamplayers.get(j).getName() + " " + pos); // originally I tried doing this with one arraylist, but that resulted in duplicate player additions
							tempPos.remove(pos);
						}
					}
				}
			}
		}
		for (int j = 0; j < teamplayers.size(); j++) {
			for (int n = 0; n < tempPos.size(); n++) {
				if (teamplayers.get(j).getPositions().size() == 2) { // same again, but only for players with 2 possible positions
					if (teamplayers.get(j).getPositions().contains(tempPos.get(n))) {
						if (!lineUp.contains(teamplayers.get(j)) && lineUp.size() < 8) {
							String pos = tempPos.get(n);
							lineUp.add(teamplayers.get(j));
							playerstring.add(teamplayers.get(j).getName() + " " + pos);
							tempPos.remove(pos);
						}
					}
				}
			}
		}
		for (int j = 0; j < teamplayers.size(); j++) {
			for (int q = 0; q < tempPos.size(); q++) {
				if (teamplayers.get(j).getPositions().size() > 2) { // same again, but for anyone with more than 2 roles (this was originally set to 3,	turns out someone had 4)
					if (teamplayers.get(j).getPositions().contains(tempPos.get(q))) {
						if (!lineUp.contains(teamplayers.get(j)) && lineUp.size() < 8) {
							String pos = tempPos.get(q);
							lineUp.add(teamplayers.get(j));
							playerstring.add(teamplayers.get(j).getName() + " " + pos);
							tempPos.remove(pos);
						}

					}
				}
			}
		}
		if (tempPos.isEmpty()) { // then, if after going through all the players
									// the list of role to fill is empty, we
									// print the line up with their positions.
			UI.println("The team is ready to play");
			for (int b = 0; b < playerstring.size(); b++) {
				UI.println(playerstring.get(b));
			}
		} else { // if not (which shouldn't happen, I think all the teams are
					// viable) we print which positions are missing.
			UI.println("The team does not fill all the positions");
			UI.print("There are still these positions to fill: ");
			for (int w = 0; w < tempPos.size(); w++) {
				UI.println(tempPos.get(w));
			}
		}
	}

	public void graphHeights() {
		UI.clearPanes();

		ArrayList<Player> teamplayers = new ArrayList<Player>();
		String team = UI.askString("Which team?");
		if (teamstring.contains(team)) {
			for (int i = 0; i < teamlist.size(); i++) { // making sure the input
														// team exists, and then
														// setting our possible
														// list of players
				if (team.equals((teamlist.get(i).getTeamName()))) {
					teamplayers = (teamlist.get(i).getListOfPlayers());
				}
			}
		}
		int base = 350;
		int top = 100;
		int startx = 140;

		for (int j = 0; j < teamplayers.size(); j++) {
			UI.println(j + 1 + " " + teamplayers.get(j).getName() + " " + teamplayers.get(j).getHeight() + "cm");
			int height = teamplayers.get(j).getHeight();
			UI.fillRect(startx + 10 + (20 * j), base - (height), 10, height); // draws a bar for height
			UI.drawString("" + (j + 1), startx + 10 + (20 * j), base - (height + 30)); // draws the player number above their bar
			UI.drawString("Height in centimeters", 0, (base + top) / 2); // draws y axis label
			UI.drawString("Player number", startx + 20 * ((teamplayers.size() / 2) - 1), base + 20); // draws x axis label
			UI.drawLine(startx, top, startx, base); // draws y axis
			UI.drawLine(startx, base, startx + 20 * (teamplayers.size()), base); // draws x axis
		}
		for (int p = 0; p < 23; p++) {
			UI.drawString("" + p * 10, 118, 353 - p * 10);
		}

	}

	public static void main(String[] args) {
		new UserInterface();
	}
}



package buspk;

import java.util.ArrayList;

import ecs100.UI;

public class Test {

	public static void main(String[] args) {
		// Bus b = new Bus();
		// b.getOnBus("Driver");
		// b.getOnBus("Billy");
		// if(b.move()){
		// System.out.println("Now we're moving!");
		// }
		// else System.out.println("Theres no Driver! Ahh!");
		// System.out.println(b.toString());

		//create a coach
		Coach c = new Coach();
		
		//create another coach
		Coach n = new Coach();
		
		//create a passenger called Bob
		Passenger bob = new Passenger("Bob");
		
		//create a passenger called jane
		Passenger jane = new Passenger("Jane");
		
		//create a driver
		Driver Andy = new Driver();
		
		//add driver to bus
		c.getOnBus(Andy);
		
		//add bob to bus
		c.getOnBus(bob);
		c.getOnBus(bob);
		c.getOnBus(bob);
		c.getOnBus(jane);
		n.getOnBus(bob);
		
		if (c.move()) {
			System.out.println("the driver is on board");
		} else {
			System.out.println("there is no driver :(");
		}
	}

}


public void checkSelection() {
	UI.clearText();

	ArrayList<String> possiblepositions = new ArrayList<String>();
	String[] a = { "GK", "WA", "C", "GD", "GS", "GA", "WD" };
	for (int u = 0; u < a.length; u++) {
		possiblepositions.add(a[u]);
	}
	ArrayList<Player> myplayerlist = new ArrayList<Player>();

	ArrayList<Player> playerlist = new ArrayList<Player>();
	ArrayList<String> tempPos = new ArrayList<String>(possiblepositions);

	String team = UI.askString("Which team?");
	if (teamstring.contains(team)) {
		for (int i = 0; i < teamlist.size(); i++) {
			if (team.equals((teamlist.get(i).getTeamName()))) {
				playerlist = (teamlist.get(i).getListOfPlayers());
			}
		}
	}

	for (int j = 0; j < playerlist.size(); j++) {
		for (int p = 0; p < tempPos.size(); p++) {
			if ((playerlist.get(j).getPositions()).size() == 1) {
				if (playerlist.get(j).getPositions().contains(tempPos.get(p))) {
					
					if (!myplayerlist.contains(playerlist.get(j)) && myplayerlist.size() < 8) {
						myplayerlist.add(playerlist.get(j));
						String pos = tempPos.get(p);
						tempPos.remove(pos);
					}
					
				}
			}
		}
	}
	for (int j = 0; j < playerlist.size(); j++) {
		for (int n = 0; n < tempPos.size(); n++) {
			if (playerlist.get(j).getPositions().size() == 2) {
				if (playerlist.get(j).getPositions().contains(tempPos.get(n))) {
					
					if (!myplayerlist.contains(playerlist.get(j)) && myplayerlist.size() < 8) {
						myplayerlist.add(playerlist.get(j));
						String pos = tempPos.get(n);
						tempPos.remove(pos);
					}
					
				}

			}
		}
	}
	for (int j = 0; j < playerlist.size(); j++) {
		for (int q = 0; q < tempPos.size(); q++) {
			if (playerlist.get(j).getPositions().size() >2) {
				if (playerlist.get(j).getPositions().contains(tempPos.get(q))) {
					if (!myplayerlist.contains(playerlist.get(j)) && myplayerlist.size() < 8) {
						myplayerlist.add(playerlist.get(j));
						String pos = tempPos.get(q);
						tempPos.remove(pos);
					}
					
				}
			}
		}
	}
	if (tempPos.isEmpty()) {
		UI.println("The team is ready to play");
		for(int b=0;b<myplayerlist.size();b++){
			UI.println(myplayerlist.get(b).getName());
		}
	} else {
		UI.println("The team does not fill all the positions");
		UI.print("There are still these positions to fill: ");
		for (int w = 0; w < tempPos.size(); w++) {
			UI.println(tempPos.get(w));
		}
	}
}



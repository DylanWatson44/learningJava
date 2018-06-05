import java.util.ArrayList;

public class Team {
	// fields
	private String teamName;
	private int numberOfTeamMembers;
	private Coaches coach;
	private ArrayList<Player> playerlist = new ArrayList<Player>();

	 public Team(String teamNamePar, Coaches c, int number, ArrayList<Player> playerarray){
	 teamName = teamNamePar;
	 coach = c;
	 numberOfTeamMembers = number;
	 playerlist.addAll(playerarray);
	 }
	public String getTeamName() {
		return teamName;
	}

	public Coaches getCoach() {
		return coach;
	}

	public ArrayList<Player> getListOfPlayers() {
		return playerlist;
	}

	public void setNumberOfPlayers(int x) {
		numberOfTeamMembers = x;
	}

	public int getPlayerNumber() {
		return numberOfTeamMembers;
	}

	public void setTeamName(String a) {
		teamName = a;
	}
}

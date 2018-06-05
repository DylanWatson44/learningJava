
public class Coaches implements People {

	private String name;
	private String teamName;

	public Coaches(String CName, String team){
		name = CName;
		teamName = team;
	}
	
	public String getName() {
		return name;
	}

	public void setCoachName(String s) {
		name = s;
	}

	public String getTeam() {

		return teamName;
	}

}

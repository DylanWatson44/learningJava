import java.util.ArrayList;

public class Player implements People{

	private String name;
	private String teamName;
	private ArrayList<String> positions = new ArrayList<String>();
	private int height;
	private String placeOfBirth;
	
	public Player(String Pname,ArrayList<String> p, int h, String birth, String team){
		name = Pname;
		positions.addAll(p);
		height = h;
		placeOfBirth = birth;
		teamName = team;
	}
	
	public String getName() {
		
		return name;
	}

	public String getBirth(){
		return placeOfBirth;
	}
	public String getTeam() {
	
		return teamName;
	}
	public ArrayList<String> getPositions(){
		return positions;
	}
	public int getHeight(){
		return height;
	}
}

package buspk;

public class Passenger implements Person {
//	private Double ticket;
	private String name;
	private Snapper snapper;
	private double snapAmt = 5;
	
	//Constructor - new passenger with snapper card
	public Passenger(String n){
		Snapper snap = new Snapper((int) (Math.random() * 203220), snapAmt);
		snapper = snap;
		name = n;
	}

	public String getName() {
		return name;
	}
	
	public Snapper getSnapper(){
		return snapper;
	}
	
	public double getSnapAmt(){
		return snapAmt;
	}
	
	public void setSnapAmt(double d){
		snapAmt = d;
	}
}

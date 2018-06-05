package buspk;

public class Snapper {
	//fields
	private int snapperId;
	private double snapperBalance = 5;
	
	//constructor
	//snapper object needs an id and a balance passed to it
	public Snapper(int id, double moneyOnSnapper){
		//set the fields here to be the same as those values passed through
		this.snapperId = id;
		this.snapperBalance = moneyOnSnapper;
		
	}
	
	//test whether a passenger has enough money on their snapper card by
	//receiving the money amount when the method is called
	public boolean spendMoney(double m) {
		if (m >= 2) {
			return true;
		}
		return false;
	}
	//return ID so other classes can use it
	public int getID(){
		return snapperId;
	}

}

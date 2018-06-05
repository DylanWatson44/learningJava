package buspk;

import java.util.ArrayList;

public class Coach {
	// create a list of people
	private ArrayList<Person> peopleList = new ArrayList<Person>();
	private double money;

	// method to put people on the coach (add to peopleList)
	public void getOnBus(Person Patron) {
		// test if driver
		if (Patron instanceof Driver) {
			// if yes, add to list
			peopleList.add(Patron);
			// if not a driver, must be a passenger
		} else {
			// cast the "person" to "passenger"
			Passenger p = (Passenger) Patron;
			// get the money from the passenger class by calling the method
			money = p.getSnapAmt();
			// call getSnapper (returns snapper object to manipulate)
			// then call spendMoney on that object using the variable we just
			// received
			if (p.getSnapper().spendMoney(money)) {
				// if returned true, add to list
				peopleList.add(p);
				// remove the fare from their balance
				money = money - 2;
				// set passenger's "snapAmt" to "money"
				p.setSnapAmt(money);
				// and print their name and balance
				System.out.println(p.getName() + " (ID#" + p.getSnapper().getID() + ")" + " has " + money);
			} else {
				// if they didn't have enough money, don't add
				System.out.println("Not enough money = " + money);
			}
		}
	}

	// test if the driver is on board before moving
	public boolean move() {
		// iterate through the list and check if they're a driver
		// for (int i = 0; i < peopleList.size(); i++) {
		for (Person pp : peopleList) {
			if (pp instanceof Driver) {
				// if (peopleList.get(i) instanceof Driver) {
				return true;
			}
		}
		return false;
	}
	
}

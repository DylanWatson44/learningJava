package buspk;

import java.util.ArrayList;

public class Bus {
	private String serialNumber;
	private ArrayList<String> people = new ArrayList<String>();

	public Bus() {
		String serialNumber;
	}

	public String toString() {
		String name = "";
		for (int i = 0; i < people.size(); i++) {
			if(people.size()==0){
				name= people.get(i);
			}
			else name = name + people.get(i) + " ";
		}
		return name;
	}

	public void getOnBus(String person) {
		people.add(person);
	}

	public boolean move() {
		if (people.contains("Driver")) {
			return true;
		}
		return false;
	}
}

package traversal;

import java.util.ArrayList;

/** Just a class that stores and sets an array of integers and the number of steps between them*/
public class TravelPath {
private int travelSteps;
private ArrayList<Integer> citiesVisited;

public String toString(){
	return ("Travel steps: "+ travelSteps + ", Travel path:" + citiesVisited);
}
public int getTravelsteps() {
	return travelSteps;
}

public void setTravelsteps(int travelsteps) {
	this.travelSteps = travelsteps;
}

public ArrayList<Integer> getCitiesVisited() {
	return citiesVisited;
}

public void setCitiesVisited(ArrayList<Integer> citiesVisited) {
	this.citiesVisited = citiesVisited;
	travelSteps = citiesVisited.size() -1;
}
}

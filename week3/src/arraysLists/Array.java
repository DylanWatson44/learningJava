package arraysLists;

import java.util.ArrayList;

public class Array {

	public static void main(String[] args) {
		ArrayList <String> names = new ArrayList<String>();
		names.add("Jim");
		names.add("Jan");
		System.out.print(names.get(0));
		names.set(0, "bob");
		System.out.print(names.get(0));
		names.add(0, "Gurdy");
		names.remove("bob");
		System.out.print(names.get(1));

	}//void main

}//class

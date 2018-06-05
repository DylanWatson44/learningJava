package client;

import method.Merging;
import java.util.ArrayList;

public class Test {

	public static void main(String[] args) {
		int oddsArraySize = 5;
		int evensArraySize = 5;
		int[] odds = new int[oddsArraySize];
		int[] evens = new int[evensArraySize];

		int thing = 1;
		int thing2 = 2;

		for (int i = 0; i < oddsArraySize; i++) {
			odds[i] = thing;
			thing += 2;
		}
		for (int i = 0; i < evensArraySize; i++) {
			evens[i] = thing2;
			thing2 += 2;
		}
		int[] m = Merging.sortTheArrays(odds, evens);
		
		System.out.println(m);
	}

}

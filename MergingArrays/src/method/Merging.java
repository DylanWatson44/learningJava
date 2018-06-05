package method;

import java.util.ArrayList;

public class Merging {

	public static int[] sortTheArrays(int[] a, int[] b) {
		int sortedListLength = a.length + b.length;
		int[] sortedList = new int[sortedListLength];
		int[] odds = new int[a.length];
		int[] evens = new int[b.length];

		for (int i = 0; i < a.length; i++)
			odds[i] = a[i];

		for (int i = 0; i < b.length; i++)
			evens[i] = b[i];

		int counter = 0;
		int oddsIndex = 0;
		int evensIndex = 0;
		while (oddsIndex < odds.length) {
			if (evensIndex == b.length) {  //if we've exhausted items from b, add all of a, then stop
				for (int q =oddsIndex; q < odds.length;q++) {
					sortedList[counter] = odds[q];
					counter++;
				}
				break;
			}
			if (odds[oddsIndex] < evens[evensIndex]) {
				sortedList[counter] = odds[oddsIndex];
				counter++;
				oddsIndex++;
			} else {
				sortedList[counter] = evens[evensIndex];
				counter++;
				evensIndex++;
			}
			if (oddsIndex == a.length) {
				for (int q = evensIndex; evensIndex < evens.length; evensIndex++) {
					sortedList[counter] = evens[evensIndex];
					counter++;
				}
				break;
				}
			}


//		for (int i = 0; i < sortedList.length; i++)
//			System.out.println(sortedList[i]);
		return sortedList;
	}
}

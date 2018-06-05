package arraysLists;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import ecs100.UI;

public class analysenumbers {

	public static void main(String[] args) {
		ArrayList <Double> nums = new ArrayList<Double>();
		String filename = "heressomenums.txt";
		try{
			Scanner sc = new Scanner(new File(filename));
			while (sc.hasNextDouble()){
				nums.add(sc.nextDouble());
			}
			sc.close();
		} catch(IOException e){UI.println("Reading numbers failed: "+e);}
		double max =Double.NEGATIVE_INFINITY;
		for (int i =0; i <nums.size(); i++){
			double num = nums.get(i);
			if (num >max){
				max = num;}
		}
		UI.printf("%.3f is the largest of %d numbers%n", max, nums.size());
		}

	}



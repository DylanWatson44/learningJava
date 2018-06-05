package week3;

import ecs100.*; import java.io.File; import java.io.IOException; import java.util.Scanner;



public class oldestage {

	public static void main(String[] args){
		try {
			Scanner scan = new Scanner(new File("names.txt"));
			String oldest= "";
			int maxAge = 0;
			while (scan.hasNextInt()){
				int age = scan.nextInt();
				String name = scan.nextLine();
				if (age > maxAge){
					maxAge = age;
					oldest = name;
				}
			}
			UI.printf("Oldest is %s (%d)%n", oldest, maxAge);
		} catch (IOException e){UI.printf("file failure: %s %n", e);
		}
	}
}

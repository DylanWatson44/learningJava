package week3;

import ecs100.*; import java.io.File; import java.io.IOException; import java.util.Scanner;



public class oldest2{

	public static void main(String[] args){
		try {
			Scanner scan = new Scanner(new File("names2.txt"));
			String oldest= "";
			int maxAge = 0;
			while (scan.hasNext()){
				String name = scan.next();
				int age = scan.nextInt();
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

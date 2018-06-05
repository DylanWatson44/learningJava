package Guessinggame;

import java.util.Scanner;

public class extension {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Scanner scan=new Scanner(System.in);
int pick = (int)(Math.random()*100);
int guess = 0;
while(guess!=pick){
System.out.println("Pick a number!:");
guess=scan.nextInt();
		
	if (guess>pick)
		if(guess-pick>5)
				System.out.println("you guessed too high");
			else
					System.out.println("your guess of " + guess + " is a little too high");
		else
			if (guess<pick)
				if
						(pick-guess<5)
						System.out.println("your guess of " + guess + " is a little too low");
				else
					System.out.println("you guessed too low");
		else
					System.out.print("Thats the right answer!");
	
		}
		scan.close();
}
}

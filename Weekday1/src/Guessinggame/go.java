package Guessinggame;
import java.util.Scanner;
public class go {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		int pick = (int)(Math.random()*100);
		int guess = 0;
		while(guess!=pick){
		System.out.println("Pick a number!:");
		guess=scan.nextInt();
		
		if (guess>pick)
			System.out.println("you guessed too high");
			else
				if (guess<pick)
					System.out.println("you guessed too low");
				else
					System.out.print("Thats the right answer!");
	}
	}
}

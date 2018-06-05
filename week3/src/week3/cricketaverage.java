package week3;
import ecs100.*; import java.io.File; import java.io.IOException; import java.util.Scanner;
public class cricketaverage {

	public static void main(String[] args) {
		try{
			Scanner scan = new Scanner(new File("cricketscore.txt"));
			while (scan.hasNext()){
				String player = scan.next() + " " + scan.next();
				int playeraverage = 0;
				int n =0;
				while(scan.hasNextInt()){
					n ++;
					playeraverage = playeraverage + scan.nextInt();
				}playeraverage = playeraverage/n;
				UI.println(player +":" + playeraverage);
			}
			scan.close();
		}catch (IOException e) {UI.printf("File failure: %s\n", e);}

	}}



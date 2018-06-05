package week3;
import ecs100.*; import java.io.File; import java.io.IOException; import java.util.Scanner;
public class readinglines {
	public static void main(String[] args) {
		try{
			Scanner scan = new Scanner(new File("linesofnumbers.txt"));
			while (scan.hasNext()){
				String line = scan.nextLine();
				Scanner lineSc = new Scanner(line);
				int lineTotal = 0;
				while (lineSc.hasNextInt()){
					lineTotal = lineTotal + lineSc.nextInt();
				} 
				UI.println(lineTotal);
				lineSc.close();
			}
			scan.close();
		} catch (IOException e) {UI.printf("File failure: %s\n", e);}

}}

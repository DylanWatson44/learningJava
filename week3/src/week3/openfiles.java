package week3;
import ecs100.*; import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;
public class openfiles {

	public static void main(String[] args) {
		String heresafile = UIFileChooser.open();
		File myfile = new File(heresafile);
		try {
			Scanner scan = new Scanner(myfile);
			while(scan.hasNext()){
				UI.print(scan.next());}
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}

	}

}

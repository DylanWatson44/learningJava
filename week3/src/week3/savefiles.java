package week3;
import ecs100.*; import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class savefiles {

	public static void main(String[] args) {
		String filename = UIFileChooser.save();
		File myfile = new File(filename);
		try {
			PrintStream ps = new PrintStream(myfile);
			String g ="I saved stuff";
			ps.println(g);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		

	}

}

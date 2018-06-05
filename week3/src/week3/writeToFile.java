package week3;
import ecs100.*; import java.io.File; import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;
public class writeToFile {
	public static void main(String[] args){
		writeToFileNow("test");
	}
	public static void writeToFileNow(String fname){
		try {
			PrintStream out = new PrintStream(new File(fname));
			int n =1;
			out.println("Number\tSquare");
			while(n <= 1000){
				out.printf("%6d\t%8d\n", n, n*n);
				n++;
			}
			out.close();


		}catch (IOException e){UI.printf("File failure %s\n", e);}
	}}

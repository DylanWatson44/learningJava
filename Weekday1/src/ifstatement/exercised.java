package ifstatement;
import java.util.Scanner;
public class exercised {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Scanner scan=new Scanner(System.in);
System.out.println("Provide a number:");

int answer1=scan.nextInt();
System.out.println("Provide another:");
int answer2=scan.nextInt();
if(answer1>answer2)
	System.out.print(answer1 + " is larger");
	else
		if(answer2>answer1)
			System.out.print(answer2 + " is larger");
scan.close();
}
	}



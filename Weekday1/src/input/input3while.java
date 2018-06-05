package input;
import java.util.Scanner;
public class input3while {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
int answer=1;
Scanner scan=new Scanner(System.in);
while(answer!=3){
	
	System.out.println("Please enter an integer:");
	answer=scan.nextInt();
	
}
scan.close();
	}

}
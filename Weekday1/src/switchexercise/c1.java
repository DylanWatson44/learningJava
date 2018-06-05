package switchexercise;
import java.util.Scanner;
public class c1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		System.out.println("Please enter an month number:");
int a=scan.nextInt();
switch(a){
	case 1:{
		System.out.print("January");
	break;}
	case 2:{
		System.out.print("feb");
	break;}
	case 3:{
		System.out.print("mar");
	break;}
	case 4:{
		System.out.print("apr");
	break;}
	case 5:{
		System.out.print("may");
	break;}
	case 6:{
		System.out.print("Jun");
	break;}
	case 7:{
		System.out.print("July");
	break;}
	case 8:{
		System.out.print("aug");
	break;}
	case 9:{
		System.out.print("sep");
	break;}
	case 10:{
		System.out.print("oct");
	break;}
	case 11:{
		System.out.print("nov");
	break;}
	case 12:{
		System.out.print("dec");
	break;}
	default:{
		System.out.print("thats not a month number!");
	}
}
scan.close();
	}

}

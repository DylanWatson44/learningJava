package switchexercise;
import java.util.Scanner;
public class datevalidator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Scanner scan=new Scanner(System.in);
System.out.println("Provide day number:");
int day=scan.nextInt();
System.out.println("Provide month number:");
int month=scan.nextInt();
System.out.println("Provide year number:");
int year=scan.nextInt();
boolean specialcase=true;
switch(month){	
	case(1) :{
		if(day>31 || day <=0) 
		System.out.println("incorrect day specified");
		break;}
	case(2) :{
		if(day>28 || day <=0)
			if(day==29 && year%4==0)
				if(year%100==0 && year%400!=0)
					System.out.println("incorrect day specified, leap year skipped");
					specialcase=false;
				if(year%400==0)
				break;
				else
					while(specialcase==true)
		System.out.println("incorrect day specified");
		break;}
	case(3) :{
		if(day>31 || day <=0) 
		System.out.println("incorrect day specified");
		break;}
	case(4) :{
		if(day>30 || day <=0) 
		System.out.println("incorrect day specified");
		break;}
	case(5) :{
		if(day>31 || day <=0) 
		System.out.println("incorrect day specified");
		break;}
	case(6) :{
		if(day>30 || day <=0) 
		System.out.println("incorrect day specified");
		break;}
	case(7) :{
		if(day>31 || day <=0) 
		System.out.println("incorrect day specified");
		break;}
	case(8) :{
		if(day>31 || day <=0) 
		System.out.println("incorrect day specified");
		break;}
	case(9) :{
		if(day>30 || day <=0) 
		System.out.println("incorrect day specified");
		break;}
	case(10) :{
		if(day>31 || day <=0) 
		System.out.println("incorrect day specified");
		break;}
	case(11) :{
		if(day>30 || day <=0) 
		System.out.println("incorrect day specified");
		break;}
	case(12) :{
		if(day>31 || day <=0) 
		System.out.println("incorrect day specified");
		break;}
	default:{
		System.out.println("thats not a month number!");}}
if(year<=0)
	System.out.print("incorrect year");
	

	
while(specialcase==true)	
	if (day >0 && day <32 && year >0 && month >0 && month < 13)
	System.out.println("correct date entered, " + day + "/" + month + "/" + year);
	specialcase=false;
 System.out.println("Invalid date entered");
	
scan.close();
}
	}
	



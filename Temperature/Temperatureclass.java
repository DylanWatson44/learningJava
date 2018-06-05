import java.util.Scanner;
public class Temperatureclass {
	/** Converts F to C*/
	private String name;
	public Temperatureclass(String s){
		name = s;}
	
	public int fahrenheitToCelsius(int f){
		int celsius = (int)((f - 32) * 5/9);
		return celsius;
	}
	
	public int askTemperatureInFahrenheit(Scanner s){
		System.out.println("Please enter the temperature in F");
		return s.nextInt();
	}
	public int askTempinCelcius(Scanner n){
		System.out.println("Please enter the temperature in C");
		return n.nextInt();
	}
}	

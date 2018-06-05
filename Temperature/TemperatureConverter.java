import java.util.Scanner;

public class TemperatureConverter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int celsius, fahren;
		Scanner scan = new Scanner(System.in);
			
		Temperatureclass tc = new Temperatureclass("my object of doom!");
		fahren = tc.askTemperatureInFahrenheit(scan);
		celsius = tc.fahrenheitToCelsius(fahren);
		System.out.println(celsius);
		
		scan.close();
	}

}


import java.sql.*;

public class BusClient {
	
	public static void main(String[] args) {
		//"jdbc:sqlite:C:\\Users\\watsondyla\\Documents\\BUS2.sqlite"
		BusHandler handle = new BusHandler("jdbc:sqlite:C:\\Users\\watsondyla\\workspace\\BusProject\\BUS2.sqlite");
		
		handle.calcDisrupts();
		handle.findRoutesActive("Yes");
		handle.updateDisruptions();
		handle.findRouteHistory("");
		handle.top10MostAffected();
		handle.top10LeastAffected();
		handle.routesAffectedTimeFrame(5);
	}
}

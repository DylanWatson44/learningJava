import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * <h> Bus Handler </h>
 * Class containing all the methods necessary to query the bus database. The
 * constructor will perform initial setup and connect to the database.
 * 
 * @author watsondyla
 *
 */
public class BusHandler {
	private Statement stmt = null;
	private String url = null;
	private Connection conn = null;

	private ArrayList<Integer> Routes = new ArrayList<Integer>();
	private ArrayList<Integer> DisruptionCount = new ArrayList<Integer>();

	public BusHandler(String databaseUrl) {
		url = databaseUrl;
		try {
			// connect to database
			conn = DriverManager.getConnection(url);
			System.out.println("Connection to SQLite successful");
			System.out.println("###");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Calculates the number of disruptions a route has experienced using the
	 * linking table "RouteDisruptions".
	 */
	public void calcDisrupts() {
		try {
			stmt = conn.createStatement();
			String query = "select Route, count(Disruption) " + "from RouteDisruptions " + "group by Route";
			ResultSet rs = stmt.executeQuery(query);

			// print out query results
			System.out.println("Calculating total disruptions per route...");
			System.out.println("Route | Disruptions");
			while (rs.next()) {
				int Route = rs.getInt("Route");
				Routes.add(Route);
				int Disruptions = rs.getInt("count(Disruption)");
				DisruptionCount.add(Disruptions);

				String output1 = String.format("%-6s|", "" + Route);
				String output2 = String.format("%6s", "" + Disruptions);

				System.out.println(output1 + output2);
			}
			System.out.println();
			rs.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Updates the database using the data generated with the method
	 * "calcDisrupts()". Does not need to be called if no additional disruptions
	 * have added to the database.
	 * <p>
	 * <b>Note</b>: calcDisrupts() must be be called prior to calling this
	 * method.
	 */
	public void updateDisruptions() {
		try {
			stmt = conn.createStatement();

			if (Routes.size() > 0) {
				for (int i = 0; i < Routes.size(); i++) {
					String update = "update Route " + "set Disruptions = " + DisruptionCount.get(i)
							+ " where RouteID = " + Routes.get(i);
					stmt.executeUpdate(update);
				}
			} else {
				System.out.println("The number of disruptions has not been calculated yet!");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Method to find routes that either have, or have never been affected by a
	 * disruption in the past.
	 * 
	 * 
	 * @param history
	 *            pass "Has been affected" to show all the routes that have ever
	 *            been affected by a disruption, or "" to show routes that have
	 *            never been affected
	 */
	public void findRouteHistory(String history) {
		try {
			stmt = conn.createStatement();
			String query = null;
			if (history.equals("Has been affected")) {
				System.out.println("Finding routes with a history of disruptions...");
				query = "select RouteID " + "from Route " + "where Disruptions != 0";
			} else {
				System.out.println("Finding routes that have never had a disruption...");
				query = "select RouteID " + "from Route " + "where Disruptions = 0";
			}
			ResultSet rs = stmt.executeQuery(query);

			System.out.println("Result Routes: ");
			while (rs.next()) {
				int Route = rs.getInt("RouteID");

				String output1 = String.format("|%-3s|", "" + Route);

				System.out.println(output1);
			}
			System.out.println();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Prints out a list of either active or deactive buses.
	 * 
	 * @param active
	 *            should be "Yes" (active) or "No" (deactive)
	 */
	public void findRoutesActive(String active) {
		try {

			// create query
			stmt = conn.createStatement();

			String query = "select RouteID " + "from Route " + "where CurrentlyActive like \"" + active + "\"";

			ResultSet rs = stmt.executeQuery(query);

			System.out.println("These Routes are currently unaffected: ");
			while (rs.next()) {
				int RouteID = rs.getInt("RouteID");
				System.out.println(RouteID);
			}
			System.out.println();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Finds buses affected by a disruption between the current date and a date
	 * n years ago, where n is an int number of years passed in as an argument
	 * to this method.
	 * 
	 * @param years
	 *            The number of years back from the present that you wish to
	 *            test.
	 */
	public void routesAffectedTimeFrame(int years) {
		try {
			stmt = conn.createStatement();

			String query = "select Route, DisruptionID, DisruptionDate " + "from Disruption join RouteDisruptions "
					+ "where julianday(DisruptionDate) between julianday('now')-365*" + years + " AND julianday('now') "
					+ "AND Disruption.DisruptionID = RouteDisruptions.Disruption";

			ResultSet rs = stmt.executeQuery(query);

			System.out.println("These are the routes that have been affect in the last " + years + " years");
			System.out.println();
			System.out.println("|Route | DisruptionID | DisruptionDate");
			while (rs.next()) {
				int Route = rs.getInt("Route");
				String output1 = String.format("|%-6s|", "" + Route);

				int DisruptionID = rs.getInt("DisruptionID");
				String output2 = String.format("%-14s|", DisruptionID);

				String Date = rs.getString("DisruptionDate");
				String output3 = String.format("%14s", Date);

				System.out.println(output1 + output2 + output3);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Prints the top 10 most disrupted routes.
	 */
	public void top10MostAffected() {
		try {
			stmt = conn.createStatement();

			String query = "select RouteID, Disruptions " + "from Route " + "order by Disruptions desc " + "limit 10";

			ResultSet rs = stmt.executeQuery(query);

			System.out.println("Calculating top 10 disrupted routes...");
			System.out.println("Route  | Disruptions");
			while (rs.next()) {
				int Route = rs.getInt("RouteID");

				int Disruptions = rs.getInt("Disruptions");

				String output1 = String.format("|%-6s|", "" + Route);
				String output2 = String.format("%-6s|", "" + Disruptions);

				System.out.println(output1 + output2);
			}
			System.out.println();
			rs.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Prints the top 10 least Affected routes
	 */
	public void top10LeastAffected() {
		try {
			stmt = conn.createStatement();

			String query = "select RouteID, Disruptions " + "from Route " + "order by Disruptions asc " + "limit 10";

			ResultSet rs = stmt.executeQuery(query);

			System.out.println("Calculating top 10 least disrupted routes...");
			System.out.println("Route  | Disruptions");
			while (rs.next()) {
				int Route = rs.getInt("RouteID");

				int Disruptions = rs.getInt("Disruptions");

				String output1 = String.format("|%-6s|", "" + Route);
				String output2 = String.format("%-6s|", "" + Disruptions);

				System.out.println(output1 + output2);
			}
			System.out.println();
			rs.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}

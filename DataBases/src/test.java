
import java.sql.*;

public class test {
public static void main(String[] args){
	String url = "jdbc:sqlite:C:\\Users\\watsondyla\\Downloads\\EmployeeDB(1).sqlite";
	Connection conn = null;
	Statement stmt = null;
	String query = "select * from Employee";
	
	try {
		conn = DriverManager.getConnection(url);
		System.out.println("Connection to SQLite successful");
		System.out.println("###");
		stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		
		while (rs.next()) {
			int EmpId = rs.getInt("EmpID");
			String EmpName = rs.getString("EmpName");
			int Age = rs.getInt("Age");
			 System.out.println(EmpId + " " + EmpName + " - " + Age);
			 }

			} catch (SQLException e) {
			e.printStackTrace();
			}
	}
	
}


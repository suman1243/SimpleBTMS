package banking;


import java.sql.Connection;
import java.sql.DriverManager;

public class Connect {
	public static Connection connect() {
		try {
			
//			Class.forName("oracle.jdbc.driver.OracleDriver");
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection c=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "suman", "1234");
			return c;
			
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

}

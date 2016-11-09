package chatServer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionTest {
	public static void main(String[] args) {
		try {
			Connection con = null;

			con = DriverManager.getConnection("jdbc:mysql://localhost?useSSL=false",
												//SSL error -> attach "?useSSL=false"
					"root", "0504lgy");
				  // "ID", "password"  
			java.sql.Statement st = null;
			ResultSet rs = null;
			st = con.createStatement();
			rs = st.executeQuery("SHOW DATABASES");
			// Consisting of a database query confirmation

			if (st.execute("SHOW DATABASES")) {
				rs = st.getResultSet();
			}

			while (rs.next()) {
				String str = rs.getNString(1); //Bringing the contents of the next line
				System.out.println(str);
			}
		} catch (SQLException sqex) {
			System.out.println("SQLException: " + sqex.getMessage()); //Print to the incoming message with an error event
			System.out.println("SQLState: " + sqex.getSQLState()); //After successful execution of the embedded SQL statement in a variable named SQLSTATE, fail, get passed the SQL statement results, such as error
		}

	}
}
package ui;
import java.sql.*;
import javax.swing.*;

public class MySqlConnect {
	Connection conn = null;
	public static Connection ConnectDB(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/hub","root","1234");
			JOptionPane.showMessageDialog(null, "Connected to database");
			return conn;
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
			
	}
}

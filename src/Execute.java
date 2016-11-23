import java.awt.Button;
import java.awt.Dialog;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class Execute extends Frame implements ActionListener {

	private String url = "jdbc:mysql://localhost:3306/hub?useSSL=false";
	private String strUser = "root";
	private String strPassword = "1234";
	private String strMySQLDriver = "com.mysql.jdbc.Driver";
	Connection con;
	Statement stmt;
	ResultSet rs;
	String sql;

	String id;
	String pw;
	String name;

	
	Login log = new Login();
	InputIP ip = new InputIP();
	SignUp signup = new SignUp();
	Restroom rest = new Restroom();
	UserData d = new UserData();
	
	Button ok;
	Label msg;
	Dialog info;

	public Execute() {
		try {
			Class.forName(strMySQLDriver);
			con = (Connection) DriverManager.getConnection(url, strUser, strPassword);
			stmt = (Statement) con.createStatement();
		} catch (Exception b) {
			System.out.println("db연결실패");
		}
		
		log.signUp.addActionListener(this);
		signup.btnNew.addActionListener(this);
		log.login.addActionListener(this);
		log.inputIP.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		Object obj = e.getSource();
		if (obj.equals(log.signUp)) {
			signup.setVisible(true);
		} else if (obj.equals(log.login)) {
			if(loginCheck()){
				log.setVisible(false);
				//ip is not complete 
				rest.lbl_IdView.setText(id);
				rest.lbl_NickView.setText(name);}
			else JOptionPane.showMessageDialog(null, "It's not correct your ID or PW","login error",JOptionPane.ERROR_MESSAGE);
		} else if (obj.equals(signup.btnNew)) {
			if(selectInsert())
			{	JOptionPane.showMessageDialog(null, "SignUp is complete successfully","sign up complete",JOptionPane.INFORMATION_MESSAGE);
				signup.setVisible(false);
				log.setVisible(true);
			}else
				JOptionPane.showMessageDialog(null, "This ID is already used",id,JOptionPane.ERROR_MESSAGE);
		} else if(obj.equals(log.inputIP)){
			System.out.println("s");
			ip.setVisible(true);
		}
	}

	private boolean selectInsert() {
		UserData d = new UserData();
		d.id = signup.ID.getText().trim();
		d.pw = signup.PW.getText().trim();
		d.name = signup.NAME.getText().trim();

		String sql = "insert into login value('" + d.id + "','" + d.pw + "','" + d.name + "')";

		try {

			int rss = stmt.executeUpdate(sql);
			System.out.println(rss + "    ");
			return true;
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}return false;
	}

	public boolean loginCheck() {
		id = log.textID.getText().trim();
		pw = log.textPW.getText().trim();

		String query = "SELECT pw,name FROM login where id='" + id + "'";
		System.out.println(query);
		try {
			ResultSet rs = stmt.executeQuery(query);

			if (rs.next()) {
				name = rs.getString("name");
				if (pw.equals(rs.getString("pw"))) {
					System.out.println("login");
					rest.setVisible(true);
					return true;
				}
			}
		} catch (Exception b) {
			b.printStackTrace();
		}return false;
	}

	public static void main(String[] args) {
		new Execute();

	}
}

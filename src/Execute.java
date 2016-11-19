import java.awt.Button;
import java.awt.Dialog;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Login_Execute extends Frame implements ActionListener{
	
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

	SignUp signup = new SignUp();
	Login log = new Login();
	RestRoomUI rest = new RestRoomUI();
	Button ok;
	Label msg;
	Dialog info;

	public Login_Execute() {

	try {
	Class.forName(strMySQLDriver);
	con = (Connection) DriverManager.getConnection(url, strUser, strPassword);
	stmt = (Statement) con.createStatement();
	} catch (Exception b) {
	System.out.println("db접속완료");
	}

	signup.btnNew.addActionListener(this);
	log.btnSignUp.addActionListener(this);
	//log.btnLogin.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

	Object obj = e.getSource();
	if (obj.equals(log.btnSignUp)) {
	signup.setVisible(true);
	} else if (obj.equals(log.btnLogin)) {
	loginCheck();
	}
	
	
//	rest.label1.setText(name + "로그인.");
//	rest.setTitle(name + "");
//	log.setVisible(false);
//	} else if (obj.equals(rest.button1)) {
//	showUpdate();
//	} else if (obj.equals(rest.button2)) {
//	selectDelete();
//	} else if (obj.equals(rest.button3)) {
//	rest.setVisible(false);
//	log.setVisible(true);

//	clearText();

	} /*else if (obj.equals(signup.btnNew)) {
	if (signup.btnNew.equals("완료")) {
	System.out.println("ㅎㅎㅎ");
	selectInsert();
	signup.setVisible(false);
	}}/*}
	

	private void clearText() {

	log.ID_textField.setText("");
	log.PW_textField.setText("");
	signup.textField_ID.setText("");
	signup.textField_PW.setText("");
	signup.textField_NAME.setText("");
	}


	private void selectUpdate() {

	UserData d = new UserData();
	d.id = signup.textField_ID.getText().trim();
	d.pw = signup.textField_PW.getText().trim();
	d.name = signup.textField_NAME.getText().trim();

	String sql = "update login set id='" + d.id + "',pw='" + d.pw
	+ "' where name='" + d.name + "'";
	try {
	int rss = stmt.executeUpdate(sql);
	System.out.println(rss + "      Ʈ");


	signup.setVisible(false);
	} catch (Exception e) {
	e.printStackTrace(System.out);
	}
	}


	private void selectInsert() {
	UserData d = new UserData();
	d.id = signup.textField_ID.getText().trim();
	d.pw = signup.textField_PW.getText().trim();
	d.name = signup.textField_NAME.getText().trim();
	String sql = "insert into login value('" + d.id + "','" + d.pw + "','"
	+ d.name + "')";
	
	try {

	int rss = stmt.executeUpdate(sql);

	System.out.println(rss + "    ");
//	rest.tex1.setText("      Ϸ ");
	} catch (Exception e) {
	e.printStackTrace(System.out);
	}
	}
/*
	void showUpdate() {
	signup.btn3.setLabel("       ");
	signup.btn2.setLabel("    ");
	
	String name = rest.tex1.getText();
	String id = signup.tf_id.getText();
	String pw = signup.tf_pass.getText();
	String sql = "select * from login where name='" + name + "'";
	System.out.println(sql);
	try {
	rs = stmt.executeQuery(sql);
	if (rs.next()) {
	signup.tf_id.setText(rs.getString("id"));
	signup.tf_pass.setText(rs.getString("pw"));
	signup.tf_name.setText(rs.getString("name"));
	System.out.println(rs + "    ");

	rest.tex1.setText("                 Ϸ  ");
	}
	} catch (Exception e) {
	rest.tex1.setText("              ߻ ");
	System.out.println("              ߻  : " + e);
	}
	signup.tf_name.setEnabled(false);
	signup.setVisible(true);
	}

	void selectDelete() {

	String name = rest.tex1.getText();
	String sql = "delete from login where name='" + name + "'";
	System.out.println(sql);
	try {

	int rss = stmt.executeUpdate(sql);

	System.out.println(rss + "    ");


	rest.tex1.setText("      Ϸ ");

	} catch (Exception e) {
	rest.tex1.setText("             ߻ ");
	System.out.println("             ߻  : " + e);
	}
	}// deleteDB
*/
	public void loginCheck() {
	id = log.ID_textField.getText().trim();
	pw = log.PW_textField.getText().trim();

	String query = "SELECT pw,name FROM login where id='" + id + "'";

	System.out.println(query);
	try {
	ResultSet rs = stmt.executeQuery(query);

	if (rs.next()) {
	name = rs.getString("name");

	if (pw.equals(rs.getString("pw"))) {

	System.out.println("login");
	rest.setVisible(true);

	}

	}

	} catch (Exception b) {
	b.printStackTrace();
	}
	}

	public static void main(String[] args) {
	new Login_Execute();

	}
	} 
	 

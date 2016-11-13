package ui;
import java.awt.BorderLayout;
import java.sql.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.Color;

public class LoginUI extends JFrame {

	Connection conn = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	JButton btnLogin;
	private JPanel contentPane;
	private JTextField ID_textField;
	private JTextField PW_textField;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginUI frame = new LoginUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	

	/**
	 * Create the frame.
	 */
	public LoginUI() {
		
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		setTitle("Hub chatting program");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 446, 293);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setResizable(false);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(14, 12, 410, 230);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lbl_ID = new JLabel("\uC544\uC774\uB514");
		lbl_ID.setBounds(53, 100, 62, 18);
		panel.add(lbl_ID);
		
		JLabel lbl_PW = new JLabel("\uBE44\uBC00\uBC88\uD638");
		lbl_PW.setBounds(46, 130, 62, 18);
		panel.add(lbl_PW);
		
		ID_textField = new JTextField();
		ID_textField.setBounds(120, 97, 116, 24);
		panel.add(ID_textField);
		ID_textField.setColumns(10);
		
		PW_textField = new JTextField();
		PW_textField.setBounds(120, 127, 116, 24);
		panel.add(PW_textField);
		PW_textField.setColumns(10);
		
		JButton btnLogin = new JButton("\uB85C\uADF8\uC778"); // 로그인 버튼 클릭시 ID_textField, PW_textField 정보 받아와서 DB에 확인후 로그인
		btnLogin.setBounds(252, 96, 90, 27);
		panel.add(btnLogin);
		
		JButton btnNewmembership = new JButton("\uD68C\uC6D0\uAC00\uC785"); // 회원가입 버튼 클릭시  회원가입창 뜨게함
		btnNewmembership.setBounds(252, 126, 90, 27);
		panel.add(btnNewmembership);
		
		JLabel lbl_IP = new JLabel("\uC11C\uBC84 \uC544\uC774\uD53C");
		lbl_IP.setBounds(53, 167, 80, 18);
		panel.add(lbl_IP);
		
		JButton btnIP = new JButton("IP \uC785\uB825"); // IP입력버튼 클릭시 IP입력창 뜨게함
		btnIP.setBounds(147, 163, 116, 27);
		panel.add(btnIP);
		
		JLabel lbl_hub = new JLabel("Hub Chatting Program");
		lbl_hub.setForeground(new Color(0, 0, 0));
		lbl_hub.setFont(new Font("Segoe Print", Font.BOLD, 25));
		lbl_hub.setBounds(53, 40, 301, 33);
		panel.add(lbl_hub);
	}
	private void btnLoginActionPerformed(java.awt.event.ActionEvent evt)
	{
		conn = MySqlConnect.ConnectDB();
		String sql = "Select * from login where id=? and pw=?";
		try{
			pst = conn.prepareStatement(sql);
			pst.setString(1, ID_textField.getText());
			pst.setString(2, PW_textField.getText());
			rs = pst.executeQuery();
			if(rs.next()){
				JOptionPane.showMessageDialog(null, "Welcome user");
				Welcome w = new Welcome();
				w.setVisible(true);
			}
			else{
				JOptionPane.showMessageDialog(null, "Invalid username or password", "Access Denied", JOptionPane.ERROR_MESSAGE);
			}
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, e);

		}
	}
}
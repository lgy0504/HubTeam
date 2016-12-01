package UI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

public class Login extends JFrame {

	Connection conn = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	JButton btnLogin;
	JButton btnSignUp;
	private JPanel contentPane;
	private JTextField ID_textField;
	private JTextField PW_textField;

	public static Login frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Login();
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
	public Login() {
		JPanel p1 = new JPanel();

		/*
		 * try {
		 * UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
		 * } catch (ClassNotFoundException e) { // TODO Auto-generated catch
		 * block e.printStackTrace(); } catch (InstantiationException e) { //
		 * TODO Auto-generated catch block e.printStackTrace(); } catch
		 * (IllegalAccessException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); } catch (UnsupportedLookAndFeelException e) { //
		 * TODO Auto-generated catch block e.printStackTrace(); }
		 */

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

		JLabel lbl_ID = new JLabel("아이디");
		lbl_ID.setBounds(53, 100, 62, 18);
		panel.add(lbl_ID);

		JLabel lbl_PW = new JLabel("비밀번호");
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

		
		
		JButton btnLogin = new JButton("로그인"); // 로그인 버튼 클릭시 ID_textField,
		btnLogin.addActionListener(new ButtonListener());
		btnLogin.setBounds(252, 126, 90, 27);
		panel.add(btnLogin);										// PW_textField 정보 받아와서 DB에 확인후
												// 로그인
		btnLogin.setBounds(252, 96, 90, 27);
		panel.add(btnLogin);

		JButton btnSignUp = new JButton("회원가입"); // 회원가입 버튼 클릭시 회원가입창 뜨게함
		btnSignUp.addActionListener(new ButtonListener());
		btnSignUp.setBounds(252, 126, 90, 27);
		panel.add(btnSignUp);

		JLabel lbl_IP = new JLabel("서버 아이피");
		lbl_IP.setBounds(53, 167, 80, 18);
		panel.add(lbl_IP);

		JButton btnIP = new JButton("IP 입력"); // IP입력버튼 클릭시 IP입력창 뜨게함
		btnIP.setBounds(147, 163, 116, 27);
		panel.add(btnIP);

		JLabel lbl_hub = new JLabel("Hub Chatting Program");
		lbl_hub.setForeground(new Color(0, 0, 0));
		lbl_hub.setFont(new Font("Segoe Print", Font.BOLD, 25));
		lbl_hub.setBounds(53, 40, 301, 33);
		panel.add(lbl_hub);
	}

	class ButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand().equals("회원가입")) {
				System.out.println(e.getActionCommand());
				//frame.setVisible(false);
				SignUp signUp = new SignUp();
			}
			else if (e.getActionCommand().equals("로그인")) {
				System.out.println(e.getActionCommand());
			}
		}
	}
}
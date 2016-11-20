import java.awt.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.*;

public class Login extends JFrame {

	Connection conn = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	JButton login, signUp;
	JTextField textID, textPW;

	public Login() {
		this.setTitle("Hub chatting Login");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(100, 100, 446, 293);
		
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setContentPane(contentPane);
		this.setResizable(false);
		contentPane.setLayout(null);
		
		JPanel jPanel = new JPanel();
		jPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		jPanel.setBounds(14, 12, 410, 230);
		jPanel.setLayout(null);
		contentPane.add(jPanel);
		
		JLabel ID = new JLabel("아이디");
		ID.setBounds(53, 100, 62, 18);
		jPanel.add(ID);

		JLabel PW = new JLabel("비밀번호");
		PW.setBounds(46, 130, 62, 18);
		jPanel.add(PW);

		textID = new JTextField();
		textID.setBounds(120, 97, 116, 24);
		jPanel.add(textID);
		textID.setColumns(10);

		textPW = new JTextField();
		textPW.setBounds(120, 127, 116, 24);
		jPanel.add(textPW);
		textPW.setColumns(10);

		login = new JButton("로그인");
		login.setBounds(252, 96, 90, 27);
		jPanel.add(login);

		signUp = new JButton("회원가입"); 
		signUp.setBounds(252, 126, 90, 27);
		jPanel.add(signUp);

		JLabel IP = new JLabel("서버 아이피");
		IP.setBounds(53, 167, 80, 18);
		jPanel.add(IP);

		JButton inputIP = new JButton("IP 입력");
		inputIP.setBounds(147, 163, 116, 27);
		jPanel.add(inputIP);

		JLabel hub = new JLabel("Hub Chatting Program");
		hub.setForeground(new Color(0, 0, 0));
		hub.setFont(new Font("Segoe Print", Font.BOLD, 25));
		hub.setBounds(53, 40, 301, 33);
		jPanel.add(hub);
		
		this.setVisible(true);
	}
}
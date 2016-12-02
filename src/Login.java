import java.awt.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.*;

public class Login extends JFrame {

	Connection conn = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	JButton login, signUp, inputIP;
	JTextField textID, textPW;

	public Login() {
		this.setTitle("Hub chatting Login");
	    Toolkit toolkit = Toolkit.getDefaultToolkit();
	    Image img = toolkit.getImage("Image/Title.PNG");
	    setIconImage(img);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(100, 100, 339, 460);
		
		JPanel contentPane = new JPanel();
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setContentPane(contentPane);
		this.setResizable(false);
		contentPane.setLayout(null);
		
	    final ImageIcon icon = new ImageIcon("Image/Login.jpg");
	  	
	    JPanel jPanel = new JPanel(){
		           public void paintComponent(Graphics g) {
		               g.drawImage(icon.getImage(), 0, 0, null);
		               setOpaque(false);
		               super.paintComponent(g);
		              } 
		       };
		jPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		jPanel.setBounds(0, 0, 338, 432);
		jPanel.setLayout(null);
		contentPane.add(jPanel);
		
		JLabel ID = new JLabel("아이디");
		ID.setBounds(26, 326, 62, 18);
		jPanel.add(ID);

		JLabel PW = new JLabel("비밀번호");
		PW.setBounds(26, 354, 62, 18);
		jPanel.add(PW);

		textID = new JTextField();
		textID.setBounds(100, 324, 116, 24);
		jPanel.add(textID);
		textID.setColumns(10);

		textPW = new JTextField();
		textPW.setBounds(100, 354, 116, 24);
		jPanel.add(textPW);
		textPW.setColumns(10);

		login = new JButton("로그인");
		login.setBounds(228, 322, 90, 27);
		jPanel.add(login);

		signUp = new JButton("회원가입"); 
		signUp.setBounds(228, 350, 90, 27);
		jPanel.add(signUp);

		JLabel IP = new JLabel("서버 아이피");
		IP.setBounds(26, 404, 80, 18);
		jPanel.add(IP);

		inputIP = new JButton("IP 입력");
		inputIP.setBounds(100, 400, 116, 27);
		jPanel.add(inputIP);
		
		this.setVisible(true);
	}
}
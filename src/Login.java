import java.awt.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

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
		this.setBounds(100, 100, 320, 491);
		
		
		
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setContentPane(contentPane);
		this.setResizable(false);
		contentPane.setLayout(null);
		
		
		final ImageIcon icon = new ImageIcon("image/Login.jpg");		//이미지 삽입
		JPanel jPanel = new JPanel(){
            public void paintComponent(Graphics g) {
                g.drawImage(icon.getImage(), 0, 0, null);
                setOpaque(false);
                super.paintComponent(g);
               } 
        };
		jPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		jPanel.setBounds(0, 0, 314, 463);
		jPanel.setLayout(null);
		contentPane.add(jPanel);
		
		JLabel ID = new JLabel("아이디");
		ID.setBounds(23, 355, 62, 18);
		jPanel.add(ID);

		JLabel PW = new JLabel("비밀번호");
		PW.setBounds(23, 383, 62, 18);
		jPanel.add(PW);

		textID = new JTextField();
		textID.setBounds(97, 353, 116, 24);
		jPanel.add(textID);
		textID.setColumns(10);

		textPW = new JTextField();
		textPW.setBounds(97, 381, 116, 24);
		jPanel.add(textPW);
		textPW.setColumns(10);

		login = new JButton("");
		login.setIcon(new ImageIcon("image/loginbtn.PNG"));
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		login.setBounds(222, 351, 80, 27);
		jPanel.add(login);

		signUp = new JButton("");
		signUp.setIcon(new ImageIcon("image/SignUpbtn.PNG"));
		signUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			
			}
		});
		signUp.setBounds(222, 379, 80, 27);
		jPanel.add(signUp);

		JLabel IP = new JLabel("서버 아이피");
		IP.setBounds(23, 425, 80, 18);
		jPanel.add(IP);

		inputIP = new JButton("");
		inputIP.setIcon(new ImageIcon("image/IPbtn.PNG"));
		inputIP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		inputIP.setBounds(97, 421, 116, 27);
		jPanel.add(inputIP);
		
		this.setVisible(true);
	}

}
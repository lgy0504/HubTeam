import java.awt.Color;
 import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
 import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
 import javax.swing.JFrame;
 import javax.swing.JLabel;
 import javax.swing.JPanel;
 import javax.swing.JTextField;
 import javax.swing.border.EmptyBorder;
 import javax.swing.border.EtchedBorder;
 
 public class SignUp extends JFrame {
 
 	JPanel contentPane;
 	JTextField ID;
 	JTextField PW;
 	JTextField NAME;
 	JTextField textField;
 	JButton btnNew;
 	
 	public SignUp() {
 		
 		this.setTitle("Hub Chatting SignUp");
 		Toolkit toolkit = Toolkit.getDefaultToolkit();
 		Image img = toolkit.getImage("Image/Title.PNG");
 		setIconImage(img);
 		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 		this.setBounds(100, 100, 307, 289);
 		contentPane = new JPanel();
 		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
 		this.setContentPane(contentPane);
 		contentPane.setLayout(null);
 		
		final ImageIcon icon = new ImageIcon("image/SignUp.jpg");		//이미지 삽입
		JPanel panel = new JPanel(){
            public void paintComponent(Graphics g) {
                g.drawImage(icon.getImage(), 0, 0, null);
                setOpaque(false);
                super.paintComponent(g);
               } 
        };
 		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
 		panel.setBounds(0, 0, 291, 251);
 		contentPane.add(panel);
 		panel.setLayout(null);
 		
 		JLabel lbl_ID = new JLabel("아이디");
 		lbl_ID.setBounds(58, 120, 62, 18);
 		panel.add(lbl_ID);
 		
 		JLabel lbl_PW = new JLabel("비밀번호");
 		lbl_PW.setBounds(58, 148, 62, 18);
 		panel.add(lbl_PW);
 		
 		JLabel lbl_NAME = new JLabel("닉네임");
 		lbl_NAME.setBounds(58, 176, 62, 18);
 		panel.add(lbl_NAME);
 		
 		ID = new JTextField();
 		ID.setBounds(132, 118, 116, 24);
 		panel.add(ID);
 		ID.setColumns(10);
 		
 		PW = new JTextField();
 		PW.setBounds(132, 146, 116, 24);
 		panel.add(PW);
 		PW.setColumns(10);
 		
 		NAME = new JTextField();
 		NAME.setBounds(132, 174, 116, 24);
 		panel.add(NAME);
 		NAME.setColumns(10);
 	
 		btnNew = new JButton(""); 
		btnNew.setIcon(new ImageIcon("image/Sucbtn.PNG"));
 		btnNew.setBounds(132, 209, 105, 27);
 		panel.add(btnNew);
 	
 	
 	
 }
 }

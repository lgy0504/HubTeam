import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(100, 00, 440, 303);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(10, 10, 400, 244);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lbl_ID = new JLabel("아이디");
		lbl_ID.setBounds(99, 79, 62, 18);
		panel.add(lbl_ID);
		
		JLabel lbl_PW = new JLabel("비밀번호");
		lbl_PW.setBounds(99, 109, 62, 18);
		panel.add(lbl_PW);
		
		JLabel lbl_NAME = new JLabel("닉네임");
		lbl_NAME.setBounds(99, 139, 62, 18);
		panel.add(lbl_NAME);
		
		ID = new JTextField();
		ID.setBounds(185, 76, 116, 24);
		panel.add(ID);
		ID.setColumns(10);
		
		PW = new JTextField();
		PW.setBounds(185, 106, 116, 24);
		panel.add(PW);
		PW.setColumns(10);
		
		NAME = new JTextField();
		NAME.setBounds(185, 136, 116, 24);
		panel.add(NAME);
		NAME.setColumns(10);
	
		btnNew = new JButton("완료"); 
		btnNew.setBounds(148, 189, 105, 27);
		panel.add(btnNew);
		
		JLabel lblHubChattingMembership = new JLabel("Hub Chatting Membership");
		lblHubChattingMembership.setForeground(Color.BLACK);
		lblHubChattingMembership.setFont(new Font("Segoe Print", Font.BOLD, 25));
		lblHubChattingMembership.setBounds(38, 12, 340, 40);
		panel.add(lblHubChattingMembership);
		
		
		
	}
}

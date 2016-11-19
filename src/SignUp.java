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
	JTextField textField_ID;
	JTextField textField_PW;
	JTextField textField_NAME;
	JTextField textField;
	JButton btnNew;
	
	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	public SignUp() {
		
		/*
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
		*/
		setTitle("Hub Chatting Membership");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 00, 440, 303);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
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
		
		JLabel lbl_NAME = new JLabel("이름");
		lbl_NAME.setBounds(99, 139, 62, 18);
		panel.add(lbl_NAME);
		
		textField_ID = new JTextField();
		textField_ID.setBounds(185, 76, 116, 24);
		panel.add(textField_ID);
		textField_ID.setColumns(10);
		
		textField_PW = new JTextField();
		textField_PW.setBounds(185, 106, 116, 24);
		panel.add(textField_PW);
		textField_PW.setColumns(10);
		
		textField_NAME = new JTextField();
		textField_NAME.setBounds(185, 136, 116, 24);
		panel.add(textField_NAME);
		textField_NAME.setColumns(10);
	
		btnNew = new JButton("완료"); 
		btnNew.setBounds(148, 189, 105, 27);
		panel.add(btnNew);
		
		JLabel lblHubChattingMembership = new JLabel("Hub Chatting Membership");
		lblHubChattingMembership.setForeground(Color.BLACK);
		lblHubChattingMembership.setFont(new Font("Segoe Print", Font.BOLD, 25));
		lblHubChattingMembership.setBounds(38, 12, 340, 40);
		panel.add(lblHubChattingMembership);
		
		
		setVisible(true);
		
		
	}
}

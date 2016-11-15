package kr.ac.sunmoon;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

public class SignupUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField_ID;
	private JTextField textField_PW;
	private JTextField textField_Name;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignupUI frame = new SignupUI();
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
	public SignupUI() {
		
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
		
		setTitle("Hub Chatting Membership");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 440, 265);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(10, 10, 400, 200);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lbl_ID = new JLabel("\uC544\uC774\uB514");
		lbl_ID.setBounds(100, 100, 62, 18);
		panel.add(lbl_ID);
		
		JLabel lbl_PW = new JLabel("\uBE44\uBC00\uBC88\uD638");
		lbl_PW.setBounds(100, 130, 62, 18);
		panel.add(lbl_PW);
		
		textField_ID = new JTextField();
		textField_ID.setBounds(186, 97, 116, 24);
		panel.add(textField_ID);
		textField_ID.setColumns(10);
		
		textField_PW = new JTextField();
		textField_PW.setBounds(186, 127, 116, 24);
		panel.add(textField_PW);
		textField_PW.setColumns(10);
		
		JButton btnNew = new JButton("\uD68C\uC6D0\uAC00\uC785"); //회원가입 버튼 클릭시 textField_ID, textField_PW 정보 DB저장 ?
		btnNew.setBounds(148, 161, 105, 27);
		panel.add(btnNew);
		
		JLabel lblHubChattingMembership = new JLabel("Hub Chatting Membership");
		lblHubChattingMembership.setForeground(Color.BLACK);
		lblHubChattingMembership.setFont(new Font("Segoe Print", Font.BOLD, 25));
		lblHubChattingMembership.setBounds(38, 12, 340, 40);
		panel.add(lblHubChattingMembership);
		
		JLabel lbl_Name = new JLabel("\uC774\uB984");
		lbl_Name.setBounds(100, 67, 62, 18);
		panel.add(lbl_Name);
		
		textField_Name = new JTextField();
		textField_Name.setColumns(10);
		textField_Name.setBounds(186, 64, 116, 24);
		panel.add(textField_Name);
	}
}

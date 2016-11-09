package kr.ac.sunmoon;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import java.awt.Font;
import java.awt.Color;

public class LoginUI extends JFrame {

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
		
		JLabel lblNewLabel = new JLabel("\uC544\uC774\uB514");
		lblNewLabel.setBounds(53, 100, 62, 18);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\uBE44\uBC00\uBC88\uD638");
		lblNewLabel_1.setBounds(46, 130, 62, 18);
		panel.add(lblNewLabel_1);
		
		ID_textField = new JTextField();
		ID_textField.setBounds(120, 97, 116, 24);
		panel.add(ID_textField);
		ID_textField.setColumns(10);
		
		PW_textField = new JTextField();
		PW_textField.setBounds(120, 127, 116, 24);
		panel.add(PW_textField);
		PW_textField.setColumns(10);
		
		JButton Login_btn = new JButton("\uB85C\uADF8\uC778");
		Login_btn.setBounds(252, 96, 90, 27);
		panel.add(Login_btn);
		
		JButton New_btn = new JButton("\uD68C\uC6D0\uAC00\uC785");
		New_btn.setBounds(252, 126, 90, 27);
		panel.add(New_btn);
		
		JLabel lblNewLabel_2 = new JLabel("\uC11C\uBC84 \uC544\uC774\uD53C");
		lblNewLabel_2.setBounds(53, 167, 80, 18);
		panel.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("IP \uC785\uB825");
		btnNewButton.setBounds(147, 163, 116, 27);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel_3 = new JLabel("Hub Chatting Program");
		lblNewLabel_3.setForeground(new Color(0, 0, 0));
		lblNewLabel_3.setFont(new Font("Segoe Print", Font.BOLD, 25));
		lblNewLabel_3.setBounds(53, 40, 301, 33);
		panel.add(lblNewLabel_3);
	}
}

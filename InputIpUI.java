package kr.ac.sunmoon;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;

public class InputIpUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel lblIpPort;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InputIpUI frame = new InputIpUI();
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
	public InputIpUI() {
		setResizable(false);
		setTitle("Hub Chatting Program");
		
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
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 354, 236);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_Ip = new JLabel("IP");
		lbl_Ip.setFont(new Font("±¼¸²", Font.PLAIN, 18));
		lbl_Ip.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Ip.setBounds(48, 95, 78, 25);
		contentPane.add(lbl_Ip);
		
		textField = new JTextField();
		textField.setBounds(140, 95, 142, 24);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel label = new JLabel("\uD3EC\uD2B8\uBC88\uD638");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("±¼¸²", Font.PLAIN, 16));
		label.setBounds(48, 132, 78, 25);
		contentPane.add(label);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(140, 132, 142, 24);
		contentPane.add(textField_1);
		
		lblIpPort = new JLabel("IP & Port number");
		lblIpPort.setHorizontalAlignment(SwingConstants.CENTER);
		lblIpPort.setForeground(Color.BLACK);
		lblIpPort.setFont(new Font("Segoe Print", Font.BOLD, 25));
		lblIpPort.setBounds(14, 30, 300, 33);
		contentPane.add(lblIpPort);
	}
}

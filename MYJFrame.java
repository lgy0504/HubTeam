package kr.ac.sunmoon;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class MYJFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MYJFrame frame = new MYJFrame();
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
	public MYJFrame() {
		try{
			UIManager.setLookAndFeel("com.jtattoo.plaf.mint.MintLookAndFeel");
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
		setBounds(100, 100, 500, 285);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(133, 115, 190, 24);
		contentPane.add(textField);
		
		JButton btnF = new JButton("\uB85C\uADF8\uC778");
		btnF.setBounds(337, 114, 105, 27);
		contentPane.add(btnF);
		
		JButton button = new JButton("\uD68C\uC6D0\uAC00\uC785");
		button.setBounds(337, 153, 105, 27);
		contentPane.add(button);
		
		JLabel lblNewLabel = new JLabel("\uC544\uC774\uB514");
		lblNewLabel.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 17));
		lblNewLabel.setBounds(57, 116, 62, 18);
		contentPane.add(lblNewLabel);
		
		JLabel label = new JLabel("\uBE44\uBC00\uBC88\uD638");
		label.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 17));
		label.setBounds(43, 155, 76, 18);
		contentPane.add(label);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(133, 154, 190, 24);
		contentPane.add(passwordField);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("\uC544\uC774\uB514 \uC800\uC7A5");
		chckbxNewCheckBox.setBounds(133, 183, 105, 27);
		contentPane.add(chckbxNewCheckBox);
		
		JCheckBox checkBox = new JCheckBox("\uC790\uB3D9 \uB85C\uADF8\uC778");
		checkBox.setBounds(244, 183, 103, 27);
		contentPane.add(checkBox);
		
		JLabel lblHub = new JLabel("Hub \uCC44\uD305\uD504\uB85C\uADF8\uB7A8");
		lblHub.setBackground(Color.BLACK);
		lblHub.setForeground(Color.PINK);
		lblHub.setFont(new Font("¸¼Àº °íµñ", Font.BOLD | Font.ITALIC, 25));
		lblHub.setBounds(133, 53, 220, 26);
		contentPane.add(lblHub);
	}
}

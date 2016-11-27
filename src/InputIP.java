
import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

public class InputIP extends JFrame {

	 JTextField textField;
	 JTextField textField_1;
	 JLabel lblIpPort;
	 
	public InputIP() {
		
		this.setTitle("Hub Chatting Program");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(100, 100, 365, 235);
		
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setContentPane(contentPane);
		this.setResizable(false);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(10, 10, 340, 180);
		panel.setLayout(null);
		contentPane.add(panel);
		
		JLabel IP = new JLabel("IP");
		IP.setBounds(119, 70, 14, 21);
		panel.add(IP);
		//IP.setFont(new Font("굴림", Font.PLAIN, 18));
		IP.setHorizontalAlignment(SwingConstants.CENTER);
		
		textField = new JTextField();
		textField.setBounds(138, 69, 116, 24);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel label = new JLabel("\uD3EC\uD2B8\uBC88\uD638");
		label.setBounds(69, 105, 64, 19);
		panel.add(label);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("굴림", Font.PLAIN, 16));
		
		textField_1 = new JTextField();
		textField_1.setBounds(138, 103, 116, 24);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		lblIpPort = new JLabel("IP & Port number");
		lblIpPort.setBounds(59, 12, 233, 45);
		panel.add(lblIpPort);
		lblIpPort.setHorizontalAlignment(SwingConstants.CENTER);
		lblIpPort.setForeground(Color.BLACK);
		lblIpPort.setFont(new Font("Segoe Print", Font.BOLD, 25));
		
		JButton btninput = new JButton("\uC785\uB825");
		btninput.setBounds(138, 139, 61, 27);
		panel.add(btninput);
	}
}
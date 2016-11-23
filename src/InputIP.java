import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

public class InputIP extends JFrame {

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
					InputIP frame = new InputIP();
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
	public InputIP() {
		
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
		setBounds(100, 100, 365, 235);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(10, 10, 340, 180);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lbl_Ip = new JLabel("IP");
		lbl_Ip.setBounds(119, 70, 14, 21);
		panel.add(lbl_Ip);
		lbl_Ip.setFont(new Font("굴림", Font.PLAIN, 18));
		lbl_Ip.setHorizontalAlignment(SwingConstants.CENTER);
		
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
		
		setResizable(true);
	}
}
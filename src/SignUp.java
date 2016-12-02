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
 		this.setBounds(100, 100, 440, 303);
 		contentPane = new JPanel();
 		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
 		this.setContentPane(contentPane);
 		contentPane.setLayout(null);
 		
 		JPanel panel = new JPanel();
 		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
 		panel.setBounds(0, 0, 410, 265);
 		contentPane.add(panel);
 		panel.setLayout(null);
 		
 		JLabel lbl_ID = new JLabel("���̵�");
 	lbl_ID.setBounds(71, 98, 62, 18);
 		panel.add(lbl_ID);
 		
 		JLabel lbl_PW = new JLabel("��й�ȣ");
 		lbl_PW.setBounds(71, 132, 62, 18);
 		panel.add(lbl_PW);
 		
 		JLabel lbl_NAME = new JLabel("�г���");
 		lbl_NAME.setBounds(71, 166, 62, 18);
 		panel.add(lbl_NAME);
 		
 		ID = new JTextField();
 		ID.setBounds(145, 96, 116, 24);
 		panel.add(ID);
 		ID.setColumns(10);
 		
 		PW = new JTextField();
 		PW.setBounds(145, 130, 116, 24);
 		panel.add(PW);
 		PW.setColumns(10);
 		
 		NAME = new JTextField();
 		NAME.setBounds(145, 164, 116, 24);
 		panel.add(NAME);
 		NAME.setColumns(10);
 	
 		btnNew = new JButton("�Ϸ�"); 
 		btnNew.setBounds(155, 198, 105, 27);
 		panel.add(btnNew);
 	
 	
 	
 }
 }

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InputIP extends JFrame {

	 JTextField textField;
	 JTextField textField_1;
	 JButton btninput;
	 
	public InputIP() {
		
		this.setTitle("Hub Chatting Program");
		Toolkit toolkit = Toolkit.getDefaultToolkit();
 		Image img = toolkit.getImage("Image/Title.PNG");
 		setIconImage(img);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(100, 100, 385, 235);
		
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setContentPane(contentPane);
		this.setResizable(false);
		contentPane.setLayout(null);
		
		
		final ImageIcon icon = new ImageIcon("image/ip&port.jpg");		//이미지 삽입
		JPanel panel = new JPanel(){
            public void paintComponent(Graphics g) {
                g.drawImage(icon.getImage(), 0, 0, null);
                setOpaque(false);
                super.paintComponent(g);
               } 
        };
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(0, 0, 379, 207);
		panel.setLayout(null);
		contentPane.add(panel);
		
		JLabel IP = new JLabel("IP");
		IP.setBounds(25, 104, 14, 21);
		panel.add(IP);
		//IP.setFont(new Font("굴림", Font.PLAIN, 18));
		IP.setHorizontalAlignment(SwingConstants.CENTER);
		
		textField = new JTextField();
		textField.setBounds(115, 103, 116, 24);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel label = new JLabel("\uD3EC\uD2B8\uBC88\uD638");
		label.setBounds(25, 135, 64, 19);
		panel.add(label);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("굴림", Font.PLAIN, 16));
		
		textField_1 = new JTextField();
		textField_1.setBounds(115, 134, 116, 24);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		btninput = new JButton("");
		btninput.setIcon(new ImageIcon("image/Inputbtn.PNG"));
		btninput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btninput.setBounds(139, 170, 61, 27);
		panel.add(btninput);
	}
}

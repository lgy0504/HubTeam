import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class ChattingRoomUI extends JFrame{

	private JPanel contentPane;
	JTextField textField = new JTextField(); // ä���Է�
	JTextArea textArea = new JTextArea();
	JButton btnchat = new JButton("     \uC804\uC1A1     ");
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChattingRoomUI frame = new ChattingRoomUI();
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
	public ChattingRoomUI() {
		setResizable(false);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 690, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_Center = new JPanel();
		panel_Center.setBorder(new TitledBorder(null, "\uCC44\uD305\uCC3D", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panel_Center.setBounds(5, 5, 672, 367);
		contentPane.add(panel_Center);
		panel_Center.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_Center.add(scrollPane, BorderLayout.CENTER);
		
		 // ä��â
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);
		
		JPanel panel = new JPanel();
		panel.setBounds(5, 384, 455, 27);
		contentPane.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		
		panel.add(textField, BorderLayout.CENTER);
		
		
		
		/*
		textField.addKeyListener(new KeyListener() {			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					String keyword = textField.getText();
					//textArea.append(UserName + " : " + keyword+"\n");
					textArea.append("��â�� : " + keyword +"\n");
					textField.setText("");
				}
			}
			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub				
			}
			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub				
			}
		});
		*/
		textField.setColumns(10);
				
		
		/*
		btnchat.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String keyword = textField.getText();
				//textArea.append(UserName + " : " + keyword+"\n");
				textArea.append("��â�� : " + keyword +"\n");
				textField.setText("");
			}
		});
		*/
		panel.add(btnchat, BorderLayout.EAST);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(466, 384, 211, 27);
		contentPane.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JButton btnExit = new JButton("   \uB098\uAC00\uAE30   "); // �������ư �׼� ���Ƿ�
		btnExit.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
				
			}
		});
		
		JButton btnEmoticon = new JButton("\uC774\uBAA8\uD2F0\uCF58");
		btnEmoticon.addActionListener(new ButtonListener());
		panel_1.add(btnEmoticon, BorderLayout.WEST);
		panel_1.add(btnExit, BorderLayout.EAST);
		
	}	
	class ButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand().equals("\uC774\uBAA8\uD2F0\uCF58")) {
				System.out.println(e.getActionCommand());
				//frame.setVisible(false);
				emoticonUI emoticon = new emoticonUI();
			}
		}
	}

}
package UI;

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

public class ChattingRoomUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

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
		
		/*try {
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
		}*/
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 470);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_Center = new JPanel();
		panel_Center.setBorder(new TitledBorder(null, "\uCC44\uD305\uCC3D", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panel_Center.setBounds(5, 5, 455, 367);
		contentPane.add(panel_Center);
		panel_Center.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_Center.add(scrollPane, BorderLayout.CENTER);
		
		JTextArea textArea = new JTextArea(); // 채팅창
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);		
		
		JPanel panel_East = new JPanel();
		panel_East.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\uCC38\uC5EC\uC790", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_East.setBounds(466, 5, 211, 367);
		contentPane.add(panel_East);
		panel_East.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		panel_East.add(scrollPane_1, BorderLayout.CENTER);
		
		JList list = new JList(); // 유저 리스트
		scrollPane_1.setViewportView(list);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); //JList선택모드 단일선택
		
		JPanel panel = new JPanel();
		panel.setBounds(5, 384, 455, 27);
		contentPane.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		textField = new JTextField(); // 채팅입력
		panel.add(textField, BorderLayout.CENTER);
		textField.addKeyListener(new KeyListener() {			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					String keyword = textField.getText();
					//textArea.append(UserName + " : " + keyword+"\n");
					textArea.append("한창수 : " + keyword +"\n");
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
		textField.setColumns(10);
				
		JButton btnchat = new JButton("     \uC804\uC1A1     ");
		btnchat.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String keyword = textField.getText();
				//textArea.append(UserName + " : " + keyword+"\n");
				textArea.append("한창수 : " + keyword +"\n");
				textField.setText("");
			}
		});
		panel.add(btnchat, BorderLayout.EAST);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(466, 384, 211, 27);
		contentPane.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JButton btnExit = new JButton("   \uB098\uAC00\uAE30   "); // 나가기버튼 액션 대기실로
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
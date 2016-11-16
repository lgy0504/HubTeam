package kr.ac.sunmoon;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import mew.SixClient;
import mew.User;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;

public class ChattingRoomUI extends JFrame {

	private JPanel contentPane;
	private JTextField SendField;

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
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);
		
		JPanel panel_East = new JPanel();
		panel_East.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\uCC38\uC5EC\uC790", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_East.setBounds(466, 5, 211, 367);
		contentPane.add(panel_East);
		panel_East.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		panel_East.add(scrollPane_1, BorderLayout.CENTER);
		
		JList list = new JList();
		scrollPane_1.setViewportView(list);
		
		JPanel panel = new JPanel();
		panel.setBounds(5, 384, 455, 27);
		contentPane.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		SendField = new JTextField();
		SendField.setColumns(10);
		panel.add(SendField, BorderLayout.CENTER);
		SendField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					msgSummit();
				}
			}

		});
		// 보내기 버튼
		JButton SendBtn = new JButton("     \uC804\uC1A1     ");
		panel.add(SendBtn, BorderLayout.EAST);
		SendBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				msgSummit();
				SendField.requestFocus();
			}
		});
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(466, 384, 211, 27);
		contentPane.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		// 나가기버튼
		JButton OutBtn = new JButton("   \uB098\uAC00\uAE30   ");
		panel_1.add(OutBtn, BorderLayout.EAST);
		OutBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			System.exit(0);
			}
			});
		// 이모티콘 버튼
		JButton ImageBtn = new JButton("\uC774\uBAA8\uD2F0\uCF58");
		panel_1.add(ImageBtn, BorderLayout.WEST);
		ImageBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//imagemsgSummit
			}
		});
		
	}
	private void msgSummit() {
		String string = SendField.getText();
		if (!string.equals("")) {
			try {
				// 채팅방에 메시지 보냄 
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	private void imagemsgSummint(){
		//이모티콘 보내기 함수
	}
}
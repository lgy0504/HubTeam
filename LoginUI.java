package kr.ac.sunmoon;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import javax.swing.ImageIcon;

public class emoticonUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					emoticonUI frame = new emoticonUI();
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
	public emoticonUI() {
		setTitle("emoticon");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 332, 224);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel = new JPanel();
		panel_2.add(panel);
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		
		JButton btnSmile = new JButton("");
		//btnSmile.setBorderPainted(false); // 버튼 경계선 제거
		//btnSmile.setFocusPainted(false); //포커스(선택했던 버튼 표시) 제거
	//	btnSmile.setContentAreaFilled(false);//버튼영역 배경 제거


		btnSmile.setIcon(new ImageIcon("C:\\Users\\Kim\\Desktop\\Desktop\\1.png"));
		btnSmile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel.add(btnSmile);
		
		JButton btnSad = new JButton("");
		btnSad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		btnSad.setIcon(new ImageIcon("C:\\Users\\Kim\\Desktop\\Desktop\\sad.png"));
		panel.add(btnSad);
		
		JButton btnAngry = new JButton("Angry");
		btnAngry.setIcon(new ImageIcon("C:\\Users\\Kim\\Desktop\\Desktop\\\uD5E4\uD5F7.png"));
		btnAngry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});

		panel.add(btnAngry);
		
		JButton btnHi = new JButton("");
		btnHi.setIcon(new ImageIcon("C:\\Users\\Kim\\Desktop\\Desktop\\hihi.png"));
		panel.add(btnHi);
		
		JPanel panel_3 = new JPanel();
		panel_2.add(panel_3);
		panel_3.setLayout(new GridLayout(1, 0, 0, 0));
		
		
		
		JButton btnShy = new JButton("shy");
		btnShy.setIcon(new ImageIcon("C:\\Users\\Kim\\Desktop\\Desktop\\22.png"));
		panel_3.add(btnShy);
		
		JButton btnLove = new JButton("Love");

		btnLove.setIcon(new ImageIcon("C:\\Users\\Kim\\Desktop\\Desktop\\223.png"));
		btnLove.setSelectedIcon(null);
		panel_3.add(btnLove);
		
		JButton btnSulk = new JButton("sulk");
		btnSulk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSulk.setIcon(new ImageIcon("C:\\Users\\Kim\\Desktop\\Desktop\\3.png"));
		panel_3.add(btnSulk);
		
		JButton btnSorry = new JButton("");
		btnSorry.setIcon(new ImageIcon("C:\\Users\\Kim\\Desktop\\Desktop\\5.png"));
		btnSorry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_3.add(btnSorry);
	}

}


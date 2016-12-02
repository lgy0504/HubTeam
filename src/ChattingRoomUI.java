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
	JTextField textField = new JTextField(); // 채팅입력
	JTextArea textArea = new JTextArea();
	JButton btnchat = new JButton("     \uC804\uC1A1     ");
	JButton btnExit = new JButton("   \uB098\uAC00\uAE30   ");
	JButton btnEmoticon = new JButton("\uC774\uBAA8\uD2F0\uCF58");
	

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
		
		 // 채팅창
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);
		
		JPanel panel = new JPanel();
		panel.setBounds(5, 384, 455, 27);
		contentPane.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		
		panel.add(textField, BorderLayout.CENTER);
		
		textField.setColumns(10);
				
		panel.add(btnchat, BorderLayout.EAST);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(466, 384, 211, 27);
		contentPane.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		panel_1.add(btnEmoticon, BorderLayout.WEST);
		panel_1.add(btnExit, BorderLayout.EAST);
		
	}	
}
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class Restroom extends JFrame {

	
	JButton makeroombtn = new JButton("\uBC29 \uB9CC\uB4E4\uAE30");
	JButton joinroombtn = new JButton("\uBC29 \uB4E4\uC5B4\uAC00\uAE30");
	JPanel contentPane;
	JLabel lbl_IpView, lbl_IdView,lbl_NickView;
	JList Room_list = new JList();//전체 방목록
	JList User_list = new JList();//전체 접속자
	public Restroom() {
		setResizable(false);
		setTitle("Hub Chatting Program");
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu basicMenus = new JMenu("\uC77C\uBC18");
		menuBar.add(basicMenus);

		JMenuItem changeNickItem = new JMenuItem("\uB2C9\uB124\uC784 \uBC14\uAFB8\uAE30");
		basicMenus.add(changeNickItem);

		JMenuItem exitItem = new JMenuItem("\uB05D\uB0B4\uAE30");
		basicMenus.add(exitItem);

		JMenu helpMenus = new JMenu("\uB3C4\uC6C0\uB9D0");
		menuBar.add(helpMenus);

		JMenuItem proInfoItem = new JMenuItem("\uD504\uB85C\uADF8\uB7A8 \uC815\uBCF4");
		helpMenus.add(proInfoItem);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 705, 520);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel roomlistPane = new JPanel();
		roomlistPane.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\uBC29 \uBAA9\uB85D", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		roomlistPane.setBounds(10, 10, 500, 445);
		contentPane.add(roomlistPane);
		roomlistPane.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		roomlistPane.add(scrollPane, BorderLayout.CENTER);
		
		scrollPane.setViewportView(Room_list);
		
		JPanel btnpanel = new JPanel();
		roomlistPane.add(btnpanel, BorderLayout.SOUTH);
		btnpanel.setLayout(new GridLayout(0, 2, 0, 0));
		
		
		btnpanel.add(makeroombtn);
		
		
		btnpanel.add(joinroombtn);
		
		JPanel UserPane = new JPanel();
		UserPane.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"),	"\uC0AC\uC6A9\uC790 \uBAA9\uB85D", TitledBorder.CENTER,	TitledBorder.TOP, null, null));
		UserPane.setBounds(520, 10, 170, 250);
		contentPane.add(UserPane);
		UserPane.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		UserPane.add(scrollPane_1, BorderLayout.CENTER);
		
		scrollPane_1.setViewportView(User_list);
		
		JButton btnMsg = new JButton("\uCABD\uC9C0 \uBCF4\uB0B4\uAE30");
		UserPane.add(btnMsg, BorderLayout.SOUTH);
		
		JPanel MyinfoPane = new JPanel();
		MyinfoPane.setLayout(null);
		MyinfoPane.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\uB0B4 \uC815\uBCF4", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		MyinfoPane.setBounds(520, 270, 171, 185);
		contentPane.add(MyinfoPane);
		
		JLabel lbl_Ip = new JLabel("IP");
		lbl_Ip.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Ip.setBounds(0, 49, 57, 15);
		MyinfoPane.add(lbl_Ip);
		
		JLabel lbl_Id = new JLabel("\uC544\uC774\uB514");
		lbl_Id.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Id.setBounds(0, 89, 57, 15);
		MyinfoPane.add(lbl_Id);
		
		JLabel lbl_Nickname = new JLabel("\uB2C9\uB124\uC784");
		lbl_Nickname.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Nickname.setBounds(0, 129, 57, 15);
		MyinfoPane.add(lbl_Nickname);
		
		lbl_IpView = new JLabel("");
		lbl_IpView.setBounds(57, 49, 102, 15);
		MyinfoPane.add(lbl_IpView);
		
		lbl_IdView = new JLabel("");
		lbl_IdView.setBounds(57, 89, 102, 15);
		MyinfoPane.add(lbl_IdView);
		
		lbl_NickView = new JLabel("");
		lbl_NickView.setBounds(57, 129, 102, 15);
		MyinfoPane.add(lbl_NickView);
	}
}

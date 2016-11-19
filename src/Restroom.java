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

public class RestRoomUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RestRoomUI frame = new RestRoomUI();
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
	public RestRoomUI() {
		setResizable(false);
		setTitle("Hub Chatting Program");
		
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
		setBounds(100, 100, 720, 535);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel roomlistPane = new JPanel();
		roomlistPane.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\uBC29 \uBAA9\uB85D", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		roomlistPane.setBounds(10, 10, 500, 250);
		contentPane.add(roomlistPane);
		roomlistPane.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		roomlistPane.add(scrollPane, BorderLayout.CENTER);
		
		JList roomlist = new JList();
		scrollPane.setViewportView(roomlist);
		
		JPanel btnpanel = new JPanel();
		roomlistPane.add(btnpanel, BorderLayout.SOUTH);
		btnpanel.setLayout(new GridLayout(0, 2, 0, 0));
		
		JButton makeroombtn = new JButton("\uBC29 \uB9CC\uB4E4\uAE30");
		btnpanel.add(makeroombtn);
		
		JButton joinroombtn = new JButton("\uBC29 \uB4E4\uC5B4\uAC00\uAE30");
		btnpanel.add(joinroombtn);
		
		JPanel UserPane = new JPanel();
		UserPane.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"),	"\uC0AC\uC6A9\uC790 \uBAA9\uB85D", TitledBorder.CENTER,	TitledBorder.TOP, null, null));
		UserPane.setBounds(520, 10, 170, 250);
		contentPane.add(UserPane);
		UserPane.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		UserPane.add(scrollPane_1, BorderLayout.CENTER);
		
		JList userlist = new JList();
		scrollPane_1.setViewportView(userlist);
		
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
		
		JLabel lbl_IpView = new JLabel("");
		lbl_IpView.setBounds(57, 49, 102, 15);
		MyinfoPane.add(lbl_IpView);
		
		JLabel lbl_IdView = new JLabel("");
		lbl_IdView.setBounds(57, 89, 102, 15);
		MyinfoPane.add(lbl_IdView);
		
		JLabel lbl_NickView = new JLabel("");
		lbl_NickView.setBounds(57, 129, 102, 15);
		MyinfoPane.add(lbl_NickView);
		
		JPanel RestchatPane = new JPanel();
		RestchatPane.setBorder(new TitledBorder(null, "\uB300\uAE30\uC2E4 \uCC44\uD305", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		RestchatPane.setBounds(10, 270, 500, 185);
		contentPane.add(RestchatPane);
		RestchatPane.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane_2 = new JScrollPane();
		RestchatPane.add(scrollPane_2, BorderLayout.CENTER);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		scrollPane_2.setViewportView(textArea);
		
		JPanel textPane = new JPanel();
		RestchatPane.add(textPane, BorderLayout.SOUTH);
		textPane.setLayout(new BorderLayout(0, 0));
		
		textField = new JTextField();
		textPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("\uC804\uC1A1");
		textPane.add(btnNewButton, BorderLayout.EAST);
	}
}

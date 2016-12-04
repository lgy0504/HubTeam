import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
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
	JButton btnchat = new JButton("");
	

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
		setTitle("ChattingRoom");
		Toolkit toolkit = Toolkit.getDefaultToolkit();
 		Image img = toolkit.getImage("Image/Title.PNG");
 		setIconImage(img);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 673, 450);
 		final ImageIcon icon1 = new ImageIcon("image/Normal.jpg");		//이미지 삽입
		contentPane = new JPanel(){
            public void paintComponent(Graphics g) {
                g.drawImage(icon1.getImage(), 0, 0, null);
                setOpaque(false);
                super.paintComponent(g);
               } 
        };
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		final ImageIcon icon2 = new ImageIcon("image/Normal.jpg");		//이미지 삽입
		JPanel panel_Center = new JPanel(){
            public void paintComponent(Graphics g) {
                g.drawImage(icon2.getImage(), 0, 0, null);
                setOpaque(false);
                super.paintComponent(g);
               } 
        };
		panel_Center.setBorder(new TitledBorder(null, "\uCC44\uD305\uCC3D", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panel_Center.setBounds(5, 5, 649, 367);
		contentPane.add(panel_Center);
		panel_Center.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_Center.add(scrollPane, BorderLayout.CENTER);
		
		 // 채팅창
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);
		textField.setBounds(15, 382, 319, 30);
		contentPane.add(textField);
		textField.setColumns(10);
		btnchat.setBounds(335, 382, 89, 29);
		contentPane.add(btnchat);
		btnchat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		btnchat.setIcon(new ImageIcon("image/sendbtn.PNG"));
		
			JButton btnEmoticon = new JButton("");
			btnEmoticon.setBounds(443, 382, 110, 30);
			contentPane.add(btnEmoticon);
			btnEmoticon.setIcon(new ImageIcon("image/Emoticonbtn.PNG"));
			
			JButton btnExit = new JButton("");
			btnExit.setBounds(553, 382, 89, 30);
			contentPane.add(btnExit);
			btnExit.setIcon(new ImageIcon("image/Exitbtn.PNG"));
			btnExit.addActionListener(new ActionListener() {			
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					dispose();
					
				}
			});
			btnEmoticon.addActionListener(new ButtonListener());
		
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

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class emoticonUI extends JFrame {
	
	private JPanel contentPane;
	public static emoticonUI frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new emoticonUI();
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
		setResizable(false);
		setTitle("emoticon");
        Toolkit toolkit = Toolkit.getDefaultToolkit();
	    Image img = toolkit.getImage("Image/Title.PNG");
	    setIconImage(img);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
		
		final JButton btnSmile = new JButton("");



		btnSmile.setIcon(new ImageIcon("image\\Smiles.gif"));
		btnSmile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object obj = e.getSource();
				if((JButton)obj == btnSmile){
				}
			}
		});
		panel.add(btnSmile);
		
		final JButton btnSad = new JButton("");
		btnSad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object obj = e.getSource();
				if((JButton)obj == btnSad){ 
				}
			}
		});

		btnSad.setIcon(new ImageIcon("image\\sadsad.gif"));
		panel.add(btnSad);
		
		final JButton btnAngry = new JButton("");
		btnAngry.setIcon(new ImageIcon("image\\angry.gif"));
		btnAngry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object obj = e.getSource();
				if((JButton)obj == btnAngry){
	
				}
			}
		});

		panel.add(btnAngry);
		
		final JButton btnHi = new JButton("");
		btnHi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object obj = e.getSource();
				if((JButton)obj == btnHi){
				}
			}
		});
		btnHi.setIcon(new ImageIcon("image\\hihi.gif"));
		panel.add(btnHi);
		
		JPanel panel_3 = new JPanel();
		panel_2.add(panel_3);
		panel_3.setLayout(new GridLayout(1, 0, 0, 0));
		
		
		
		final JButton btnShy = new JButton("");
		btnShy.setIcon(new ImageIcon("image\\sssss.gif"));
		panel_3.add(btnShy);
		btnAngry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object obj = e.getSource();
				if((JButton)obj == btnShy){
				}
			}
		});
		
		
		final JButton btnLove = new JButton("");

		btnLove.setIcon(new ImageIcon("image\\lovelove.gif"));
		btnLove.setSelectedIcon(null);
		panel_3.add(btnLove);
		btnAngry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object obj = e.getSource();
				if((JButton)obj == btnLove){
				}
			}
		});
		
		final JButton btnSulk = new JButton("");
		btnSulk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object obj = e.getSource();
				if((JButton)obj == btnSulk){
				}
			}
		});
		btnSulk.setIcon(new ImageIcon("image\\sulks.gif"));
		panel_3.add(btnSulk);
		
		final JButton btnSorry = new JButton("");
		btnSorry.setIcon(new ImageIcon("image\\sorrysorry.gif"));
		btnSorry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object obj = e.getSource();
				if((JButton)obj == btnSorry){
				}
			}
		});
		panel_3.add(btnSorry);
		setVisible(true);
	}

}


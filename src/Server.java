import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Connection;

public class Server extends JFrame implements ActionListener{
	
	private JPanel contentPane;
	private JTextField port_tf;
	private JTextArea textArea = new JTextArea();
	private JButton stop_btn = new JButton("���� ����");
	private JButton start_btn = new JButton("���� ����");
	
	private ServerSocket serverSocket;
	private Socket socket;
	private int port;
	private Vector user_vc = new Vector();
	private Vector room_vc = new Vector();
	
	private StringTokenizer st;
	
	Server() {
		init();
		start();
	}
	private void start() {
		start_btn.addActionListener(this);
		stop_btn.addActionListener(this);
	}
	
	private void init(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100,100,319,370);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12,10,279,205);
		contentPane.add(scrollPane);
		
		
		scrollPane.setViewportView(textArea);
		textArea.setEditable(false);
		
		JLabel lblNewLabel = new JLabel("\uD3EC\uD2B8\uBC88\uD638");//��Ʈ ��ȣ
		lblNewLabel.setBounds(12,238,57,15);
		contentPane.add(lblNewLabel);
		
		port_tf = new JTextField();
		port_tf.setBounds(81, 235, 210, 21);
		contentPane.add(port_tf);
		port_tf.setColumns(10);
		
		
		start_btn.setBounds(12,280,138,23);
		contentPane.add(start_btn);
		
		
		stop_btn.setBounds(151,280,140,23);
		contentPane.add(stop_btn);
		stop_btn.setEnabled(false);
		
		this.setVisible(true);
	}
	
	private void Server_start()
	{
		try {
			serverSocket = new ServerSocket(port);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "�̹� ������� ��Ʈ","�˸�",JOptionPane.ERROR_MESSAGE);
		}
		
		if(serverSocket != null)//���������� ��Ʈ�� ������ ���
		{
			Connection();
			
		}
	}
	
	private void Connection()
	{
		
		
		
		Thread thread = new Thread(new Runnable() {
			
			@Override
			public void run() {//�����忡�� ó���� ���� ����
				
				while(true){
				try {
					textArea.append("����� ���� �����\n");
					socket = serverSocket.accept();//����� ���� ���(���� ���)
					textArea.append("����� ����!!\n");
					UserInfo user = new UserInfo(socket);
					
					user.start();//��ü�� ������ ����
					
					
				} catch (IOException e) {
					
					break;
				}
			  }
			}
		});
		thread.start();
		

	}
	public static void main(String[] args){
		
		new Server();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == start_btn)
		{
			System.out.println("��ŸƮ ��ư Ŭ��");
			port = Integer.parseInt(port_tf.getText().trim());
			Server_start();
			start_btn.setEnabled(false);
			port_tf.setEditable(false);
			stop_btn.setEnabled(true);
		}
		else if(e.getSource() == stop_btn)
		{
			stop_btn.setEnabled(false);
			start_btn.setEnabled(true);
			port_tf.setEditable(true);
			try {
				serverSocket.close();
				user_vc.removeAllElements();
				room_vc.removeAllElements();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println("��ž ��ư Ŭ��");
		}
		
	}
	
	class UserInfo extends Thread
	{
		private OutputStream os;
		private InputStream is;
		private DataOutputStream dos;
		private DataInputStream dis;
		
		private Socket user_socket;
		private String Nickname = "";
		
		private boolean RoomCh = true;
		
		public UserInfo(Socket soc) 
		{
			this.user_socket = soc;
			
			UserNetwork();
		}
		private void UserNetwork()
		{
			try{
			is = user_socket.getInputStream();
			dis = new DataInputStream(is);
			
			os = user_socket.getOutputStream();
			dos = new DataOutputStream(os);
			
			Nickname = dis.readUTF();//������� �г����� �޴´�
			textArea.append(Nickname +"����� ����");
			
			
			BroadCast("NewUser/"+Nickname);//���� ����ڿ��� �ڽ��� �˸���
			
			//�ڽſ��� ���� ����ڸ� �޾ƿ��� �κ�
			for(int i=0;i<user_vc.size();i++)
			{
				UserInfo u = (UserInfo)user_vc.elementAt(i);
				send_Message("OldUser/"+u.Nickname);
			}
			//�ڽſ��� ���� �� ����� �޾ƿ��� �κ�
			
			for(int i=0; i<room_vc.size();i++)
			{
				RoomInfo r = (RoomInfo)room_vc.elementAt(i);
				send_Message("OldRoom/"+r.Room_name);
			}
			
			send_Message("room_list_update/ ");
			
			user_vc.add(this);
			
			BroadCast("user_list_update/ ");
			
			
			}catch(IOException e){}
			//JOptionPane.showMessageDialog(null, "Stream���� ����","�˸�",JOptionPane.ERROR_MESSAGE);
		}
		public void run()
		{
			while(true)
			{
				try {
					String msg = dis.readUTF();
					textArea.append(Nickname+" ����ڷκ��� ���� �޽��� :"+ msg + "\n");
					InMessage(msg);
				} catch (IOException e) {
					textArea.append(Nickname+" : ����� ���� ������\n");
					
					try{
					dos.close();
					dis.close();
					user_socket.close();
					user_vc.remove(this);
					BroadCast("User_out/"+Nickname);
					BroadCast("user_list_update/ ");
					}catch(IOException e3){}
					break;
				}//�޼��� ����
				
			}
		}
		
		private void InMessage(String str)//Ŭ���̾�Ʈ�κ��� ������ �޽��� ó��
		{
			st = new StringTokenizer(str, "/");
			
			
			String protocol = st.nextToken();
			String message = st.nextToken();
			System.out.println("�������� : "+protocol );
			System.out.println("�޼��� : "+ message);
			
		
			if(protocol.equals("Note"))
			{
				//protocol = Note
				//message = user
				// note = �޴� ����
				
				//String user = st.nextToken();
				String note = st.nextToken();
				System.out.println("�޴� ���:"+message);
				System.out.println("���� ����:"+note);
				
				//���Ϳ��� �ش� ����ڸ� ã�� �޼��� ����
				for(int i=0; i<user_vc.size();i++)
				{
					UserInfo u = (UserInfo)user_vc.elementAt(i);
					
					if(u.Nickname.equals(message))
					{
						u.send_Message("Note/"+Nickname+"/"+note);
						//Note/User1/����
					}
				}
			}
			else if(protocol.equals("CreateRoom"))
			{
				for(int i=0; i<room_vc.size();i++)
				{
					RoomInfo r = (RoomInfo)room_vc.elementAt(i);
					
					if(r.Room_name.equals(message))
					{
						send_Message("CreateRoomFail/ok");
						RoomCh = false;
						break;
					}	
				}
				if(RoomCh)
				{
					RoomInfo new_room = new RoomInfo(message, this);
					room_vc.add(new_room);
					send_Message("CreateRoom/"+message);
					new_room.Add_User(this);
					
					
					BroadCast("New_Room/"+message);
				}
				RoomCh = true;
			}
			else if(protocol.equals("RemoveRoom"))
			{
				for(int i=0; i<room_vc.size();i++)
				{
					RoomInfo remove_room = (RoomInfo)room_vc.elementAt(i);
					
					if(remove_room.Room_name.equals(message))
					{
						room_vc.remove(remove_room);
						send_Message("RemoveRoom/"+message);
						
					}	
				}
			}
			else if(protocol.equals("Chatting"))
			{
				String msg = st.nextToken();
				
				for(int i=0;i<room_vc.size();i++)
				{
					RoomInfo r = (RoomInfo)room_vc.elementAt(i);
					
					if(r.Room_name.equals(message))//�ش� ���� ã���� ��
					{
						r.BroadCast_Room("Chatting/"+Nickname+"/"+msg);
					}
				}
			}
			else if(protocol.equals("JoinRoom"))
			{
				for(int i=0;i<room_vc.size();i++)
				{
					RoomInfo r = (RoomInfo)room_vc.elementAt(i);
					if (r.Room_name.equals(message)) 
					{
						//���ο� ����� �˸�
						r.BroadCast_Room("Chatting/�˸�/******"+Nickname+"���� �����ϼ̽��ϴ�******");
						//����� �߰�
						r.Add_User(this);
						send_Message("JoinRoom/"+message);
					}
				}
			}
			else if(protocol.equals("ExitRoom"))
			{
				for(int i=0;i<room_vc.size();i++)
				{
					RoomInfo r = (RoomInfo)room_vc.elementAt(i);
					if (r.Room_name.equals(message)) 
					{
						r.BroadCast_Room("Chatting/�˸�/******"+Nickname+"���� �����ϼ̽��ϴ�******");
						r.Remove_User(this);
						send_Message("ExitRoom/"+message);
					}
				}
			}
		}
		
		private void BroadCast(String str)
		{
			for(int i=0; i<user_vc.size();i++)//��ü ����ڿ��� �޼��� ������ �κ�
			{
				UserInfo u = (UserInfo)user_vc.elementAt(i);
				u.send_Message(str);
			}
		}
		
		private void send_Message(String str)
		{
			try {
				dos.writeUTF(str);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	class RoomInfo
	{
		private String Room_name;
		private Vector Room_user_vc = new Vector();
		
		RoomInfo(String str, UserInfo u) 
		{
			this.Room_name = str;
			this.Room_user_vc.add(u);
		}
		public void BroadCast_Room(String str) //���� ���� ��� ������� �˸���
		{
			for(int i=0;i<Room_user_vc.size();i++)
			{
				UserInfo u = (UserInfo)Room_user_vc.elementAt(i);
				u.send_Message(str);
			}
		}
		private void Add_User(UserInfo u)
		{
			this.Room_user_vc.add(u);
		}
		private void Remove_User(UserInfo u)
		{
			this.Room_user_vc.add(u);
		}
	}
}

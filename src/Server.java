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
	private JButton stop_btn = new JButton("서버 중지");
	private JButton start_btn = new JButton("서버 실행");
	
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
		
		JLabel lblNewLabel = new JLabel("\uD3EC\uD2B8\uBC88\uD638");//포트 번호
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
			JOptionPane.showMessageDialog(null, "이미 사용중인 포트","알림",JOptionPane.ERROR_MESSAGE);
		}
		
		if(serverSocket != null)//정상적으로 포트가 열렸을 경우
		{
			Connection();
			
		}
	}
	
	private void Connection()
	{
		
		
		
		Thread thread = new Thread(new Runnable() {
			
			@Override
			public void run() {//스레드에서 처리할 일을 기재
				
				while(true){
				try {
					textArea.append("사용자 접속 대기중\n");
					socket = serverSocket.accept();//사용자 접속 대기(무한 대기)
					textArea.append("사용자 접속!!\n");
					UserInfo user = new UserInfo(socket);
					
					user.start();//객체의 스레드 실행
					
					
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
			System.out.println("스타트 버튼 클릭");
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
			System.out.println("스탑 버튼 클릭");
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
			
			Nickname = dis.readUTF();//사용자의 닉네임을 받는다
			textArea.append(Nickname +"사용자 접속");
			
			
			BroadCast("NewUser/"+Nickname);//기존 사용자에게 자신을 알린다
			
			//자신에게 기존 사용자를 받아오는 부분
			for(int i=0;i<user_vc.size();i++)
			{
				UserInfo u = (UserInfo)user_vc.elementAt(i);
				send_Message("OldUser/"+u.Nickname);
			}
			//자신에게 기존 방 목록을 받아오는 부분
			
			for(int i=0; i<room_vc.size();i++)
			{
				RoomInfo r = (RoomInfo)room_vc.elementAt(i);
				send_Message("OldRoom/"+r.Room_name);
			}
			
			send_Message("room_list_update/ ");
			
			user_vc.add(this);
			
			BroadCast("user_list_update/ ");
			
			
			}catch(IOException e){}
			//JOptionPane.showMessageDialog(null, "Stream설정 에러","알림",JOptionPane.ERROR_MESSAGE);
		}
		public void run()
		{
			while(true)
			{
				try {
					String msg = dis.readUTF();
					textArea.append(Nickname+" 사용자로부터 들어온 메시지 :"+ msg + "\n");
					InMessage(msg);
				} catch (IOException e) {
					textArea.append(Nickname+" : 사용자 접속 끊어짐\n");
					
					try{
					dos.close();
					dis.close();
					user_socket.close();
					user_vc.remove(this);
					BroadCast("User_out/"+Nickname);
					BroadCast("user_list_update/ ");
					}catch(IOException e3){}
					break;
				}//메세지 수신
				
			}
		}
		
		private void InMessage(String str)//클라이언트로부터 들어오는 메시지 처리
		{
			st = new StringTokenizer(str, "/");
			
			
			String protocol = st.nextToken();
			String message = st.nextToken();
			System.out.println("프로토콜 : "+protocol );
			System.out.println("메세지 : "+ message);
			
		
			if(protocol.equals("Note"))
			{
				//protocol = Note
				//message = user
				// note = 받는 내용
				
				//String user = st.nextToken();
				String note = st.nextToken();
				System.out.println("받는 사람:"+message);
				System.out.println("보낼 내용:"+note);
				
				//벡터에서 해당 사용자를 찾아 메세지 전송
				for(int i=0; i<user_vc.size();i++)
				{
					UserInfo u = (UserInfo)user_vc.elementAt(i);
					
					if(u.Nickname.equals(message))
					{
						u.send_Message("Note/"+Nickname+"/"+note);
						//Note/User1/내용
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
					
					if(r.Room_name.equals(message))//해당 방을 찾았을 때
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
						//새로운 사용자 알림
						r.BroadCast_Room("Chatting/알림/******"+Nickname+"님이 입장하셨습니다******");
						//사용자 추가
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
						r.BroadCast_Room("Chatting/알림/******"+Nickname+"님이 퇴장하셨습니다******");
						r.Remove_User(this);
						send_Message("ExitRoom/"+message);
					}
				}
			}
		}
		
		private void BroadCast(String str)
		{
			for(int i=0; i<user_vc.size();i++)//전체 사용자에게 메세지 보내는 부분
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
		public void BroadCast_Room(String str) //현재 방의 모든 사람에게 알린다
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

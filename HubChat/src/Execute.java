import java.awt.Button;
import java.awt.Dialog;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.geom.Ellipse2D;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.swing.JOptionPane;

public class Execute extends Frame implements ActionListener {
	
	private String url = "jdbc:mysql://localhost:3306/hub?useSSL=false";
	private String strUser = "root";
	private String strPassword = "25283122";
	private String strMySQLDriver = "com.mysql.jdbc.Driver";
	
	private Socket socket;
	private String ip;
	private int port;
	private InputStream is;
	private OutputStream os;
	private DataInputStream dis;
	private DataOutputStream dos;
	
	
	Vector user_list = new Vector();
	Vector room_list = new Vector();
	StringTokenizer st;
	
	private String My_Room;
	
	Connection con;
	Statement stmt;
	ResultSet rs;
	String sql;

	String id;
	String pw;
	String name;

	
	Login log = new Login();
	InputIP ipIP = new InputIP();
	SignUp signup = new SignUp();
	Restroom rest = new Restroom();
	UserData d = new UserData();
	ChattingRoomUI chatroom = new ChattingRoomUI();
	Server server = new Server();
	
	Button ok;
	Label msg;
	Dialog info;

	public Execute() {
		try {
			Class.forName(strMySQLDriver);
			con = (Connection) DriverManager.getConnection(url, strUser, strPassword);
			stmt = (Statement) con.createStatement();
		} catch (Exception b) {
			System.out.println("db연결실패");
		}
		
		log.signUp.addActionListener(this);
		signup.btnNew.addActionListener(this);
		log.login.addActionListener(this);
		log.inputIP.addActionListener(this);
		rest.makeroombtn.addActionListener(this);
		rest.joinroombtn.addActionListener(this);
		chatroom.btnchat.addActionListener(this);
		ipIP.btninput.addActionListener(this);
		
		chatroom.textField.addKeyListener
	      (new KeyAdapter() {
	         public void keyPressed(KeyEvent e) {
	           int key = e.getKeyCode();
	           if (key == KeyEvent.VK_ENTER) {
	        	   send_message("Chatting/"+My_Room+"/"+chatroom.textField.getText().trim());
	   			chatroom.textField.setText("");
	   			chatroom.textField.requestFocus();
	              }
	           }
	         }
	      );
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		Object obj = e.getSource();
		if (obj.equals(log.signUp)) 
		{
			signup.setVisible(true);
		} else if (obj.equals(log.login)) 
		{
			
			if(ipIP.textField.getText().length()==0)
			{
				JOptionPane.showMessageDialog(null, "IP를 입력해주세요","login error",JOptionPane.ERROR_MESSAGE);
				ipIP.textField.requestFocus();
			}
			else if(ipIP.textField_1.getText().length()==0)
			{
				JOptionPane.showMessageDialog(null, "Port번호를 입력해주세요","login error",JOptionPane.ERROR_MESSAGE);
				ipIP.textField_1.requestFocus();
			}
			else 
			{
				if(loginCheck())
				{
					log.setVisible(false);
					rest.lbl_IpView.setText(ipIP.textField.getText().trim());
					rest.lbl_IdView.setText(id);
					rest.lbl_NickView.setText(name);
					
					ip = ipIP.textField.getText().trim();
						//"127.0.0.1";
				port = Integer.parseInt(ipIP.textField_1.getText().trim());
				//Integer.parseInt(port_tf.getText().trim());
				id = log.textID.getText().trim();
				Network();	
				}else JOptionPane.showMessageDialog(null, "It's not correct your ID or PW","login error",JOptionPane.ERROR_MESSAGE);
				
			}
		}
		else if (obj.equals(signup.btnNew)) 
		{
			if(selectInsert()==2)
			{	JOptionPane.showMessageDialog(null, "SignUp is complete successfully","sign up complete",JOptionPane.INFORMATION_MESSAGE);
				signup.setVisible(false);
				log.setVisible(true);
			}else if(selectInsert()==1)
			{
				JOptionPane.showMessageDialog(null, "There is blank, check your id,pw,name",id,JOptionPane.ERROR_MESSAGE);
			}else
				JOptionPane.showMessageDialog(null, "This ID is already used",id,JOptionPane.ERROR_MESSAGE);
		} else if(obj.equals(log.inputIP))
		{
			ipIP.setVisible(true);
		}
		else if(e.getSource() == rest.joinroombtn)
		{
			String JoinRoom = (String)rest.Room_list.getSelectedValue();
			
			send_message("JoinRoom/"+JoinRoom);
			
			System.out.println("방 참여 버튼 클릭");
		}else if(e.getSource() == rest.makeroombtn)
		{
			String roomname = JOptionPane.showInputDialog("방 이름");
			if(roomname != null)
			{
				send_message("CreateRoom/"+roomname);
			}
			System.out.println("방 만들기 버튼 클릭");
		}else if(e.getSource() == chatroom.btnchat)
		{
			send_message("Chatting/"+My_Room+"/"+chatroom.textField.getText().trim());
			chatroom.textField.setText("");
			chatroom.textField.requestFocus();
			System.out.println("전송 버튼 클릭");
		}else if(e.getSource() == ipIP.btninput)
		{
			ipIP.setVisible(false);
		}
		
	}

	private int selectInsert() {
		UserData d = new UserData();
		d.id = signup.ID.getText().trim();
		d.pw = signup.PW.getText().trim();
		d.name = signup.NAME.getText().trim();

		String sql = "insert into login value('" + d.id + "','" + d.pw + "','" + d.name + "')";
		
		try {
			if((d.id.equals(""))||(d.pw.equals(""))||(d.name.equals(""))){
			return 1;
			}
			int rss = stmt.executeUpdate(sql);
			System.out.println(rss + "    ");
			return 2;
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}return 3;
	}

	public boolean loginCheck() {
		id = log.textID.getText().trim();
		pw = log.textPW.getText().trim();

		String query = "SELECT pw,name FROM login where id='" + id + "'";
		System.out.println(query);
		try {
			ResultSet rs = stmt.executeQuery(query);

			if (rs.next()) {
				name = rs.getString("name");
				if (pw.equals(rs.getString("pw"))) {
					System.out.println("login");
					rest.setVisible(true);
					return true;
				}
			}
		} catch (Exception b) {
			b.printStackTrace();
		}return false;
	}
	private void Network()
	{
		try {
			socket = new Socket(ip, port);
			
			if(socket!= null)
			{
				Connection();
			}
		} catch (UnknownHostException e) {
			
			JOptionPane.showMessageDialog(null, "연결 실패","알림",JOptionPane.ERROR_MESSAGE);;
		} catch (IOException e) {
			
			JOptionPane.showMessageDialog(null, "연결 실패","알림",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void Connection()
	{
		try{
			is = socket.getInputStream();
			dis = new DataInputStream(is);
		
			os = socket.getOutputStream();
			dos = new DataOutputStream(os);
		}catch(IOException e){
			JOptionPane.showMessageDialog(null, "연결 실패","알림",JOptionPane.ERROR_MESSAGE);
			
		}//stream설정 끝
		
		send_message(id);
		user_list.add(id);

		Thread th = new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(true)
				{
					try {
						String msg = dis.readUTF();//메세지 수신
						System.out.println("서버로부터 수신된 메시지 : "+msg);
						
						inmessage(msg);
					} catch (IOException e) {
						try{
							os.close();
							is.close();
							dos.close();
							dis.close();
							socket.close();
							JOptionPane.showMessageDialog(null, "서버와 접속 끊어짐","알림",JOptionPane.ERROR_MESSAGE);
						}catch(IOException e2){}
						break;
					}
					
				}
				
			}
		});
		th.start();
	}
	
	private void inmessage(String str)//서버로부터 들어오는 모든 메세지
	{
		st = new StringTokenizer(str, "/");
		
		String protocol = st.nextToken();
		String Message = st.nextToken();
		
		System.out.println("프로토콜 : " + protocol);
		System.out.println("내용 : "+Message);
		
		if(protocol.equals("NewUser"))//새로운 접속자
		{
			user_list.add(Message);
		}
		else if(protocol.equals("OldUser"))
		{
			user_list.add(Message);

		}
		else if(protocol.equals("Note"))
		{
			String note = st.nextToken();
			
			System.out.println(Message+"사용자로부터 온 쪽지"+note);
			JOptionPane.showMessageDialog(null, note, Message+"님으로 부터의 쪽지",JOptionPane.CLOSED_OPTION);
		}
		else if(protocol.equals("user_list_update"))
		{
			rest.User_list.setListData(user_list);
		}
		else if(protocol.equals("CreateRoom"))
		{
			My_Room = Message;
			chatroom.setVisible(true);
		}
		else if(protocol.equals("CreateRoomFail"))
		{
			JOptionPane.showMessageDialog(null, "방 만들기 실패","알림",JOptionPane.ERROR_MESSAGE);
		}
		else if(protocol.equals("New_Room"))
		{
			room_list.add(Message);
			rest.Room_list.setListData(room_list);
		}
		else if(protocol.equals("Chatting"))
		{
			String msg = st.nextToken();
			chatroom.textArea.append(Message+" : "+msg+"\n");
			
		}
		
		else if(protocol.equals("OldRoom"))
		{
			room_list.add(Message);
		}
		else if(protocol.equals("room_list_update"))
		{
			rest.Room_list.setListData(room_list);
		}
		else if(protocol.equals("JoinRoom"))
		{
			My_Room = Message;
			rest.setVisible(false);
			chatroom.setVisible(true);
			JOptionPane.showMessageDialog(null, "채팅방에 입장했습니다.","알림",JOptionPane.INFORMATION_MESSAGE);
		}
		else if(protocol.equals("User_out"))
		{
			user_list.remove(Message);
			
		}
		
	}
	
	
	private void send_message(String str)
	{
		try {
			dos.writeUTF(str);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new Execute();

	}
}

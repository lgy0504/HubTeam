package chatServer;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class MsgReceiver extends Thread{
	String nickname;
	Socket socket;
	BufferedReader in;
	
	public MsgReceiver(String nickname, Socket socket)
	{
		this.nickname = "[" + nickname + "] ";
		this.socket = socket;
		try{
			//Connect getInputStream to socket
			in= new BufferedReader(new InputStreamReader(socket.getInputStream()));
		}catch(IOException e){
			System.out.println(e.toString());
		}
	}
	
	public void run()
	{
		while(in != null)
		try{
			//Output to the screen, the received message from the socket.
			System.out.println(in.readLine());	
		}catch(IOException e){
			System.out.println(e.toString());
		}
	}
	
}

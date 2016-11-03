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
			in= new BufferedReader(new InputStreamReader(socket.getInputStream()));
		}catch(IOException e){
			System.out.println(e.toString());
		}
	}
	
	public void run()
	{
		while(in != null)
		try{
			System.out.println(in.readLine());	
		}catch(IOException e){
			System.out.println(e.toString());
		}
	}
	
}

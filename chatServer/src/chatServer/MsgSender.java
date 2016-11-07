package chatServer;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class MsgSender extends Thread {
	String nickname;
	Socket socket;
	PrintWriter out;
	
	public MsgSender(String nickname, Socket socket)
	{
		this.nickname = "[" + nickname + "]";
		this.socket = socket;
		try{
			//Connecting GetOutPutStream to Socket
			out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
		}catch(IOException e){
			System.out.println(e.toString());
		}
	}
	
	public void run(){
		Scanner s = new Scanner(System.in);
		while(out != null){
			//Transfer to send it by prefixing an nickname of the person.
			String msg = s.nextLine();
			out.println(nickname + msg);
			out.flush();
		}
	}
}

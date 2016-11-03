package chatServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class ChatClient {
	Socket socket;
	BufferedReader in;
	PrintWriter out;
	
	public ChatClient(String ip, int port)
	{
		try{
			socket= new Socket(ip, port);
			printInfo();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public void communicate()
	{
		MsgSender sender = new MsgSender("Ŭ���̾�Ʈ",socket);
		MsgReceiver receiver = new MsgReceiver("Ŭ���̾�Ʈ", socket);
		sender.start();
		receiver.start();
	}
	public void close()
	{
		try{
			socket.close();
		}catch(IOException e){
			System.out.println(e.toString());	
		}
	}
	
	public void printInfo()
	{
		System.out.println(">>���� ���ӿ� �����߽��ϴ�.");
		System.out.println("Ŭ���̾�Ʈ ��Ʈ��ȣ : " + socket.getLocalPort());
		System.out.println("���� �ּ� : " + socket.getInetAddress());
		System.out.println("���� ��Ʈ��ȣ : " + socket.getPort() + '\n');
		System.out.println(">>������ ������ �޽����� ���� Enter�� ��������." + 'n');
	}
	
	public static void main(String[] args)
	{
		ChatClient client = new ChatClient("127.0.0.1", 7070);
		client.communicate();
	}

}

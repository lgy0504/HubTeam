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
		//Connect the sender and receiver for the input and output to the client socket
		MsgSender sender = new MsgSender("Client",socket);
		MsgReceiver receiver = new MsgReceiver("Client", socket);
		//Run the thread of the sender and receiver
		sender.start();
		receiver.start();
	}
	public void close()
	{
		try{
			//Exit the client socket
			socket.close();
		}catch(IOException e){
			System.out.println(e.toString());	
		}
	}
	
	public void printInfo()
	{
		System.out.println(">>Server successes to connection.");
		//The service port number and the client's address and port number Output
		System.out.println("Client PortNumber : " + socket.getLocalPort());
		System.out.println("Server Address : " + socket.getInetAddress());
		System.out.println("Server PortNumber : " + socket.getPort() + '\n');
		System.out.println(">>Writing message to server and push the Enter key." + 'n');
	}
	
	public static void main(String[] args)
	{
		//Specifying a server address and port number to connect to the server
		ChatClient client = new ChatClient("127.0.0.1", 7070);
		//Communicating with the server
		client.communicate();
	}

}

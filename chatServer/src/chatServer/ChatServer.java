package chatServer;

import java.io.*;
import java.net.*;

public class ChatServer { 

	int port = 7070;
	ServerSocket server;
	Socket socket;
	
	public ChatServer (int port)
	{
		this.port = port;
		System.out.println(">>Starting the Server.");
		try{
			server = new ServerSocket(port);
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public void communicate()
	{
		System.out.println(">>Waiting for client connection.");
		 try{
			 //Wait for client connecting
			 socket = server.accept();
			 printInfo();
			 //Connect the sender and receiver for the input and output sockets on the server
			 MsgSender sender = new MsgSender("Server",socket);
			 MsgReceiver receiver = new MsgReceiver("Server",socket);
			 //Run the thread of the sender and receiver
			 receiver.start();
			 sender.start();
		 }catch(IOException e){
			 e.printStackTrace();
		 }
	}
	
	public void close(){
		try{
			//Exit the client socket
			socket.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public void printInfo(){
		System.out.println(">>Client successes to connection.");
		//The service port number and the client's address and port number Output
		System.out.println(">>Server PortNumber : " + socket.getLocalPort());
		System.out.println(">>Client Address : " + socket.getInetAddress());
		System.out.println(">>Client PortNumber : " + socket.getPort() + '\n');
		System.out.println(">>Writing message to client and push the Enter key. " + '\n');
	}
	
	public static void main(String[] args)
	{
		int port = 7070;
		ChatServer myServer = new ChatServer(port);
		myServer.communicate();
	}
}


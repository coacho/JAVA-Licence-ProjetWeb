package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
	
	static ArrayList<ClientThread> clients = new ArrayList<ClientThread>();	
	
	private static ServerSocket serverSocket = null;
	private static int portNumber = 8020;
	
	public static void main(String[]args) {
		try {
			serverSocket = new ServerSocket(portNumber);
			acceptClient();
		} catch (IOException e1) {
			System.err.println("problem port: " + portNumber);
			e1.printStackTrace();
			System.exit(1);
			
		}
		
	}
	
	public static void acceptClient() {
		while(true){
			@SuppressWarnings("unused")
			Socket socket = new Socket();
			ClientThread client = new ClientThread(socket);
			Thread thread = new Thread(client);
			thread.start();
			clients.add(client);
			try {
				socket = serverSocket.accept();
			} catch (IOException e) {
				System.err.println("problem port: " + portNumber);
				e.printStackTrace();
			}	
		}
	}
}

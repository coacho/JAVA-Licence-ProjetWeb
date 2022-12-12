package client;

import java.io.IOException;
import java.net.Socket;

import server.Server;

public class Client extends Server implements Runnable {

	private Socket socket;
	
	public Client(Socket socket) {
		// TODO Auto-generated constructor stub
		this.socket=socket;
	}

	public static void main(String[] args)	{
		Socket socket = null;
		int portNumber = 8020;
		
		try {
			socket= new Socket("localhost",portNumber);
		}catch(IOException e) {
			System.err.println("Erreur Connection, port :" + portNumber);
			e.printStackTrace();
		}
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
	
}

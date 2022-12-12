package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ServerThread implements Runnable{
	
	private Socket socket;
	private String username;
	private BufferedReader serverIn;
	private BufferedReader userIn;
	private PrintWriter out;
	
	public ServerThread(Socket socket, String username) {
		// TODO Auto-generated constructor stub
		this.socket = socket;
		this.username = username;
	}

	public static void main(String[] args) {
		int portNumber = 8020;
		
		Socket socket = null;
		System.out.println("Username : <enter here> ");
		Scanner scan = new Scanner(System.in);
		String username = scan.nextLine();
		scan.close();
	}
	
//	public static void main(String[] arg) throws IOException, InterruptedException {
//		Socket socket = null;
//		int portNumber = 8030;
//		
//		Thread.sleep(1000);
//		Thread server = new Thread(new ServerThread(socket));
//		server.start();
//	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
		out = new PrintWriter(socket.getOutputStream(), true);
		serverIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		
		while(!socket.isClosed()) {
			if(serverIn.ready()) {
				String input = serverIn.readLine();
				if(input != null) {
					System.out.println("test :" + input);
				}
				
			}
			if(userIn.ready()) {
				out.println("username : " + userIn.readLine());
			}
			
		}
		
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
}

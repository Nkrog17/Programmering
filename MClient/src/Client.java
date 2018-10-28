import java.net.Socket;
import java.util.Scanner;
import java.io.*;
public class Client {
	public static boolean run = true;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//The IP of the server you want to connect to
		String IP = "192.168.43.228";
		//The port of the server you want to connect to
		int port = 6000;
		
		
		try {
			
			//Allocates the IP adress and Port Number to the socket
			Socket socket = new Socket(IP, port);
			
			//Lets the application read and send data through datastreams
			DataInputStream fromServer = new DataInputStream(socket.getInputStream());
			DataOutputStream toServer = new DataOutputStream(socket.getOutputStream());
			
			// Function that takes in the users input in the console and saves it as the username and sends it to the server
			System.out.println("What would you like to call yourself:");
			String username = sc.nextLine();
			toServer.writeUTF(username);
			System.out.print("> ");
			
			// The first thread in the client that takes input from the server
			new Thread( () -> {
				while (true) {
					try {
						System.out.println(fromServer.readUTF());
						
						

						System.out.print("> ");
					} catch (IOException e) {
						e.printStackTrace();
						
					}
				}
			}).start();
			
			// The second thread in the client that sends input in the console to the server and contains the /quit function that terminates the program 
			new Thread( () -> {
				while (true) {
					try {
						String message = sc.nextLine();						
						toServer.writeUTF(message);
						if(message.equals("/quit")) {
							System.exit(0);
						}
					} catch (IOException e) {
						e.printStackTrace();
						break;
					}
				}
			}).start();
			
			
		}catch(Exception e){}
	}

}
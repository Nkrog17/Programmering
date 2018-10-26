import java.net.Socket;
import java.util.Scanner;
import java.io.*;
public class Client {
	public static boolean run = true;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//System.out.println("Type the IP of the server you want to connect to: ");
		String IP = "192.168.43.228"; //sc.next();
		//System.out.println("Type the port of the server you want to connect to: ");
		int port = 5000;//sc.nextInt();
		
		
		try {
		
			Socket socket = new Socket(IP, port);
			
			DataInputStream fromServer = new DataInputStream(socket.getInputStream());
			DataOutputStream toServer = new DataOutputStream(socket.getOutputStream());
			
			System.out.println("What would you like to call yourself:");
			String username = sc.nextLine();
			toServer.writeUTF(username);
			System.out.print("> ");

			new Thread( () -> {
				while (true) {
					try {
						System.out.println(fromServer.readUTF());
						
						

						System.out.print("> ");
						//System.out.println("");
					} catch (IOException e) {
						e.printStackTrace();
						
					}
				}
			}).start();
			
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
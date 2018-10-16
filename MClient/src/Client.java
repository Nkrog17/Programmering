import java.net.Socket;
import java.util.Scanner;
import java.io.*;
public class Client {
	public static boolean run = true;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		try {
		
			Socket socket = new Socket("192.168.43.193", 8800);
			
			DataInputStream fromServer = new DataInputStream(socket.getInputStream());
			DataOutputStream toServer = new DataOutputStream(socket.getOutputStream());
			
			System.out.println("What would you like to call yourself:");
			String username = sc.next();
			toServer.writeUTF(username);

			new Thread( () -> {
				while (true) {
					try {
						System.out.println(fromServer.readUTF());
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}).start();
			
			new Thread( () -> {
				while (true) {
					try {
						System.out.println("> ");
						String message = sc.next();
						toServer.writeUTF(message);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}).start();
			
			
		}catch(Exception e){}
		
	}

}

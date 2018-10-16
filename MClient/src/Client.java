import java.net.Socket;
import java.util.Scanner;
import java.io.*;
public class Client {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
	
		try {
			
			Socket socket = new Socket("192.168.43.193", 7000);
			DataInputStream fromServer = new DataInputStream(socket.getInputStream());
			DataOutputStream toServer = new DataOutputStream(socket.getOutputStream());

			while(true) {
				System.out.println("Welcome to the Lobby");
				//FROMSERVER INTRO PRINT HER
				
				//Client name from user input
				System.out.println("What would you like to call yourself:");
				String playerName = sc.next();
				//Sends client name to the server
				toServer.writeUTF(playerName);
				//emString sPlayerName = fromServer.readUTF();
				System.out.println(playerName+" has joined the Lobby");
		
				
				
				
				//Quit game function	
				if(sc.next().equals("quit")) {
				System.out.println("Would like to quit the menu, type 'quit'");
				
				String clientAnswer = sc.next();
				if(clientAnswer.equals("quit")) {
					System.out.println("You have left the lobby");
					break;		
					}
				}
			}
			
			
		}catch(Exception e){}
		
	}

}

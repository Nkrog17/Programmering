import java.net.Socket;
import java.util.Scanner;
import java.io.*;
public class Client {
	public static boolean run = true;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Menu menu1 = new Menu();
		
		try {
			
			Socket socket = new Socket("192.168.43.193", 7000);
			DataInputStream fromServer = new DataInputStream(socket.getInputStream());
			DataOutputStream toServer = new DataOutputStream(socket.getOutputStream());

			while(run) {
				System.out.println(fromServer.readUTF());
				//FROMSERVER INTRO PRINT HER
				
				//Client name from user input
				System.out.println("What would you like to call yourself:");
				String playerName = sc.next();
				//Sends client name to the server
				toServer.writeUTF(playerName);
				//emString sPlayerName = fromServer.readUTF();
				System.out.println(fromServer.readUTF());
				//
				menu1.startGame();
				
				//Quit game function	
				menu1.quitMenu();
			}
			
			
		}catch(Exception e){}
		
	}

}
import java.util.Scanner;
import java.io.*;

public class Menu extends Client  {
	Scanner sc1 = new Scanner (System.in);
	public int i = 0;

	void startGame() {
		
		System.out.println("Hello");
		if(sc1.next().equals("xd")) {
			System.out.println("gj");
		}
		
	}
	void quitMenu() {
		
		if(sc1.next().equals("quit")) {
			System.out.println("Would like to quit the menu, type 'quit'");
			
			String clientAnswer = sc1.next();
			if(clientAnswer.equals("quit")) {
				System.out.println("You have left the lobby");
				Client.run = false;		
				}
			}
	}

	void lobbyReady() {
		if(sc1.next().equals("ready")) {
			System.out.println("You are ready.");
			i = 1;
			
		}
	}
	
}

package game;

import user.UserProfile;

public class Main {

	public static void main(String[] args) {
		Client clientGame = new Client();

		clientGame.run();
		
		System.out.println("\nTerminating Program...");
	}
}

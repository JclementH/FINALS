package game;

import user.UserProfile;

public class Main {

	public static void main(String[] args) {
		Client clientGame = new Client();
		UserProfile user = new UserProfile();
		Client.setUserProfile(user);

		clientGame.run();
		
		System.out.println("\nTerminating Program...");
	}
}

package game;

import java.io.*;
import java.net.URL;
import java.util.Objects;
import java.util.Scanner;

import user.UserProfile;


public class Client {
	// Data fields
	private static String versionID;
	private static String gameName;
	private static UserProfile userProfile;
		
	// Methods
	public Client() {
		this("BETA 0.1", "Battle Monsters");
	}
	
	public Client(String ID, String name) {
		versionID = ID;
		gameName = name;
	}
	
	public void run() {
		info();
		//Before game starts, check if user has a record. Otherwise, create new one.
		while (true) {
			//File paths
			String projectDirectory = System.getProperty("user.dir");
			String userSavePath = projectDirectory + "\\src\\files\\user_saved";

			try {
				File user = new File(userSavePath);
				if (!user.exists()) {
					FileOutputStream userFile = new FileOutputStream(user);
					ObjectOutputStream newUser = new ObjectOutputStream(userFile);
					newUser.writeObject(userProfile);
					newUser.close();
					System.out.println("User profile object saved");
				} else {
					System.out.println("There's already an existing file.");
					FileInputStream userFile = new FileInputStream(user);
					ObjectInputStream userSave = new ObjectInputStream(userFile);
					System.out.println(userSave.readObject());
					userSave.close();
					System.out.println("User profile object saved");
				}	
			} catch (Exception e) {
				System.out.println("An error has occurred.");
				e.printStackTrace();
			}
			break; // TEMP BREAK! REMOVE WHEN EDITING
		}
	}
	
		
	private void info() {
		System.out.println(getGameName()+"\nVersion ID: "+getVersionID());
	}
	
	private void showMainMenu() {
		
	}
	
	private void searchOpponent() {
		
	}
	
	private void initiateBattle() {
		
	}

	// Setters and Getters
	public void setVersionID(String ID) {
		versionID = ID;
	}
	
	public String getVersionID() {
		return versionID;
	}
	
	public void setGameName(String name) {
		gameName = name;
	}

	public static void setUserProfile(UserProfile user) {
		userProfile = user;
	}
	
	public String getGameName() {
		return gameName;
	}


	public UserProfile getUserProfile() {
		return userProfile;
	}
}

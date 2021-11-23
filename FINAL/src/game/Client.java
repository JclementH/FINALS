package game;

import java.io.*;
import java.net.URL;
import java.util.Objects;
import java.util.Scanner;

import files.SaveFile;
import user.UserProfile;


public class Client {
	// Data fields
	private static String versionID;
	private static String gameName;
		
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
		//Before game starts, check if user has file. Otherwise, create new one.
		while (true) {
			//File paths
			String projectDirectory = System.getProperty("user.dir");
			String clientSavePath = projectDirectory + "\\src\\files\\client_save.txt";

			try {
				File clientSave = new File(clientSavePath);
				if (!clientSave.exists()) {
					SaveFile saveFile = new SaveFile();

					FileOutputStream clientSaveFile = new FileOutputStream(clientSave);
					ObjectOutputStream newClientSave = new ObjectOutputStream(clientSaveFile);
					newClientSave.writeObject(saveFile.toString());
					newClientSave.close();
					System.out.println("User profile object saved.");
				} else {
					System.out.println("There's already an existing file.");
					try {
						String line;
						int i = 0;
						boolean hasPassedTutorial = true;
						//Read object
						FileInputStream clientSaveFile = new FileInputStream(clientSave);
						BufferedReader clientSaveObject = new BufferedReader(new InputStreamReader(clientSaveFile));
						System.out.println(clientSaveObject.readLine());

						while((line = clientSaveObject.readLine()) != null) {
							System.out.println(line);
							//Check if user has passed the tutorial
							if(i == 0) {
								String[] value = line.split(" = ");
								if(value[1].equals("false")) {
									hasPassedTutorial = false;
								}
							}
							i++;
						}

						if(!hasPassedTutorial) {
							System.out.println("User has not passed the tutorial.");
							openTutorial();
						}
						//Close object
						clientSaveObject.close();
					} catch (Exception e) {
						System.out.println("An error has occurred.");
						e.printStackTrace();
					}
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

	private void openTutorial() {
		System.out.println("Commencing tutorial kunuhay");
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
	
	public String getGameName() {
		return gameName;
	}
}

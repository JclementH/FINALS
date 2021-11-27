package game;

import files.SaveFile;
import user.UserMonster;
import user.UserProfile;

import java.io.*;


public class Client {
	// Data fields
	private static String versionID;
	private static String gameName;
	private SaveFile saveFile;
		
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
					this.saveFile = saveFile;
				} else {
					System.out.println("There's already an existing file.");
				}
				//Read File
				try {
					boolean hasPassedTutorial = getSaveFile(); //retrieve save file
					//Show main menu
					showMainMenu(hasPassedTutorial);
				} catch (Exception e) {
					System.out.println("An error has occurred.");
					e.printStackTrace();
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
	
	private void showMainMenu(boolean hasPassedTutorial) {
		System.out.println("==================================================================\r\nMAIN MENU");
		boolean fightButton = true; // BUTTON MAY NOT BE IMPLEMENTED AS A BOOLEAN. TESTING fightButtonMethod() METHOD.
		if(fightButton && hasPassedTutorial) fightButtonMethod();
		if(fightButton && !hasPassedTutorial) commenceTutorial();

		updateFile(); //Always update file
	}

	private void showMap() {
		System.out.println("Map shown. Naay \"GO\" button sa ubos");
		updateFile(); //Always update file
	}

	private void showPlayerMonster() {
		System.out.println("(Player) monster shown. Mga stats sa monster naa diri");
		updateFile(); //Always update file
	}

	public boolean getSaveFile() {
		String projectDirectory = System.getProperty("user.dir");
		String clientSavePath = projectDirectory + "\\src\\files\\client_save.txt";

		String line;
		int i = 0;
		boolean hasPassedTutorial = true;

		try {
			File clientSave = new File(clientSavePath);
			//Read object
			FileInputStream clientSaveFile = new FileInputStream(clientSave);
			BufferedReader clientSaveObject = new BufferedReader(new InputStreamReader(clientSaveFile));
			System.out.println(clientSaveObject.readLine());
			SaveFile tempSaveFileVar = new SaveFile();
			UserProfile tempUserProfileVar = new UserProfile();
			UserMonster tempUserMonsterVar = new UserMonster();

			while((line = clientSaveObject.readLine()) != null) {
				System.out.println(line);
				//Check if user has passed the tutorial
				if(i == 0) {
					String[] value = line.split(" = ");
					if(value[1].equals("false")) {
						hasPassedTutorial = false;
					}
					tempSaveFileVar.setTutorialPassed(hasPassedTutorial);
				}
				if(i == 1 && !hasPassedTutorial) {
					String[] value = line.split(" = ");
					if(value[1].equals("no profile yet")) {
						tempSaveFileVar.setUserProfile(null);
					}
				}
				if(i == 3) {
					String[] value = line.split(": ");
					tempUserProfileVar.setGold(Integer.parseInt(value[1]));
				}
				if(i == 7) {
					String[] value = line.split(": ");
					tempUserMonsterVar.setStats(Integer.parseInt(value[1]));
				}
				if(i == 8) {
					String[] value = line.split(": ");
					tempUserMonsterVar.setWins(Integer.parseInt(value[1]));
				}
				if(i == 9) {
					String[] value = line.split(": ");
					tempUserMonsterVar.setLoss(Integer.parseInt(value[1]));
				}
				if(i == 10) {
					String[] value = line.split(": ");
					tempUserMonsterVar.setName(value[1]);
				}
				if(i == 11) {
					String[] value = line.split(": ");
					tempUserMonsterVar.setNick(value[1]);
				}
				if(i == 12) {
					String[] value = line.split(": ");
					tempUserMonsterVar.setGuiPictureCode(value[1]);
				}
				if(i == 13) {
					String[] value = line.split(": ");
					tempUserMonsterVar.setMonsterType(value[1]);
				}
				i++;
			}
			tempUserProfileVar.setPlayerMonster(tempUserMonsterVar);
			tempSaveFileVar.setUserProfile(tempUserProfileVar);
			this.saveFile = tempSaveFileVar;
			//Close Object
			clientSaveObject.close();
		} catch (Exception e) {
			System.out.println("An error has occurred.");
			e.printStackTrace();
		}
		return hasPassedTutorial;
	}

	private void showShop() {
		System.out.println("Shop shown. Naa diri mga baligya");
		updateFile(); //Always update file
	}

	private void commenceTutorial() {
		UserProfile user = new UserProfile();
		boolean reachedEnd = true;

		System.out.println("Commencing tutorial kunuhay");

		if(reachedEnd) {
			System.out.println("Reached end of tutorial");
			this.saveFile.setUserProfile(user);
			this.saveFile.setTutorialPassed(true);
			updateFile(); //Always update file
		}
	}

	private void updateFile() {
		String projectDirectory = System.getProperty("user.dir");
		String clientSavePath = projectDirectory + "\\src\\files\\client_save.txt";

		try {
			File clientSave = new File(clientSavePath);
			if(clientSave.exists()) {
				FileOutputStream clientSaveFile = new FileOutputStream(clientSave);
				ObjectOutputStream newClientSave = new ObjectOutputStream(clientSaveFile);
				newClientSave.writeObject(this.saveFile.toString());
				newClientSave.close();
			}
		} catch (Exception e) {
			System.out.println("An error has occurred.");
			e.printStackTrace();
		}
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

	//button methods
	//Main menu buttons
	public void fightButtonMethod() {
		System.out.println("Fight Button");
		showMap();
	}

	public void monsterButtonMethod() {
		System.out.println("Monster Button");
	}

	public void shopButtonMethod() {
		System.out.println("Shop Button");
	}
	//Misc buttons
	public void backButtonMethod() {
		System.out.println("Back Button");
	}
}

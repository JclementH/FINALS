package monsters;

public class Monster {
	protected int stats;
	protected String name;
	protected String guiPictureCode;
	protected String monsterType;
	
	
	public Monster(){
		setStats(100);
		setName("NGALAN");
		setGuiPictureCode("N/A");
		setMonsterType("Normal");
	}

	public void setStats(int stats) {
		this.stats = stats;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setGuiPictureCode(String guiPictureCode) {
		this.guiPictureCode = guiPictureCode;
	}
	public void setMonsterType(String monsterType) {
		this.monsterType = monsterType;
	}

}

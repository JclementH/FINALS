package user;

import java.io.Serializable;

public class UserProfile implements Serializable {
	int gold;
	UserMonster playerMonster;
	
	public UserProfile(){
		this(100, new UserMonster());
	}
	
	UserProfile(int g, UserMonster m){
		gold = g;
		playerMonster = m;
	}

	public void setPlayerMonster(UserMonster playerMonster) {
		this.playerMonster = playerMonster;
	}

	public void setGold(int gold) {
		this.gold = gold;
	}

	public UserMonster getPlayerMonster() {
		return playerMonster;
	}

	public int getGold() {
		return gold;
	}

	@Override
	public String toString() {
		return " :\r\n\r\n\tGold: " + this.gold +
				"\r\n\tPlayer_Monster: \r\n\r\n" + this.playerMonster;
	}
}

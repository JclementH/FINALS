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

	@Override
	public String toString() {
		return "Gold: " + this.gold +
				"\r\nPlayer_Monster: " + this.playerMonster;
	}
}

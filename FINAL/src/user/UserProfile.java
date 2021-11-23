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
		return " :\r\n\r\n\tGold: " + this.gold + "G" +
				"\r\n\tPlayer_Monster: \r\n\r\n" + this.playerMonster;
	}
}

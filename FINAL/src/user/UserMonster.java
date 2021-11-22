package user;

import monsters.Monster;

import java.io.Serializable;

public class UserMonster extends Monster implements Serializable {
	private int wins;
	private int loss;
	private String nick;

	public UserMonster(){
		setWins(10);
		setLoss(0);
		setNick("ANGGA");
	}

	public void setWins(int wins) {
		this.wins = wins;
	}

	public void setLoss(int loss) {
		this.loss = loss;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	@Override
	public String toString() {
		return "\r\nmonster.Stats          : " + this.stats +
				"\r\nmonster.Wins           : " + this.wins +
				"\r\nmonster.Loss           : " + this.loss +
				"\r\nmonster.Name           : " + this.name +
				"\r\nmonster.Nickname       : " + this.nick +
				"\r\nmonster.guiPictureCode : " + this.guiPictureCode +
				"\r\nmonster.monsterType    : " + this.monsterType;
	}
}

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

	public int getLoss() {
		return loss;
	}

	@Override
	public String toString() {
		return "\r\n\t\tplayer_monster.Stats          : " + this.stats +
				"\r\n\t\tplayer_monster.Wins           : " + this.wins +
				"\r\n\t\tplayer_monster.Loss           : " + this.loss +
				"\r\n\t\tplayer_monster.Name           : " + this.name +
				"\r\n\t\tplayer_monster.Nickname       : " + this.nick +
				"\r\n\t\tplayer_monster.guiPictureCode : " + this.guiPictureCode +
				"\r\n\t\tplayer_monster.monsterType    : " + this.monsterType;
	}
}

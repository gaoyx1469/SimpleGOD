package top.trial.hibernate;

import java.io.Serializable;

public class GameEntity implements Serializable {
	private Integer gid;
	private String gameName;
	private String gameDescribe;

	public GameEntity(String gameName, String gameDescribe) {
		this.gameName = gameName;
		this.gameDescribe = gameDescribe;
	}

	public GameEntity() {
	}

	public Integer getGid() {
		return gid;
	}

	public void setGid(Integer gid) {
		this.gid = gid;
	}

	public String getGameName() {
		return gameName;
	}

	public void setGameName(String gameName) {
		this.gameName = gameName;
	}

	public String getGameDescribe() {
		return gameDescribe;
	}

	public void setGameDescribe(String gameDescribe) {
		this.gameDescribe = gameDescribe;
	}

	@Override
	public String toString() {
		return "GameEntity [gid=" + gid + ", gameName=" + gameName + ", gameDescribe=" + gameDescribe + "]";
	}

}

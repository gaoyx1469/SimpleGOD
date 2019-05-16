package top.trial.demo.entity;

public class UserLoginEntity {
	private String name;// ����
	private String password;// ����
	private String nickname;// ����

	public UserLoginEntity() {
		super();
	}

	public UserLoginEntity(String name, String password, String nickname) {
		super();
		this.name = name;
		this.password = password;
		this.nickname = nickname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

}

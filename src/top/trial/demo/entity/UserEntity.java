package top.trial.demo.entity;

import java.util.Arrays;
import java.util.Date;

/**
 * �û�ע����Ϣʵ����
 * 
 * @author ������
 *
 */
public class UserEntity {

	private String name;// ����
	private String password;// ����
	private Date birthday;// ����
	private int age;// ����
	private int level;// �ȼ�
	private String gender;// �Ա�
	private boolean married;// ���
	private String[] hobby;// ��Ȥ
	private String homecity;// ����
	private String description;// ���

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

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public boolean isMarried() {
		return married;
	}

	public void setMarried(boolean married) {
		this.married = married;
	}

	public String[] getHobby() {
		return hobby;
	}

	public void setHobby(String[] hobby) {
		this.hobby = hobby;
	}

	public String getHomecity() {
		return homecity;
	}

	public void setHomecity(String homecity) {
		this.homecity = homecity;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "UserEtity [name=" + name + ", password=" + password + ", birthday=" + birthday + ", age=" + age
				+ ", level=" + level + ", gender=" + gender + ", married=" + married + ", hobby="
				+ Arrays.toString(hobby) + ", homecity=" + homecity + ", description=" + description + "]";
	}

}

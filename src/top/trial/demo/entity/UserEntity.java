package top.trial.demo.entity;

import java.util.Arrays;
import java.util.Date;

/**
 * 用户注册信息实体类
 * 
 * @author Gaoyx
 *
 */
public class UserEntity {

	private String name;// 姓名
	private String password;// 密码
	private Date birthday;// 生日
	private int age;// 年龄
	private int level;// 等级
	private String gender;// 性别
	private boolean married;// 婚否
	private String[] hobby;// 兴趣
	private String homecity;// 籍贯
	private String description;// 简介

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

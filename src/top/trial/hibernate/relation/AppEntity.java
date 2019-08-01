package top.trial.hibernate.relation;

import java.util.Set;

/**
 * APP实体，作为hibernate多对多关系测试的一方
 * 
 * @author Gaoyx
 *
 */
public class AppEntity {
	private Integer appid;
	private String appName;
	private String appDescription;
	private Set<UserEntity> users;

	public Integer getAppid() {
		return appid;
	}

	public void setAppid(Integer appid) {
		this.appid = appid;
	}

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public String getAppDescription() {
		return appDescription;
	}

	public void setAppDescription(String appDescription) {
		this.appDescription = appDescription;
	}

	public Set<UserEntity> getUsers() {
		return users;
	}

	public void setUsers(Set<UserEntity> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "AppEntity [appid=" + appid + ", appName=" + appName + ", appDescription=" + appDescription + ", users="
				+ users + "]";
	}

}

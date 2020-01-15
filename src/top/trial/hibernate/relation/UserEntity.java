package top.trial.hibernate.relation;

import java.util.Set;

/**
 * 用户实体，作为hibernate多对多关系测试的一方
 * 
 * @author Gaoyx
 *
 */
public class UserEntity {
	private Integer userid;
	private String userName;
	private String userDescription;
	private Set<AppEntity> apps;

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserDescription() {
		return userDescription;
	}

	public void setUserDescription(String userDescription) {
		this.userDescription = userDescription;
	}

	public Set<AppEntity> getApps() {
		return apps;
	}

	public void setApps(Set<AppEntity> apps) {
		this.apps = apps;
	}

	@Override
	public String toString() {
		return "UserEntity [userid=" + userid + ", userName=" + userName + ", userDescription=" + userDescription
				+ ", apps=" + apps + "]";
	}

}

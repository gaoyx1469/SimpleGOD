package top.trial.demo.dao.impl;

import top.trial.demo.dao.UserOperaterDao;
import top.trial.demo.entity.UserDomain;

public class UserOperaterDaoImpl implements UserOperaterDao {

	@Override
	public boolean addUser() {
		System.out.println("UserOperaterDaoImpl:	调用addUser()成功");
		return true;
	}

	@Override
	public boolean deleteUser() {
		System.out.println("UserOperaterDaoImpl:	调用deleteUser()成功");
		return true;
	}

	@Override
	public UserDomain getUser() {
		UserDomain ud = new UserDomain();
		ud.setUserId(001);
		ud.setUsername("演示用户一");
		System.out.println("UserOperaterDaoImpl:	调用getUser()成功");
		return ud;
	}

}

package top.trial.demo.dao.impl;

import top.trial.demo.dao.UserOperaterDao;
import top.trial.demo.entity.UserDomain;

public class UserOperaterDaoImpl implements UserOperaterDao {

	@Override
	public boolean addUser() {
		System.out.println("UserOperaterDaoImpl:	����addUser()�ɹ�");
		return true;
	}

	@Override
	public boolean deleteUser() {
		System.out.println("UserOperaterDaoImpl:	����deleteUser()�ɹ�");
		return true;
	}

	@Override
	public UserDomain getUser() {
		UserDomain ud = new UserDomain();
		ud.setUserId(001);
		ud.setUsername("��ʾ�û�һ");
		System.out.println("UserOperaterDaoImpl:	����getUser()�ɹ�");
		return ud;
	}

}

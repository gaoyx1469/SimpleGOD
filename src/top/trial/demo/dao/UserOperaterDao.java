package top.trial.demo.dao;

import top.trial.demo.entity.UserDomain;

/**
 * ������Ϊһ��Demo�ӿڣ�Ϊ����trial�ṩ�ӿ�����ʵ��
 * 
 * @author Gaoyx
 *
 */
public interface UserOperaterDao {

	public boolean addUser();

	public boolean deleteUser();

	public UserDomain getUser();

}

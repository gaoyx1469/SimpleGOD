package top.trial.demo.dao;

import top.trail.demo.entity.UserDomain;

/**
 * ������Ϊһ��Demo�ӿڣ�Ϊ����trial�ṩ�ӿ�����ʵ��
 * 
 * @author ������
 *
 */
public interface UserOperaterDao {

	public boolean addUser();

	public boolean deleteUser();

	public UserDomain getUser();

}

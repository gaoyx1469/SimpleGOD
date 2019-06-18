package top.trial.demo.dao;

import top.trial.demo.entity.UserDomain;

/**
 * 此类作为一个Demo接口，为各个trial提供接口引用实例
 * 
 * @author Gaoyx
 *
 */
public interface UserOperaterDao {

	public boolean addUser();

	public boolean deleteUser();

	public UserDomain getUser();

}

package top.trial.demo.dao;

import top.trail.demo.entity.UserDomain;

/**
 * 此类作为一个Demo接口，为各个trial提供接口引用实例
 * 
 * @author 高宇翔
 *
 */
public interface UserOperaterDao {

	public boolean addUser();

	public boolean deleteUser();

	public UserDomain getUser();

}

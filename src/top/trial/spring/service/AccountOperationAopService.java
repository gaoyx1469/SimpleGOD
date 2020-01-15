package top.trial.spring.service;

public interface AccountOperationAopService {

	/**
	 * 模拟账户保存操作，无参数无返回
	 */
	public void saveAccount();

	/**
	 * 模拟账户更新操作，有参数无返回
	 * 
	 * @param id
	 */
	public void updateAccount(int id);

	/**
	 * 模拟账户删除操作，有参数又反悔
	 * 
	 * @param id
	 * @return
	 */
	public int deleteAccount(int id);
}

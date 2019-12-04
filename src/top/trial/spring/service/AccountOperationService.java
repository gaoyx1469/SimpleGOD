package top.trial.spring.service;

import java.math.BigDecimal;
import java.util.List;

import top.trial.spring.SpringAccountBean;

public interface AccountOperationService {

	void addAccount(SpringAccountBean accountBean);

	void updateAccount(SpringAccountBean accountBean);

	void deleteAccount(int accountId);

	SpringAccountBean getAccountById(int accountId);

	List<SpringAccountBean> getAllAccounts();

	/**
	 * 演示转账过程，无事务版本
	 * 
	 * @param sourceId
	 *            转出方ID
	 * @param targetId
	 *            转入方ID
	 * @param amount
	 *            转账金额
	 */
	void transfer(int sourceId, int targetId, BigDecimal amount);

	/**
	 * 演示转账过程，有事务版本,借助TransactionUtil进行连接相关操作，在service层开启事务获取连接，将连接传到dao层，
	 * dbutils的queryRunner对象调用方法时传入指定连接。代码冗余严重，使用动态代理可优化
	 * 
	 * @param sourceId
	 *            转出方ID
	 * @param targetId
	 *            转入方ID
	 * @param amount
	 *            转账金额
	 */
	void transferTransaction(int sourceId, int targetId, BigDecimal amount);
}

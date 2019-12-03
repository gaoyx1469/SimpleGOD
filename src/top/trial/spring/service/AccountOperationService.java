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
}

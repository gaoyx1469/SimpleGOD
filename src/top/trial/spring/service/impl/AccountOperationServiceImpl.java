package top.trial.spring.service.impl;

import java.math.BigDecimal;
import java.util.List;

import top.trial.spring.SpringAccountBean;
import top.trial.spring.dao.AccountOperationDao;
import top.trial.spring.dao.impl.AccountOperationDaoImpl;
import top.trial.spring.service.AccountOperationService;

public class AccountOperationServiceImpl implements AccountOperationService {

	// 此处可注入
	AccountOperationDao accountOperationDao = new AccountOperationDaoImpl();

	@Override
	public void addAccount(SpringAccountBean accountBean) {
		accountOperationDao.addAccount(accountBean);
	}

	@Override
	public void updateAccount(SpringAccountBean accountBean) {
		accountOperationDao.updateAccount(accountBean);
	}

	@Override
	public void deleteAccount(int accountId) {
		accountOperationDao.deleteAccount(accountId);
	}

	@Override
	public SpringAccountBean getAccountById(int accountId) {
		return accountOperationDao.getAccountById(accountId);
	}

	@Override
	public List<SpringAccountBean> getAllAccounts() {
		return accountOperationDao.getAllAccounts();
	}

	@Override
	public void transfer(int sourceId, int targetId, BigDecimal amount) {
		// 查转出账户信息
		SpringAccountBean sourceAccount = accountOperationDao.getAccountById(sourceId);
		// 转出账户余额判断
		if (sourceAccount.getSat_value().compareTo(amount) == -1) {
			// 金额不足
			throw new RuntimeException("账户余额不足");
		}
		// 查转入账户信息
		SpringAccountBean targetAccount = accountOperationDao.getAccountById(targetId);
		// 计算转出账户金额
		BigDecimal sourceAmount = sourceAccount.getSat_value().subtract(amount);
		// 计算转入账户金额
		BigDecimal targetAmount = targetAccount.getSat_value().add(amount);
		// 更新转出账户金额
		sourceAccount.setSat_value(sourceAmount);
		accountOperationDao.updateAccount(sourceAccount);
		// 更新转入账户金额
		targetAccount.setSat_value(targetAmount);
		accountOperationDao.updateAccount(targetAccount);
	}

}

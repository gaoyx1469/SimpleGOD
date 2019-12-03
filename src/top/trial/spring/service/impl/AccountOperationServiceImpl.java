package top.trial.spring.service.impl;

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

}

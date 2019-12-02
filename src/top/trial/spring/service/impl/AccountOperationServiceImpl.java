package top.trial.spring.service.impl;

import top.trial.spring.SpringAccountBean;
import top.trial.spring.dao.AccountOperationDao;
import top.trial.spring.service.AccountOperationService;

public class AccountOperationServiceImpl implements AccountOperationService {

	AccountOperationDao accountOperationDao;
	
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
	public void getAccountById(int accountId) {
		accountOperationDao.getAccountById(accountId);
	}

	@Override
	public void getAllAccounts() {
		accountOperationDao.getAllAccounts();
	}

}

package top.trial.spring.dao;

import top.trial.spring.SpringAccountBean;

public interface AccountOperationDao {

	void addAccount(SpringAccountBean accountBean);

	void updateAccount(SpringAccountBean accountBean);

	void deleteAccount(int accountId);

	void getAccountById(int accountId);

	void getAllAccounts();

}

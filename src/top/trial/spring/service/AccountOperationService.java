package top.trial.spring.service;

import top.trial.spring.SpringAccountBean;

public interface AccountOperationService {

	void addAccount(SpringAccountBean accountBean);

	void updateAccount(SpringAccountBean accountBean);

	void deleteAccount(int accountId);

	void getAccountById(int accountId);

	void getAllAccounts();
}

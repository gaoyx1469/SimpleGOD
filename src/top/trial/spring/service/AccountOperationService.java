package top.trial.spring.service;

import java.util.List;

import top.trial.spring.SpringAccountBean;

public interface AccountOperationService {

	void addAccount(SpringAccountBean accountBean);

	void updateAccount(SpringAccountBean accountBean);

	void deleteAccount(int accountId);

	SpringAccountBean getAccountById(int accountId);

	List<SpringAccountBean> getAllAccounts();
}

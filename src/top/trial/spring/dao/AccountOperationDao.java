package top.trial.spring.dao;

import java.util.List;

import top.trial.spring.SpringAccountBean;

public interface AccountOperationDao {

	void addAccount(SpringAccountBean accountBean);

	void updateAccount(SpringAccountBean accountBean);

	void deleteAccount(int accountId);

	SpringAccountBean getAccountById(int accountId);

	List<SpringAccountBean> getAllAccounts();

}

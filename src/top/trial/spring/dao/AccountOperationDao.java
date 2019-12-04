package top.trial.spring.dao;

import java.sql.Connection;
import java.util.List;

import top.trial.spring.SpringAccountBean;

public interface AccountOperationDao {

	void addAccount(SpringAccountBean accountBean);

	void updateAccount(SpringAccountBean accountBean);

	void updateAccount(SpringAccountBean accountBean, Connection conn);

	void deleteAccount(int accountId);

	SpringAccountBean getAccountById(int accountId);

	SpringAccountBean getAccountById(int accountId, Connection conn);

	List<SpringAccountBean> getAllAccounts();

}

package top.trial.spring.service.impl;

import java.math.BigDecimal;
import java.util.List;

import top.trial.spring.SpringAccountBean;
import top.trial.spring.dao.AccountOperationDao;
import top.trial.spring.dao.impl.AccountOperationDaoImpl;
import top.trial.spring.service.AccountOperationService;

public class AccountOperationServiceImpl implements AccountOperationService {

	// �˴���ע��
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
		// ��ת���˻���Ϣ
		SpringAccountBean sourceAccount = accountOperationDao.getAccountById(sourceId);
		// ת���˻�����ж�
		if (sourceAccount.getSat_value().compareTo(amount) == -1) {
			// ����
			throw new RuntimeException("�˻�����");
		}
		// ��ת���˻���Ϣ
		SpringAccountBean targetAccount = accountOperationDao.getAccountById(targetId);
		// ����ת���˻����
		BigDecimal sourceAmount = sourceAccount.getSat_value().subtract(amount);
		// ����ת���˻����
		BigDecimal targetAmount = targetAccount.getSat_value().add(amount);
		// ����ת���˻����
		sourceAccount.setSat_value(sourceAmount);
		accountOperationDao.updateAccount(sourceAccount);
		// ����ת���˻����
		targetAccount.setSat_value(targetAmount);
		accountOperationDao.updateAccount(targetAccount);
	}

}

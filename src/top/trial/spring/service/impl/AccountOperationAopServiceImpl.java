package top.trial.spring.service.impl;

import top.trial.spring.service.AccountOperationAopService;

public class AccountOperationAopServiceImpl implements AccountOperationAopService {

	@Override
	public void saveAccount() {
		System.out.println("�����˻�");
	}

	@Override
	public void updateAccount(int id) {
		int i = 1 / 0;
		System.out.println("�����˻�-" + id);
	}

	@Override
	public int deleteAccount(int id) {
		System.out.println("ɾ���˻�-" + id);
		return id;
	}

}

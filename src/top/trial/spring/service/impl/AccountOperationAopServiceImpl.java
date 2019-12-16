package top.trial.spring.service.impl;

import top.trial.spring.service.AccountOperationAopService;

public class AccountOperationAopServiceImpl implements AccountOperationAopService {

	@Override
	public void saveAccount() {
		System.out.println("保存账户");
	}

	@Override
	public void updateAccount(int id) {
		int i = 1 / 0;
		System.out.println("更新账户-" + id);
	}

	@Override
	public int deleteAccount(int id) {
		System.out.println("删除账户-" + id);
		return id;
	}

}

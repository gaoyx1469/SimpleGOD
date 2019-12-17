package top.trial.spring.service.impl;

import org.springframework.stereotype.Service;

import top.trial.spring.service.AccountOperationAopService;

@Service("accountService")
public class AccountOperationAopAnnotationServiceImpl implements AccountOperationAopService {

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

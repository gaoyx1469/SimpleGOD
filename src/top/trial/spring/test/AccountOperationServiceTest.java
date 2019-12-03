package top.trial.spring.test;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Test;

import top.trial.spring.SpringAccountBean;
import top.trial.spring.service.AccountOperationService;
import top.trial.spring.service.impl.AccountOperationServiceImpl;

public class AccountOperationServiceTest {

	AccountOperationService accountOperationService = new AccountOperationServiceImpl();

	@Test
	public void testAddAccount() {
		SpringAccountBean bean = new SpringAccountBean();
		bean.setSat_id(3);
		bean.setSat_name("小王");
		bean.setSat_value(new BigDecimal("8848.88"));
		accountOperationService.addAccount(bean);
	}

	@Test
	public void testUpdateAccount() {
		SpringAccountBean bean = new SpringAccountBean();
		bean.setSat_id(3);
		bean.setSat_name("小王");
		bean.setSat_value(new BigDecimal("8848.66"));
		accountOperationService.updateAccount(bean);
	}

	@Test
	public void testDeleteAccount() {
		accountOperationService.deleteAccount(3);
	}

	@Test
	public void testGetAccountById() {
		SpringAccountBean bean = accountOperationService.getAccountById(2);
		System.out.println(bean.toString());
	}

	@Test
	public void testGetAllAccounts() {
		List<SpringAccountBean> beans = accountOperationService.getAllAccounts();
		System.out.println(beans);
	}

	@Test
	public void testTransfer() {
		accountOperationService.transfer(1, 2, new BigDecimal("800"));
	}

}

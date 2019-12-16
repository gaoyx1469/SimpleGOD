package top.trial.spring.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import top.trial.spring.service.AccountOperationAopService;

public class AccountOperationServiceAopTest {
	public static void main(String[] args) {

		// ���������ļ�
		ApplicationContext ac = new ClassPathXmlApplicationContext("bean_aop.xml");

		// �������ʹ��
		// AccountOperationAopServiceImpl.class���ᱨ��BeanNotOfRequiredTypeException
		AccountOperationAopService service = ac.getBean("accountService", AccountOperationAopService.class);
		service.saveAccount();
		System.out.println("===========================");
		service.updateAccount(5);
		System.out.println("===========================");
		//System.out.println(service.deleteAccount(5));
	}
}

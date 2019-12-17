package top.trial.spring.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import top.trial.spring.service.AccountOperationAopService;

/**
 * ģ����԰�ע��ģʽ�µ�AOP
 * 
 * @author Gaoyx
 *
 */
public class AccountOperationServiceAopAnnotationTest {
	public static void main(String[] args) {

		// ���������ļ�
		ApplicationContext ac = new ClassPathXmlApplicationContext("bean_aop_annotation.xml");

		AccountOperationAopService service = ac.getBean("accountService", AccountOperationAopService.class);
		service.saveAccount();
		System.out.println("===========================");
		service.updateAccount(5);
		System.out.println("===========================");
		// System.out.println(service.deleteAccount(5));
	}
}

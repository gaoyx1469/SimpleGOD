package top.trial.spring.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import top.trial.spring.service.AccountOperationAopService;

public class AccountOperationServiceAopTest {
	public static void main(String[] args) {

		// 加载配置文件
		ApplicationContext ac = new ClassPathXmlApplicationContext("bean_aop.xml");

		// 这里如果使用
		// AccountOperationAopServiceImpl.class，会报错：BeanNotOfRequiredTypeException
		AccountOperationAopService service = ac.getBean("accountService", AccountOperationAopService.class);
		service.saveAccount();
		System.out.println("===========================");
		service.updateAccount(5);
		System.out.println("===========================");
		//System.out.println(service.deleteAccount(5));
	}
}

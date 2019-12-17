package top.trial.spring.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import top.trial.spring.service.AccountOperationAopService;
import top.trial.spring.util.SpringXml;

/**
 * 模拟测试全注解模式下的AOP
 * 
 * @author Gaoyx
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={SpringXml.class})
public class AccountOperationServiceAopAnnotationTestPlus {

	@Autowired
	AccountOperationAopService accountService;

	@Test
	public void testAop() {
		accountService.saveAccount();
		System.out.println("=======");
		accountService.updateAccount(5);
		System.out.println("=======");
	}
}

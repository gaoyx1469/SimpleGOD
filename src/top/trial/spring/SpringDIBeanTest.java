package top.trial.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ����ע��Bean�Ĳ���
 * 
 * @author Gaoyx
 *
 */
public class SpringDIBeanTest {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
		// ȫ������ע��
		// SpringDIBean sdib = (SpringDIBean) ac.getBean("ditest");
		// ��������set������ͬע��
		SpringDIBean sdib = (SpringDIBean) ac.getBean("ditestnew");
		System.out.println(sdib.toString());
	}

}

package top.trial.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Spring 快速入门演示
 * 
 * @author gaoyx
 *
 */
public class SpringQuickStartDemo {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("Bean.xml");
		SpringBean sb = ac.getBean("what", SpringBean.class);
		sb.service();
	}

}

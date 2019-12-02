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
		// 读取spring主配置文件
		ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
		// 上送对象类型可不用强转
		// SpringBean sb = (SpringBean)ac.getBean("what");
		SpringBean sb = ac.getBean("what", SpringBean.class);
		sb.service();
	}

}

package top.trial.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Spring ����������ʾ
 * 
 * @author gaoyx
 *
 */
public class SpringQuickStartDemo {

	public static void main(String[] args) {
		// ��ȡspring�������ļ�
		ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
		// ���Ͷ������Ϳɲ���ǿת
		// SpringBean sb = (SpringBean)ac.getBean("what");
		SpringBean sb = ac.getBean("what", SpringBean.class);
		sb.service();
	}

}

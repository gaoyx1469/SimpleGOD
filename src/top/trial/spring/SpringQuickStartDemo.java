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
		// ApplicationContext�ӿ���BeanFactory�����ӽӿ�
		// ApplicationContext�����������ز��ԣ��ڶ�ȡxml�ļ�ʱ��ֱ�ӽ����󴴽�������
		// ʵ����ʹ��ClassPathXmlApplicationContext��ͨ����ȡ��·���µ��ļ�����spring������
		// FileSystemXmlApplicationContext��ͨ����ȡ�ļ�ϵͳ�µ��ļ�����spring������
		// BeanFactory�����ӳټ��ز��ԣ���ʹ��ʱ�Ž����󴴽�������ʵ����ʹ��XmlBeanFactory
		ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
		// ���Ͷ������Ϳɲ���ǿת
		// SpringBean sb = (SpringBean)ac.getBean("what");
		SpringBean sb = ac.getBean("what", SpringBean.class);
		sb.service();
	}

}

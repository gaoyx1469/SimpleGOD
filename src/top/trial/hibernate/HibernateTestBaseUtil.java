package top.trial.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * ������SessionFactory�����ɣ����ڱ�DAO�������̳�
 * 
 * @author Gaoyx
 *
 */
public class HibernateTestBaseUtil {
	public static SessionFactory sessionFactory;
	static {
		Configuration config = new Configuration();
		// ���ε�configure(String url)�������Է���hibernate.cfg.xml��url����classpathΪ��Ŀ¼��/�ָ���
		// ������̬����������ͨ����̬�����ע��urlֵ
		config.configure();
		sessionFactory = config.buildSessionFactory();
	}

}

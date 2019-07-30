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
		config.configure();
		sessionFactory = config.buildSessionFactory();
	}

}

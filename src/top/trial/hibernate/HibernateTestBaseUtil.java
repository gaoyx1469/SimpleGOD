package top.trial.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * 集成了SessionFactory的生成，用于被DAO或测试类继承
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

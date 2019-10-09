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
		// 带参的configure(String url)方法可以放置hibernate.cfg.xml的url，以classpath为根目录，/分隔。
		// 声明静态参数后，子类通过静态代码块注入url值
		config.configure();
		sessionFactory = config.buildSessionFactory();
	}

}

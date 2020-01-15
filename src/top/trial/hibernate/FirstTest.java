package top.trial.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

/**
 * hibernate第一波测试，快速入门
 * 
 * @author Gaoyx
 *
 */
public class FirstTest {
	@Test
	public void testGameEntityInsert() {
		// 创建配置对象
		Configuration configuration = new Configuration();
		// 读取配置，读取的是classpath根目录下的hibernate.cfg.xml
		configuration.configure();
		// configuration.addResource(resourceName);未放置到classpath根目录下时，可是使用此方法加载

		// 生成sessionFactory
		SessionFactory sessionFactory = configuration.buildSessionFactory();

		// 生成session
		Session session = sessionFactory.openSession();

		// 开启事物
		Transaction transaction = session.beginTransaction();

		// insert
		session.save(new GameEntity("123", "写的啥"));

		// 提交事务
		transaction.commit();

		// 关闭session
		session.close();
	}
}

package top.trial.hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

public class TestGetCurrentSession extends HibernateTestBaseUtil {
	@Test
	public void testGetCurrentSession() {
		// 使用getCurrentSession()方法获取session
		Session session = sessionFactory.getCurrentSession();
		// 开启事务，此为getCurrentSession()方法获取session后的必需步骤
		Transaction transaction = session.beginTransaction();
		GameEntity clazz = session.get(GameEntity.class, 1);
		transaction.commit();
		// 调用close未报错，是否需要close存疑
		session.close();
	}
}

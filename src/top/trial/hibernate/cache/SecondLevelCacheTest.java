package top.trial.hibernate.cache;

import org.hibernate.Session;
import org.junit.Test;

import top.trial.hibernate.GameEntity;
import top.trial.hibernate.HibernateTestBaseUtil;

/**
 * 该类为二级缓存的测试类
 * 
 * @author Gaoyx1469
 *
 */
public class SecondLevelCacheTest extends HibernateTestBaseUtil {

	/**
	 * 二级缓存供应商没有找对，目前未完待续
	 */
	@Test
	public void testGetMethod() {
		// 此处使用openSession而不是getCurrentSession，目的是不开启实务，消除一级缓存影响，专注于二级缓存的测试
		Session session = sessionFactory.openSession();

		// 此处第一次get，放到了缓存中
		GameEntity game = session.get(GameEntity.class, 3);

		// 关闭session，清除一级缓存影响
		session.close();

		// 再次开启session
		session = sessionFactory.openSession();

		// 此处如果没有发出查询SQL，则表明是从二级缓存中取出的
		GameEntity game2 = session.get(GameEntity.class, 3);

		session.close();
	}
}

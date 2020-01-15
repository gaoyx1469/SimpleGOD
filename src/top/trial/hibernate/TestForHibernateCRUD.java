package top.trial.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

/**
 * 测试hibernate的CRUD
 * 
 * @author Gaoyx
 *
 */
public class TestForHibernateCRUD extends HibernateTestBaseUtil {

	@Test
	public void testC() {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		GameEntity gameEntity = new GameEntity("XCOM", "KILL THE ALIENS");
		session.save(gameEntity);

		transaction.commit();
		session.close();
	}

	@Test
	public void testRA() {
		Session session = sessionFactory.openSession();
		// 查询不需要开始事务
		List<GameEntity> list = session.createQuery("from GameEntity").list();
		for (GameEntity gameEntity : list) {
			System.out.println(gameEntity.toString());
		}
		session.close();
	}

	@Test
	public void testR() {
		Session session = sessionFactory.openSession();
		// 查询不需要开始事务
		GameEntity gameEntity = session.get(GameEntity.class, 3);
		System.out.println(gameEntity.toString());
		session.close();
	}

	@Test
	public void testU() {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		GameEntity gameEntity = session.get(GameEntity.class, 1);
		// 此处需要判断gameEntity存不存在,是否==null
		gameEntity.setGameName("XCOM 2");
		session.update(gameEntity);

		transaction.commit();
		session.close();
	}

	@Test
	public void testD() {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		// 以下两种方法都可，第二种方法不好判断是否存在，易报错，建议使用第一种方法
		GameEntity gameEntity = session.get(GameEntity.class, 1);
		// 此处需要判断gameEntity存不存在,是否==null
		session.delete(gameEntity);

		/*
		 * GameEntity gameEntity = new GameEntity(); gameEntity.setGid(2);
		 * session.delete(gameEntity);
		 */

		transaction.commit();
		session.close();
	}
}

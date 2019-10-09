package top.trial.hibernate.cache;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import top.trial.hibernate.GameEntity;
import top.trial.hibernate.HibernateTestBaseUtil;

public class SessionCacheTest extends HibernateTestBaseUtil {

	/**
	 * 测试hibernate的session缓存【一级缓存】的获取， get方法将数据放到一级缓存
	 */
	@Test
	public void testGetMethod() {
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();

		// 一下使用两次立即查询，显然只发出一次SQL，第二次get直接从缓存中拿查询结果
		GameEntity g1 = session.get(GameEntity.class, 3);
		GameEntity g2 = session.get(GameEntity.class, 3);

		transaction.commit();
		session.close();
	}

	/**
	 * 测试hibernate的session缓存【一级缓存】的获取， load方法将数据放到一级缓存
	 */
	@Test
	public void testLoadMethod() {
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();

		// 一下使用两次立即查询，显然只发出一次SQL，第二次load直接从缓存中拿查询结果
		GameEntity g1 = session.load(GameEntity.class, 3);
		System.out.println(g1.getGameName());
		GameEntity g2 = session.load(GameEntity.class, 3);
		System.out.println(g2.getGameName());

		transaction.commit();
		session.close();
	}

	/**
	 * 测试hibernate的session缓存【一级缓存】的获取， save方法
	 */
	@Test
	public void testSaveMethod() {
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();

		// 测试save方法
		GameEntity gameEntity = new GameEntity("山口丁", "欢乐源泉");
		// 此处发出select max(SGI_ID) from SG_GAME_INFO获取主键
		session.save(gameEntity);

		// 此处get方法没有发出SQL语句，因为事务未提交，insert语句都没有发出，get方法直接从一级缓存中拿取
		GameEntity game = session.get(GameEntity.class, gameEntity.getGid());
		System.out.println(game.toString());

		transaction.commit();
		session.close();
	}

	/**
	 * 测试hibernate的session缓存【一级缓存】的删除，evict方法和update方法，清除session特定缓存及添加一级缓存
	 */
	@Test
	public void testEvictAndUpdateMethod() {
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();

		GameEntity game = session.get(GameEntity.class, 3);
		// 此处使用evict清空session缓存中的game对象
		session.evict(game);
		// 此处执行update方法，将对象放入了缓存中
		session.update(game);
		// 此处get方法没有发出查询SQL，证明update方法一级缓存生效
		game = session.get(GameEntity.class, 3);
		// System.out.println(game.toString());

		transaction.commit();
		session.close();
	}

	/**
	 * 测试hibernate的session缓存【一级缓存】的全部删除，clear方法，清除session全部缓存
	 */
	@Test
	public void testClearMethod() {
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();

		GameEntity game = session.get(GameEntity.class, 3);
		// 此处使用evict清空session缓存中的game对象
		session.clear();
		// 此处get方法再次发出查询SQL，证明clear方法删除了一级缓存
		game = session.get(GameEntity.class, 3);

		transaction.commit();
		session.close();
	}

	/**
	 * 测试数据库数据刷新到hibernate的session缓存【一级缓存】中，refresh方法
	 */
	@Test
	public void testRefreshMethod() {
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();

		GameEntity game = session.get(GameEntity.class, 3);
		game.setGameName("我改了哈");
		// refresh直接又发出一条查询SQL语句，从数据库将数据刷到缓存中，将上一句的更改还原了
		session.refresh(game);

		transaction.commit();
		session.close();
	}

	/**
	 * 测试hibernate的session缓存【一级缓存】中的数据刷新到数据库中，flush方法
	 */
	@Test
	public void testFlushMethod() {
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();

		GameEntity game = session.get(GameEntity.class, 4);
		game.setGameDescribe("欢乐【火气】源泉");
		// 注意flush只是刷新数据到数据库，并没有清空一级缓存
		session.flush();
		// 此处没有发出新的查询SQL，证明并没有清空一级缓存
		GameEntity game2 = session.get(GameEntity.class, 4);

		transaction.commit();
		session.close();
	}
}

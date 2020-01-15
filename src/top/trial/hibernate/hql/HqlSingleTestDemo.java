package top.trial.hibernate.hql;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.junit.Test;

import top.trial.hibernate.GameEntity;
import top.trial.hibernate.HibernateTestBaseUtil;

/**
 * 测试HQL语句单表查询
 * 
 * @author gaoyx
 *
 */
public class HqlSingleTestDemo extends HibernateTestBaseUtil {

	/**
	 * 测试 from POJO类名 形式的HQL
	 */
	@Test
	public void singleModel1() {
		Session session = sessionFactory.openSession();
		// 直接使用from POJO类名，返回POJO类对象的List集合
		List<GameEntity> list = session.createQuery("from GameEntity").list();
		for (GameEntity game : list) {
			System.out.println(game.toString());
		}
		session.close();
	}

	/**
	 * 测试 select 属性名 from POJO类名 形式的HQL
	 */
	@Test
	public void singleModel2() {
		Session session = sessionFactory.openSession();
		// select 属性名 from POJO类名，返回筛选属性数组的List集合
		List<Object[]> list = session.createQuery("select gid, gameName from GameEntity").list();
		for (Object[] game : list) {
			for (Object obj : game) {
				System.out.print(obj);
			}
			System.out.println();
		}
		session.close();
	}

	/**
	 * 测试 select new POJO类构造方法 from POJO类名 形式的HQL
	 */
	@Test
	public void singleModel3() {
		Session session = sessionFactory.openSession();
		// select new POJO类构造方法 from POJO类名，返回POJO类对象（仅构造方法能注入的属性有值）的List集合
		List<GameEntity> list = session.createQuery("select new GameEntity(gameName,gameDescribe) from GameEntity")
				.list();
		for (GameEntity game : list) {
			System.out.println(game.toString());
		}
		session.close();
	}

	/**
	 * 测试带where条件的HQL语句
	 */
	@Test
	public void singleModel4() {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from GameEntity where gid=:gid");
		query.setParameter("gid", 1);
		// 此处如果主键不存在，则会报错
		GameEntity game = (GameEntity) query.getSingleResult();
		System.out.println(game.toString());
		session.close();
	}

	/**
	 * 测试带where条件的HQL语句
	 */
	@Test
	public void singleModel5() {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from GameEntity where gid=?0");
		query.setParameter(0, 3);
		// 此处如果主键不存在，则会报错
		GameEntity game = (GameEntity) query.getSingleResult();
		System.out.println(game.toString());
		session.close();
	}
}

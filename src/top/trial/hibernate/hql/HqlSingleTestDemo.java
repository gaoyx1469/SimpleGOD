package top.trial.hibernate.hql;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.junit.Test;

import top.trial.hibernate.GameEntity;
import top.trial.hibernate.HibernateTestBaseUtil;

/**
 * ����HQL��䵥���ѯ
 * 
 * @author gaoyx
 *
 */
public class HqlSingleTestDemo extends HibernateTestBaseUtil {

	/**
	 * ���� from POJO���� ��ʽ��HQL
	 */
	@Test
	public void singleModel1() {
		Session session = sessionFactory.openSession();
		// ֱ��ʹ��from POJO����������POJO������List����
		List<GameEntity> list = session.createQuery("from GameEntity").list();
		for (GameEntity game : list) {
			System.out.println(game.toString());
		}
		session.close();
	}

	/**
	 * ���� select ������ from POJO���� ��ʽ��HQL
	 */
	@Test
	public void singleModel2() {
		Session session = sessionFactory.openSession();
		// select ������ from POJO����������ɸѡ���������List����
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
	 * ���� select new POJO�๹�췽�� from POJO���� ��ʽ��HQL
	 */
	@Test
	public void singleModel3() {
		Session session = sessionFactory.openSession();
		// select new POJO�๹�췽�� from POJO����������POJO����󣨽����췽����ע���������ֵ����List����
		List<GameEntity> list = session.createQuery("select new GameEntity(gameName,gameDescribe) from GameEntity")
				.list();
		for (GameEntity game : list) {
			System.out.println(game.toString());
		}
		session.close();
	}

	/**
	 * ���Դ�where������HQL���
	 */
	@Test
	public void singleModel4() {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from GameEntity where gid=:gid");
		query.setParameter("gid", 1);
		// �˴�������������ڣ���ᱨ��
		GameEntity game = (GameEntity) query.getSingleResult();
		System.out.println(game.toString());
		session.close();
	}

	/**
	 * ���Դ�where������HQL���
	 */
	@Test
	public void singleModel5() {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from GameEntity where gid=?0");
		query.setParameter(0, 3);
		// �˴�������������ڣ���ᱨ��
		GameEntity game = (GameEntity) query.getSingleResult();
		System.out.println(game.toString());
		session.close();
	}
}

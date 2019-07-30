package top.trial.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

/**
 * ����hibernate��CRUD
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
		// ��ѯ����Ҫ��ʼ����
		List<GameEntity> list = session.createQuery("from GameEntity").list();
		for (GameEntity gameEntity : list) {
			System.out.println(gameEntity.toString());
		}
		session.close();
	}

	@Test
	public void testR() {
		Session session = sessionFactory.openSession();
		// ��ѯ����Ҫ��ʼ����
		GameEntity gameEntity = session.get(GameEntity.class, 3);
		System.out.println(gameEntity.toString());
		session.close();
	}

	@Test
	public void testU() {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		GameEntity gameEntity = session.get(GameEntity.class, 1);
		// �˴���Ҫ�ж�gameEntity�治����,�Ƿ�==null
		gameEntity.setGameName("XCOM 2");
		session.update(gameEntity);

		transaction.commit();
		session.close();
	}

	@Test
	public void testD() {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		// �������ַ������ɣ��ڶ��ַ��������ж��Ƿ���ڣ��ױ�������ʹ�õ�һ�ַ���
		GameEntity gameEntity = session.get(GameEntity.class, 1);
		// �˴���Ҫ�ж�gameEntity�治����,�Ƿ�==null
		session.delete(gameEntity);

		/*
		 * GameEntity gameEntity = new GameEntity(); gameEntity.setGid(2);
		 * session.delete(gameEntity);
		 */

		transaction.commit();
		session.close();
	}
}

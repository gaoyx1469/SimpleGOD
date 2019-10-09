package top.trial.hibernate.cache;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import top.trial.hibernate.GameEntity;
import top.trial.hibernate.HibernateTestBaseUtil;

public class SessionCacheTest extends HibernateTestBaseUtil {

	/**
	 * ����hibernate��session���桾һ�����桿�Ļ�ȡ�� get���������ݷŵ�һ������
	 */
	@Test
	public void testGetMethod() {
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();

		// һ��ʹ������������ѯ����Ȼֻ����һ��SQL���ڶ���getֱ�Ӵӻ������ò�ѯ���
		GameEntity g1 = session.get(GameEntity.class, 3);
		GameEntity g2 = session.get(GameEntity.class, 3);

		transaction.commit();
		session.close();
	}

	/**
	 * ����hibernate��session���桾һ�����桿�Ļ�ȡ�� load���������ݷŵ�һ������
	 */
	@Test
	public void testLoadMethod() {
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();

		// һ��ʹ������������ѯ����Ȼֻ����һ��SQL���ڶ���loadֱ�Ӵӻ������ò�ѯ���
		GameEntity g1 = session.load(GameEntity.class, 3);
		System.out.println(g1.getGameName());
		GameEntity g2 = session.load(GameEntity.class, 3);
		System.out.println(g2.getGameName());

		transaction.commit();
		session.close();
	}

	/**
	 * ����hibernate��session���桾һ�����桿�Ļ�ȡ�� save����
	 */
	@Test
	public void testSaveMethod() {
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();

		// ����save����
		GameEntity gameEntity = new GameEntity("ɽ�ڶ�", "����ԴȪ");
		// �˴�����select max(SGI_ID) from SG_GAME_INFO��ȡ����
		session.save(gameEntity);

		// �˴�get����û�з���SQL��䣬��Ϊ����δ�ύ��insert��䶼û�з�����get����ֱ�Ӵ�һ����������ȡ
		GameEntity game = session.get(GameEntity.class, gameEntity.getGid());
		System.out.println(game.toString());

		transaction.commit();
		session.close();
	}

	/**
	 * ����hibernate��session���桾һ�����桿��ɾ����evict������update���������session�ض����漰���һ������
	 */
	@Test
	public void testEvictAndUpdateMethod() {
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();

		GameEntity game = session.get(GameEntity.class, 3);
		// �˴�ʹ��evict���session�����е�game����
		session.evict(game);
		// �˴�ִ��update����������������˻�����
		session.update(game);
		// �˴�get����û�з�����ѯSQL��֤��update����һ��������Ч
		game = session.get(GameEntity.class, 3);
		// System.out.println(game.toString());

		transaction.commit();
		session.close();
	}

	/**
	 * ����hibernate��session���桾һ�����桿��ȫ��ɾ����clear���������sessionȫ������
	 */
	@Test
	public void testClearMethod() {
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();

		GameEntity game = session.get(GameEntity.class, 3);
		// �˴�ʹ��evict���session�����е�game����
		session.clear();
		// �˴�get�����ٴη�����ѯSQL��֤��clear����ɾ����һ������
		game = session.get(GameEntity.class, 3);

		transaction.commit();
		session.close();
	}

	/**
	 * �������ݿ�����ˢ�µ�hibernate��session���桾һ�����桿�У�refresh����
	 */
	@Test
	public void testRefreshMethod() {
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();

		GameEntity game = session.get(GameEntity.class, 3);
		game.setGameName("�Ҹ��˹�");
		// refreshֱ���ַ���һ����ѯSQL��䣬�����ݿ⽫����ˢ�������У�����һ��ĸ��Ļ�ԭ��
		session.refresh(game);

		transaction.commit();
		session.close();
	}

	/**
	 * ����hibernate��session���桾һ�����桿�е�����ˢ�µ����ݿ��У�flush����
	 */
	@Test
	public void testFlushMethod() {
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();

		GameEntity game = session.get(GameEntity.class, 4);
		game.setGameDescribe("���֡�������ԴȪ");
		// ע��flushֻ��ˢ�����ݵ����ݿ⣬��û�����һ������
		session.flush();
		// �˴�û�з����µĲ�ѯSQL��֤����û�����һ������
		GameEntity game2 = session.get(GameEntity.class, 4);

		transaction.commit();
		session.close();
	}
}

package top.trial.hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

public class TestGetCurrentSession extends HibernateTestBaseUtil {
	@Test
	public void testGetCurrentSession() {
		// ʹ��getCurrentSession()������ȡsession
		Session session = sessionFactory.getCurrentSession();
		// �������񣬴�ΪgetCurrentSession()������ȡsession��ı��貽��
		Transaction transaction = session.beginTransaction();
		GameEntity clazz = session.get(GameEntity.class, 1);
		transaction.commit();
		// ����closeδ�����Ƿ���Ҫclose����
		session.close();
	}
}

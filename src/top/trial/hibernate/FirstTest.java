package top.trial.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

/**
 * hibernate��һ�����ԣ���������
 * 
 * @author Gaoyx
 *
 */
public class FirstTest {
	@Test
	public void testGameEntityInsert() {
		// �������ö���
		Configuration configuration = new Configuration();
		// ��ȡ���ã���ȡ����classpath��Ŀ¼�µ�hibernate.cfg.xml
		configuration.configure();
		// configuration.addResource(resourceName);δ���õ�classpath��Ŀ¼��ʱ������ʹ�ô˷�������

		// ����sessionFactory
		SessionFactory sessionFactory = configuration.buildSessionFactory();

		// ����session
		Session session = sessionFactory.openSession();

		// ��������
		Transaction transaction = session.beginTransaction();

		// insert
		session.save(new GameEntity("123", "д��ɶ"));

		// �ύ����
		transaction.commit();

		// �ر�session
		session.close();
	}
}

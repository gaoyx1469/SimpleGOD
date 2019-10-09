package top.trial.hibernate.cache;

import org.hibernate.Session;
import org.junit.Test;

import top.trial.hibernate.GameEntity;
import top.trial.hibernate.HibernateTestBaseUtil;

/**
 * ����Ϊ��������Ĳ�����
 * 
 * @author Gaoyx1469
 *
 */
public class SecondLevelCacheTest extends HibernateTestBaseUtil {

	/**
	 * �������湩Ӧ��û���Ҷԣ�Ŀǰδ�����
	 */
	@Test
	public void testGetMethod() {
		// �˴�ʹ��openSession������getCurrentSession��Ŀ���ǲ�����ʵ������һ������Ӱ�죬רע�ڶ�������Ĳ���
		Session session = sessionFactory.openSession();

		// �˴���һ��get���ŵ��˻�����
		GameEntity game = session.get(GameEntity.class, 3);

		// �ر�session�����һ������Ӱ��
		session.close();

		// �ٴο���session
		session = sessionFactory.openSession();

		// �˴����û�з�����ѯSQL��������ǴӶ���������ȡ����
		GameEntity game2 = session.get(GameEntity.class, 3);

		session.close();
	}
}

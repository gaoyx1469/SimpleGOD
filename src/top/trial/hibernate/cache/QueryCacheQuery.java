package top.trial.hibernate.cache;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.junit.Test;

import top.trial.hibernate.GameEntity;
import top.trial.hibernate.HibernateTestBaseUtil;

/**
 * ��ѯ����ʾ���������ǻ��ڶ�������ģ�����������δ�ɹ�
 * 
 * @author Gaoyx1469
 *
 */
public class QueryCacheQuery extends HibernateTestBaseUtil {

	@Test
	public void testQueryCache() {
		Session session = sessionFactory.openSession();

		Query query = session.createQuery("from SG_GAME_INFO");
		query.setCacheable(true);
		List<GameEntity> list = query.list();

		// �ڶ��β�ѯ��ͬ��䣬û�з���SQL���
		query = session.createQuery("from SG_GAME_INFO");
		query.setCacheable(true);
		list = query.list();

		session.close();
	}
}

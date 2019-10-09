package top.trial.hibernate.cache;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.junit.Test;

import top.trial.hibernate.GameEntity;
import top.trial.hibernate.HibernateTestBaseUtil;

/**
 * 查询缓存示例，由于是基于二级缓存的，二级缓存尚未成功
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

		// 第二次查询相同语句，没有发出SQL语句
		query = session.createQuery("from SG_GAME_INFO");
		query.setCacheable(true);
		list = query.list();

		session.close();
	}
}

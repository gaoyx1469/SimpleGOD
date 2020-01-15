package top.trial.hibernate.relation;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import top.trial.hibernate.HibernateTestBaseUtil;

/**
 * 演示多对多操作，以APP和用户为例
 * 
 * 1、新建一个APP 2、新建一个用户 3、新建一个APP同时级联新建一个用户 4、新建一个APP，增加一个已存在的用户与其的关系
 * 5、新建一个用户，增加其与一个已经存在的APP的关系 6、建立一个已存在的APP与一个已存在的用户的关系
 * 7、建立一个已存在的APP与多个已存在的用户的关系 8、建立多个已存在的APP与多个已存在的用户的关系 9、移除一个已存在的APP与一个已存在的用户的关系
 * 10、移除一个已存在的APP与多个已存在的用户的关系 11、修改一个已存在的APP与一个已存在的用户的关系，变更为该用户与另一已存在的APP的关系
 * 12、删除APP 13、删除用户
 * 
 * @author Gaoyx
 *
 */
public class ManyToManyTest extends HibernateTestBaseUtil {

	@Test
	public void creatAppAndUser() {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		// 新建APP对象
		AppEntity app = new AppEntity();
		app.setAppName("知乎");
		app.setAppDescription("kill time");

		// 新建User对象
		UserEntity user = new UserEntity();
		user.setUserName("大黄");
		user.setUserDescription("就是时间多");

		// 将User对象的引用填入到App中
		Set<UserEntity> users = new HashSet<UserEntity>(1);
		users.add(user);
		app.setUsers(users);

		// 将APP对象持久化
		session.save(app);

		transaction.commit();
		session.close();
	}

}

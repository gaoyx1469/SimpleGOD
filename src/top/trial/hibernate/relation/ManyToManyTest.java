package top.trial.hibernate.relation;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import top.trial.hibernate.HibernateTestBaseUtil;

/**
 * ��ʾ��Զ��������APP���û�Ϊ��
 * 
 * 1���½�һ��APP
 * 2���½�һ���û�
 * 3���½�һ��APPͬʱ�����½�һ���û�
 * 4���½�һ��APP������һ���Ѵ��ڵ��û�����Ĺ�ϵ
 * 5���½�һ���û�����������һ���Ѿ����ڵ�APP�Ĺ�ϵ
 * 6������һ���Ѵ��ڵ�APP��һ���Ѵ��ڵ��û��Ĺ�ϵ
 * 7������һ���Ѵ��ڵ�APP�����Ѵ��ڵ��û��Ĺ�ϵ
 * 8����������Ѵ��ڵ�APP�����Ѵ��ڵ��û��Ĺ�ϵ
 * 9���Ƴ�һ���Ѵ��ڵ�APP��һ���Ѵ��ڵ��û��Ĺ�ϵ
 * 10���Ƴ�һ���Ѵ��ڵ�APP�����Ѵ��ڵ��û��Ĺ�ϵ
 * 11���޸�һ���Ѵ��ڵ�APP��һ���Ѵ��ڵ��û��Ĺ�ϵ�����Ϊ���û�����һ�Ѵ��ڵ�APP�Ĺ�ϵ
 * 12��ɾ��APP
 * 13��ɾ���û�
 * 
 * @author Gaoyx
 *
 */
public class ManyToManyTest extends HibernateTestBaseUtil {
	
	@Test
	public void creatAppAndUser() {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		//�½�APP����
		AppEntity app = new AppEntity();
		app.setAppName("֪��");
		app.setAppDescription("kill time");
		
		//�½�User����
		UserEntity user = new UserEntity();
		user.setUserName("���");
		user.setUserDescription("����ʱ���");
		
		//��User������������뵽App��
		Set<UserEntity> users = new HashSet<UserEntity>(1);
		users.add(user);
		app.setUsers(users);
		
		//��APP����־û�
		session.save(app);
		
		transaction.commit();
		session.close();
	}
	
}

package top.trial.hibernate.relation;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

import top.trial.hibernate.HibernateTestBaseUtil;

/**
 * ��ʾһ�Զ൥��������԰༶��ѧ��Ϊ��
 *
 * 1���½�һ���༶ 2���½�һ��ѧ�� 3���½�һ���༶��ʱ��ͬʱ�½�һ��ѧ�� 4���Ѿ�����һ���༶���½�һ��ѧ��������ѧ����༶֮��Ĺ�ϵ
 * 5���Ѿ�����һ��ѧ�����½�һ���༶����ѧ�����뵽�ð༶ 6����һ��ѧ����һ���༶ת�Ƶ���һ���༶ 7�����һ���༶��һ��ѧ��֮��Ĺ�ϵ
 * 8�����һ���༶��һЩѧ��֮��Ĺ�ϵ 9������ð༶�����е�ѧ��֮��Ĺ�ϵ 10���Ѿ�����һ���༶���Ѿ�����һ��ѧ���������ð༶���ѧ��֮��Ĺ�ϵ
 * 11���Ѿ�����һ���༶���Ѿ����ڶ��ѧ�����������ѧ����༶֮��Ĺ�ϵ 12��ɾ��ѧ�� 13��ɾ���༶ ɾ���༶��ʱ��ͬʱɾ��ѧ��
 * ��ɾ���༶֮ǰ������༶��ѧ��֮��Ĺ�ϵ
 * 
 * @author Gaoyx
 */
public class OneToManyTest extends HibernateTestBaseUtil {

	@Test
	public void createClass() {
		// 1���½�һ���༶

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		ClassEntity classEntity = new ClassEntity("��ϰ�", "ȫ�淢չ�����������");
		session.save(classEntity);

		transaction.commit();
		session.close();
	}
	
	@Test
	public void createStudent() {
		// 2���½�һ��ѧ����������������ϵ��

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		StudentEntity student = new StudentEntity("��", 20, "��");
		session.save(student);

		transaction.commit();
		session.close();
	}
	
	@Test
	public void createClassAndStudent() {
		// 3���½�һ���༶��ʱ��ͬʱ�½�һ��ѧ����������ϵ��������cascade��Ҫ���á�

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		ClassEntity classEntity = new ClassEntity("ʵ���", "ȫ�淢չ��ʵ��������");
		session.save(classEntity);
		StudentEntity student = new StudentEntity("����", 20, "Ů");
		Set<StudentEntity> cstus = new HashSet(1);
		cstus.add(student);
		classEntity.setCstus(cstus);
		
		transaction.commit();
		session.close();
	}
	
	@Test
	public void createStudentToClass() {
		//4���Ѿ�����һ���༶���½�һ��ѧ��������ѧ����༶֮��Ĺ�ϵ
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		transaction.commit();
		session.close();
	}
}

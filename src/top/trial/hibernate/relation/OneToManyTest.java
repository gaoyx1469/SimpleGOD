package top.trial.hibernate.relation;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

import top.trial.hibernate.HibernateTestBaseUtil;

/**
 * 演示一对多单向操作，以班级和学生为例
 *
 * 1、新建一个班级 2、新建一个学生 3、新建一个班级的时候同时新建一个学生 4、已经存在一个班级，新建一个学生，建立学生与班级之间的关系
 * 5、已经存在一个学生，新建一个班级，把学生加入到该班级 6、把一个学生从一个班级转移到另一个班级 7、解除一个班级和一个学生之间的关系
 * 8、解除一个班级和一些学生之间的关系 9、解除该班级和所有的学生之间的关系 10、已经存在一个班级，已经存在一个学生，建立该班级与该学生之间的关系
 * 11、已经存在一个班级，已经存在多个学生，建立多个学生与班级之间的关系 12、删除学生 13、删除班级 删除班级的时候同时删除学生
 * 在删除班级之前，解除班级和学生之间的关系
 * 
 * @author Gaoyx
 */
public class OneToManyTest extends HibernateTestBaseUtil {

	@Test
	public void createClass() {
		// 1、新建一个班级

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		ClassEntity classEntity = new ClassEntity("混合班", "全面发展，混合培养！");
		session.save(classEntity);

		transaction.commit();
		session.close();
	}
	
	@Test
	public void createStudent() {
		// 2、新建一个学生（不建立关联关系）

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		StudentEntity student = new StudentEntity("铮铮", 20, "男");
		session.save(student);

		transaction.commit();
		session.close();
	}
	
	@Test
	public void createClassAndStudent() {
		// 3、新建一个班级的时候同时新建一个学生（关联关系）【级联cascade需要配置】

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		ClassEntity classEntity = new ClassEntity("实验班", "全面发展，实验培养！");
		session.save(classEntity);
		StudentEntity student = new StudentEntity("罗罗", 20, "女");
		Set<StudentEntity> cstus = new HashSet(1);
		cstus.add(student);
		classEntity.setCstus(cstus);
		
		transaction.commit();
		session.close();
	}
	
	@Test
	public void createStudentToClass() {
		//4、已经存在一个班级，新建一个学生，建立学生与班级之间的关系
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		transaction.commit();
		session.close();
	}
}

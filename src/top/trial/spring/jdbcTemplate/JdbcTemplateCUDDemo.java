package top.trial.spring.jdbcTemplate;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import top.trial.spring.AccountEntity;

/**
 * JdbcTemplateʹ��Demo����Ҫ�漰update��query�Լ�queryForObject�������Լ�BeanPropertyRowMapper��
 * ��ʵ�����set��������������һ�£������Լ�дʵ����ʵ��RowMapper�ӿڣ���д�����Լ���װ
 * 
 * @author Gaoyx
 *
 */
public class JdbcTemplateCUDDemo {

	public static void main(String[] args) {

		ApplicationContext ac = new ClassPathXmlApplicationContext("bean_jdbcTemplate.xml");

		JdbcTemplate jt = ac.getBean("jdbcTemplate", JdbcTemplate.class);

		// jt.execute("insert into sg_account_test (SAT_ID,SAT_NAME,SAT_VALUE) values
		// (6,'JdbcTemplateIoC',5000.00)");

		// ��
		create(jt);

		// ��
		query(jt);
		System.out.println("===================");

		// ��
		update(jt);

		// ��ȫ��
		queryAll(jt);
		count(jt);
		System.out.println("===================");

		// ɾ
		delete(jt);

		// ��ȫ��
		queryAll(jt);
	}

	private static void create(JdbcTemplate jt) {
		jt.update("insert into sg_account_test (SAT_ID,SAT_NAME,SAT_VALUE) values (?,?,?)", 8, "JdbcTemplateIoC",
				10000.00F);
	}

	private static void update(JdbcTemplate jt) {
		jt.update("update sg_account_test set SAT_VALUE = ? where SAT_ID = ?", 8000.00F, 8);

	}

	private static void delete(JdbcTemplate jt) {
		jt.update("delete from sg_account_test where SAT_ID = ?", 8);

	}

	/**
	 * BeanPropertyRowMapper<AccountEntity>(AccountEntity.class)
	 * �Զ���װ��Ҫ��AccountEntity�ڵ�settings���������ݿ����������һ��
	 * 
	 * @param jt
	 */
	private static void query(JdbcTemplate jt) {
		List<AccountEntity> aes = jt.query("select * from sg_account_test where SAT_ID = ?",
				new BeanPropertyRowMapper<AccountEntity>(AccountEntity.class), 8);
		if (!aes.isEmpty()) {
			System.out.println(aes.get(0));
		}
	}

	/**
	 * BeanPropertyRowMapper<AccountEntity>(AccountEntity.class)
	 * �Զ���װ��Ҫ��AccountEntity�ڵ�settings���������ݿ����������һ��
	 * 
	 * @param jt
	 */
	private static void queryAll(JdbcTemplate jt) {
		List<AccountEntity> aes = jt.query("select * from sg_account_test",
				new BeanPropertyRowMapper<AccountEntity>(AccountEntity.class));
		for (AccountEntity ae : aes) {
			System.out.println(ae);
		}
	}

	/**
	 * �ۺϺ������ص��е������ݣ�ʹ��queryForObject����
	 * @param jt
	 */
	private static void count(JdbcTemplate jt) {
		System.out.println(jt.queryForObject("select count(*) from sg_account_test", Integer.class));

	}
}

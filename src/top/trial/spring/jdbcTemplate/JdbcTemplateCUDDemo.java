package top.trial.spring.jdbcTemplate;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import top.trial.spring.AccountEntity;

/**
 * JdbcTemplate使用Demo，主要涉及update、query以及queryForObject方法，以及BeanPropertyRowMapper类
 * 若实体类的set方法与表的列名不一致，可以自己写实现类实现RowMapper接口，重写方法自己封装
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

		// 增
		create(jt);

		// 查
		query(jt);
		System.out.println("===================");

		// 改
		update(jt);

		// 查全部
		queryAll(jt);
		count(jt);
		System.out.println("===================");

		// 删
		delete(jt);

		// 查全部
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
	 * 自动封装，要求AccountEntity内的settings方法与数据库的列名保持一致
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
	 * 自动封装，要求AccountEntity内的settings方法与数据库的列名保持一致
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
	 * 聚合函数返回单行单列数据，使用queryForObject方法
	 * @param jt
	 */
	private static void count(JdbcTemplate jt) {
		System.out.println(jt.queryForObject("select count(*) from sg_account_test", Integer.class));

	}
}

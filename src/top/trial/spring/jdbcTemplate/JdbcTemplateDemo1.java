package top.trial.spring.jdbcTemplate;

import org.springframework.jdbc.core.JdbcTemplate;

import top.util.jdbc.MysqlC3P0Util;

public class JdbcTemplateDemo1 {

	public static void main(String[] args) {

		// JdbcTemplate使用演示
		JdbcTemplate jt = new JdbcTemplate(MysqlC3P0Util.getDataSource());

		jt.execute("insert into sg_account_test (SAT_ID,SAT_NAME,SAT_VALUE) values (5,'JdbcTemplate',3000.00)");
	}

}

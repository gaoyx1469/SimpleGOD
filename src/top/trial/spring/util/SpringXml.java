package top.trial.spring.util;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import top.util.jdbc.MysqlDBCPUtil;

/**
 * 使用此配置类替代bean_aop_annotation.xml
 * 
 * @author Gaoyx
 *
 */
@Configuration
@ComponentScan("top.trial.spring")
@EnableAspectJAutoProxy
public class SpringXml {

	@Bean("dataSource")
	public DataSource createDataSource() {
		return MysqlDBCPUtil.getDataSource();
	}

	@Bean("queryRunner")
	public QueryRunner getQueryRunner(DataSource dataSource) {
		return new QueryRunner(dataSource);
	}
}

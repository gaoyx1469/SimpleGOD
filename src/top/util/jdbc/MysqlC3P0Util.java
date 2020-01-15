package top.util.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * 引用C3P0数据库连接池，MysqlJDBCUtil升级版
 * 
 * @author Gaoyx
 *
 */
public class MysqlC3P0Util {

	// 默认取classpath下的c3p0-config.xml中的配置或classpath下的c3p0.properties中的配置
	// 构造方法的参数为指定创建的数据源的名字，不写就没有名字
	static ComboPooledDataSource cpds = new ComboPooledDataSource("intergalactoApp");

	/**
	 * 获取数据源
	 * 
	 * @return
	 */
	public static DataSource getDataSource() {
		return cpds;
	}

	/**
	 * 获取连接
	 * 
	 * @return
	 */
	public static Connection getConnection() {
		try {
			return cpds.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 释放资源
	 * 
	 * @param rs
	 * @param stmt
	 * @param conn
	 */
	public static void release(ResultSet rs, Statement stmt, Connection conn) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			rs = null;
		}
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			stmt = null;
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			conn = null;
		}
	}
}

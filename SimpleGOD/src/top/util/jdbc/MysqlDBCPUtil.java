package top.util.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSourceFactory;

import top.util.properties.PropertiesUtil;

/**
 * 引用DBCP数据库连接池，MysqlJDBCUtil升级版
 * @author 高宇翔
 *
 */
public class MysqlDBCPUtil {
	private static DataSource ds = null;
	
	static {
		//数据源工厂
		BasicDataSourceFactory bdsf = new BasicDataSourceFactory();
		try {
			//数据源工厂根据properties文件创建数据源
			ds = bdsf.createDataSource(PropertiesUtil.getPropertiesByClassloader("dbcpconfig.properties"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 获取连接
	 * @return
	 */
	public static Connection getConnection() {
		try {
			return ds.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	/**
	 * 释放资源
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

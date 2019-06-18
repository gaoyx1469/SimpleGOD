package top.util.jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import top.util.properties.PropertiesUtil;

/**
 * Mysql--JDBC工具类 依赖properties工具类 方法： 1.获取连接 2.释放资源
 * 
 * @author Gaoyx
 *
 */
public class MysqlJDBCUtil {
	private static String driver;
	private static String url;
	private static String user;
	private static String password;

	static {
		try {
			Properties prop = PropertiesUtil.getPropertiesByClassloader("jdbc.properties");
			driver = prop.getProperty("driver");
			url = prop.getProperty("jdbc_url");
			user = prop.getProperty("user");
			password = prop.getProperty("password");

			Class.forName(driver);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 获取连接
	 * @return
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, user, password);
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

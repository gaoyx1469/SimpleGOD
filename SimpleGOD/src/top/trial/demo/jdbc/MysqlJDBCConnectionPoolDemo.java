package top.trial.demo.jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.Properties;

import top.util.properties.PropertiesUtil;

/**
 * ģ������ݿ����ӳ�
 * @author ������
 *
 */
public class MysqlJDBCConnectionPoolDemo {
	private static String driver;
	private static String url;
	private static String user;
	private static String password;
	private static int poolSize = 10;
	private static LinkedList<Connection> pool = new LinkedList<Connection>();

	static {
		try {
			Properties prop = PropertiesUtil.getPropertiesByClassloader("jdbc.properties");
			driver = prop.getProperty("driver");
			url = prop.getProperty("jdbc_url");
			user = prop.getProperty("user");
			password = prop.getProperty("password");

			Class.forName(driver);
			
			for(int i = 0;i<poolSize;i++) {
				pool.add(DriverManager.getConnection(url, user, password));
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * ��ȡ����,ʹ��synchronized��֤�̰߳�ȫ
	 * @return
	 * @throws SQLException
	 */
	public static synchronized Connection getConnection(){
		if(!pool.isEmpty()) {
			return pool.remove();
		}
		return null;
	}

	/**
	 * �ͷ���Դ
	 * @param conn
	 */
	public static void release(Connection conn) {
		if (conn != null) {
			pool.add(conn);
			conn = null;
		}
	}
}

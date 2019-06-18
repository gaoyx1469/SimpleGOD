package top.util.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSourceFactory;

import top.util.properties.PropertiesUtil;

/**
 * ����DBCP���ݿ����ӳأ�MysqlJDBCUtil������
 * @author Gaoyx
 *
 */
public class MysqlDBCPUtil {
	private static DataSource ds = null;
	
	static {
		try {
			//����Դ��������properties�ļ���������Դ
			ds = BasicDataSourceFactory.createDataSource(PropertiesUtil.getPropertiesByClassloader("dbcpconfig.properties"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * ��ȡ����Դ
	 * @return
	 */
	public static DataSource getDataSource() {
		return ds;
	}
	
	/**
	 * ��ȡ����
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
	 * �ͷ���Դ��ʹ��DBUtils���ʱ�Ѿ��Զ��ͷ���Դ��������ô˷���
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

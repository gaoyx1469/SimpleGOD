package top.util.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * ����C3P0���ݿ����ӳأ�MysqlJDBCUtil������
 * @author Gaoyx
 *
 */
public class MysqlC3P0Util {
	
	//Ĭ��ȡclasspath�µ�c3p0-config.xml�е����û�classpath�µ�c3p0.properties�е�����
	static ComboPooledDataSource cpds = new ComboPooledDataSource("intergalactoApp");

	/**
	 * ��ȡ����Դ
	 * @return
	 */
	public static DataSource getDataSource() {
		return cpds;
	}
	
	/**
	 * ��ȡ����
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
	 * �ͷ���Դ
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

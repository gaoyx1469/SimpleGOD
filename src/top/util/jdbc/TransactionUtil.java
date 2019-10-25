package top.util.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSourceFactory;

import top.util.properties.PropertiesUtil;

public class TransactionUtil {

	private static ThreadLocal<Connection> tl = new ThreadLocal<Connection>();
	private static DataSource ds = null;

	static {
		try {
			// ����Դ��������properties�ļ���������Դ
			ds = BasicDataSourceFactory
					.createDataSource(PropertiesUtil.getPropertiesByClassloader("dbcpconfig.properties"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// ��ȡ����Դ
	public static DataSource getDataSource() {
		return ds;
	}

	// ��ȡ���ӣ������״λ�ȡ�������ӷŵ�ThreadLocal��
	public static Connection getConnection() {
		try {
			Connection conn = tl.get();
			if (conn == null) {
				conn = ds.getConnection();
				tl.set(conn);
			}
			return conn;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	// ����������û�����ӣ���ȡ���Ӳ��ŵ�ThreadLocal��
	public static void startTransacion() {
		try {
			Connection conn = tl.get();
			if (conn == null) {
				conn = getConnection();
			}
			conn.setAutoCommit(false);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	// �ع�������û�����ӣ���ȡ���Ӳ��ŵ�ThreadLocal��
	public static void rollback() {
		try {
			Connection conn = tl.get();
			if (conn == null) {
				conn = getConnection();
			}
			conn.rollback();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	// �ύ������û�����ӣ���ȡ���Ӳ��ŵ�ThreadLocal��
	public static void commit() {
		try {
			Connection conn = tl.get();
			if (conn == null) {
				conn = getConnection();
			}
			conn.commit();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	// �ͷ����ӣ��������ӣ��ͷ����Ӳ����ThreadLocal�б��̵߳�Connection
	public static void release() {
		try {
			Connection conn = tl.get();
			if (conn != null) {
				conn.close();
				tl.remove();
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}

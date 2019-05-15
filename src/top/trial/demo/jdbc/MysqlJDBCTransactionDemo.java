package top.trial.demo.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;

import org.junit.Test;

import top.util.jdbc.MysqlJDBCUtil;

public class MysqlJDBCTransactionDemo {

	@Test
	public void testTransaction() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Savepoint sp = null;
		try {
			conn = MysqlJDBCUtil.getConnection();
			//conn.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);//����������뼶��
			
			//���ÿ�������
			conn.setAutoCommit(false);
			
			//��һ������
			ps = conn.prepareStatement("XXX");
			ps.executeUpdate();
			
			//���û��˵�
			sp = conn.setSavepoint("first savepoint");
			
			//�ڶ�������
			ps = conn.prepareStatement("XXX");
			ps.executeUpdate();
		}catch(Exception e) {
			try {
				//�������˵�savepoint
				conn.rollback(sp);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}finally {
			try {
				//�������ύ����
				conn.commit();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			MysqlJDBCUtil.release(rs, ps, conn);
		}
		
	}
}

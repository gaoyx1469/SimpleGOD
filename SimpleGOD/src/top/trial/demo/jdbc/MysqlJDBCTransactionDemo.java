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
			//conn.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);//设置事务隔离级别
			
			//设置开启事务
			conn.setAutoCommit(false);
			
			//第一段事务
			ps = conn.prepareStatement("XXX");
			ps.executeUpdate();
			
			//设置回退点
			sp = conn.setSavepoint("first savepoint");
			
			//第二段事务
			ps = conn.prepareStatement("XXX");
			ps.executeUpdate();
		}catch(Exception e) {
			try {
				//报错，回退到savepoint
				conn.rollback(sp);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}finally {
			try {
				//不报错，提交事务
				conn.commit();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			MysqlJDBCUtil.release(rs, ps, conn);
		}
		
	}
}

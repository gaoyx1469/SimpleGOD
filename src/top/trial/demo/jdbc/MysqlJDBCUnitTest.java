package top.trial.demo.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.junit.Assert;
import org.junit.Test;

import top.util.jdbc.MysqlJDBCUtil;

public class MysqlJDBCUnitTest {

	@Test
	public void testQryOne() {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = MysqlJDBCUtil.getConnection();
			String sql = "SELECT SUI_ID,SUI_NAME,SUI_AGE,SUI_STT,SUI_CREADATE FROM SG_USER_INFO WHERE SUI_ID=?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, "1000000001");
			rs = stmt.executeQuery();
			if (rs.next()) {
				System.out.println(rs.getString("SUI_ID"));
				System.out.println(rs.getString("SUI_NAME"));
				System.out.println(rs.getObject("SUI_AGE"));
				System.out.println(rs.getString("SUI_STT"));
				System.out.println(rs.getObject("SUI_CREADATE"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MysqlJDBCUtil.release(rs, stmt, conn);
		}
	}

	@Test
	public void testQryAll() {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = MysqlJDBCUtil.getConnection();
			String sql = "SELECT SUI_ID,SUI_NAME,SUI_AGE,SUI_STT,SUI_CREADATE FROM SG_USER_INFO";
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getString("SUI_ID"));
				System.out.println(rs.getString("SUI_NAME"));
				System.out.println(rs.getObject("SUI_AGE"));
				System.out.println(rs.getString("SUI_STT"));
				System.out.println(rs.getObject("SUI_CREADATE"));
				System.out.println("--------------------");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MysqlJDBCUtil.release(rs, stmt, conn);
		}
	}

	@Test
	public void testInsert() {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = MysqlJDBCUtil.getConnection();
			String sql = "INSERT INTO SG_USER_INFO (SUI_ID,SUI_NAME,SUI_MOBILE,SUI_AGE,SUI_STT,SUI_CREADATE) VALUES (?,?,?,?,?,?)";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, "1000000021");
			stmt.setString(2, "≤‚ ‘");
			stmt.setString(3, "17712345678");
			stmt.setInt(4, 20);
			stmt.setString(5, "1");
			stmt.setDate(6, new Date(new java.util.Date().getTime()));
			int i = stmt.executeUpdate();
			Assert.assertEquals(1, i);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MysqlJDBCUtil.release(rs, stmt, conn);
		}
	}

	@Test
	public void testUpdate() {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = MysqlJDBCUtil.getConnection();
			String sql = "UPDATE SG_USER_INFO SET SUI_MOBILE=? WHERE SUI_ID=?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, "17712345679");
			stmt.setString(2, "1000000021");
			int i = stmt.executeUpdate();
			Assert.assertEquals(1, i);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MysqlJDBCUtil.release(rs, stmt, conn);
		}
	}

	@Test
	public void testDelete() {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = MysqlJDBCUtil.getConnection();
			String sql = "DELETE FROM SG_USER_INFO WHERE SUI_ID=?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, "1000000021");
			int i = stmt.executeUpdate();
			Assert.assertEquals(1, i);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MysqlJDBCUtil.release(rs, stmt, conn);
		}
	}
}

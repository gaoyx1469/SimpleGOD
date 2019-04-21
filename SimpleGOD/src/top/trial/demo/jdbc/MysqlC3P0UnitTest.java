package top.trial.demo.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import top.util.jdbc.MysqlC3P0Util;

public class MysqlC3P0UnitTest {

	@Test
	public void testQryOne() {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = MysqlC3P0Util.getConnection();
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
			MysqlC3P0Util.release(rs, stmt, conn);
		}
	}
}

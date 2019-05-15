package top.trial.demo.jdbc;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import top.trial.demo.entity.UserInfoDomain;
import top.util.properties.PropertiesUtil;

public class MysqlJDBCTestPlus {
	private final static String QUERY_USER_INFO_SQL = "SELECT SUI_ID,SUI_NAME,SUI_STT,SUI_CREADATE FROM SG_USER_INFO";

	public static void main(String[] args) {
		Properties prop = null;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			prop = PropertiesUtil.getPropertiesByClassloader("jdbc.properties");
			// ע������
			Class.forName(prop.getProperty("driver"));
			// ��ȡ����
			conn = DriverManager.getConnection(prop.getProperty("jdbc_url"), prop);
			// ��ȡsql����
			stmt = conn.createStatement();
			// ��ȡ��ѯ���
			rs = stmt.executeQuery(QUERY_USER_INFO_SQL);
			List<UserInfoDomain> users = new ArrayList<UserInfoDomain>();
			// 5.ȡ�����
			while (rs.next()) {
				UserInfoDomain user = new UserInfoDomain();
				user.setSui_id(rs.getString("sui_id"));
				user.setSui_name(rs.getString("sui_name"));
				user.setSui_stt(rs.getString("sui_stt"));
				user.setSui_creadate(rs.getDate("sui_creadate"));
				users.add(user);
			}
			// 6.�������
			for (UserInfoDomain user : users) {
				System.out.println(user);
			}
		} catch (IOException e) {
			new RuntimeException(e);
		} catch (ClassNotFoundException e) {
			new RuntimeException(e);
		} catch (SQLException e) {
			new RuntimeException(e);
		} finally {
			// 7.�ͷ���Դ
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

}

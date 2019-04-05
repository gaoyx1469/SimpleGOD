package top.trial.demo.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import com.mysql.cj.jdbc.Driver;

/**
 * 
 * @author ������
 *
 */
public class MysqlJDBCTest {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws SQLException {
		// 1.���ض�Ӧ���ݿ���������ע��
		// DriverManager
		DriverManager.registerDriver(new Driver());
		// 2.��ȡ�����ݿ������
		// Connection
		Connection conn = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/simplegod?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC",
				"root", "123456");
		// 3.�õ�SQL�����󣬷��͸����ݿ�
		// Statement
		Statement stmt = conn.createStatement();
		// 4.���н������ȡ��װ�˲�ѯ����Ķ���
		// ResultSet
		ResultSet rs = stmt.executeQuery("SELECT SUI_ID,SUI_NAME,SUI_STT,SUI_CREADATE FROM SG_USER_INFO");
		// 5.�������
		while (rs.next()) {
			System.out.println("-------------");
			System.out.println(rs.getObject(1));
			System.out.println(rs.getObject(2));
			System.out.println(rs.getObject(3));
			System.out.println(((Date) rs.getObject(4)).toGMTString());
		}
		// 6.�ͷ���Դ
		rs.close();
		stmt.close();
		conn.close();
	}

}

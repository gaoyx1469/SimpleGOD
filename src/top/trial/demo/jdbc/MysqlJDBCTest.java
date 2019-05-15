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
 * @author 高宇翔
 *
 */
public class MysqlJDBCTest {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws SQLException {
		// 1.加载对应数据库驱动程序并注册
		// DriverManager
		DriverManager.registerDriver(new Driver());
		// 2.获取与数据库的连接
		// Connection
		Connection conn = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/simplegod?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC",
				"root", "123456");
		// 3.得到SQL语句对象，发送给数据库
		// Statement
		Statement stmt = conn.createStatement();
		// 4.如有结果，获取封装了查询结果的对象
		// ResultSet
		ResultSet rs = stmt.executeQuery("SELECT SUI_ID,SUI_NAME,SUI_STT,SUI_CREADATE FROM SG_USER_INFO");
		// 5.遍历结果
		while (rs.next()) {
			System.out.println("-------------");
			System.out.println(rs.getObject(1));
			System.out.println(rs.getObject(2));
			System.out.println(rs.getObject(3));
			System.out.println(((Date) rs.getObject(4)).toGMTString());
		}
		// 6.释放资源
		rs.close();
		stmt.close();
		conn.close();
	}

}

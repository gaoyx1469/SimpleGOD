package top.trial.demo.jdbc;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.SQLException;
import java.util.Date;

import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialClob;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.junit.Test;

import top.trial.demo.entity.UserTestEntity;
import top.util.jdbc.MysqlDBCPUtil;

public class MysqlDbUtilsUnitTest {
	private QueryRunner qr = new QueryRunner(MysqlDBCPUtil.getDataSource());

	// 测试INSERT
	// 对于MYSQL，new Date()或者yyyy-MM-dd格式的字符串都可以
	@Test
	public void testInsert() {
		try {
			qr.update("INSERT INTO SG_USER_INFO (SUI_ID,SUI_NAME,SUI_CREADATE) VALUES (?,?,?)", "1000000013", "九",
					new Date());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 测试UPDATE
	@Test
	public void testUpdate() {
		try {
			qr.update("UPDATE SG_USER_INFO SET SUI_NAME=? WHERE SUI_ID=?", "小七", "1000000011");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 测试批处理,关键在于二维数组
	@Test
	public void testBatch() {
		Object[][] obs = new Object[3][];
		for (int i = 0; i < obs.length; i++) {
			obs[i] = new Object[] { "0", "100000001" + (i + 1) };
		}
		try {
			qr.batch("UPDATE SG_USER_INFO SET SUI_STT=? WHERE SUI_ID=?", obs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 测试DML--BLOB,可能造成内存溢出
	@Test
	public void testBlob() {
		try {
			// 得到输入流，此时使用绝对路径，不妥，如何通过相对路径获取？
			InputStream in = new FileInputStream("D:/GitSpace/SimpleGOD/SimpleGOD/WebContent/image/trial/bt.jpg");
			// System.out.println(in.available());
			byte b[] = new byte[in.available()];
			in.read(b);
			in.close();
			Blob blob = new SerialBlob(b);
			qr.update("INSERT INTO SG_LOB_TEST (SLT_ID,SLT_NAME,SLT_PAGEIMG,SLT_CREADATE) VALUES (?,?,?,?)", 1000000001,
					"按钮", blob, new Date());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 测试DML--CLOB,可能造成内存溢出
	@Test
	public void testClob() {
		try {
			File file = new File("D:/GitSpace/SimpleGOD/SimpleGOD/WebContent/WEB-INF/example/XMLExample.xml");
			Reader reader = new FileReader(file);
			// System.out.println(file.length());
			char c[] = new char[(int) file.length()];
			reader.read(c);
			reader.close();
			Clob clob = new SerialClob(c);
			qr.update("UPDATE SG_LOB_TEST SET SLT_CONTENT=? SLT_MODIDATE=? WHERE SLT_ID=?", clob, new Date(),
					1000000001);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 测试QUERY,结果处理器
	@Test
	public void testQryOne() {
		try {
			// 报错了，估计是不支持Blob和Clob
			// LobTestEntity lte = qr.query("SELECT * FROM SG_LOB_TEST WHERE SLT_ID=?", new
			// BeanHandler<LobTestEntity>(LobTestEntity.class), 1000000001);
			// System.out.println(lte);

			// 无Blob和Clob的就没问题
			UserTestEntity ute = qr.query("SELECT * FROM SG_USER_INFO WHERE SUI_ID=?",
					new BeanHandler<UserTestEntity>(UserTestEntity.class), "1000000001");
			System.out.println(ute);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

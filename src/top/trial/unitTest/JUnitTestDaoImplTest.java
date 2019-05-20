package top.trial.unitTest;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import top.trial.demo.dao.JUnitTestDao;
import top.trial.demo.dao.impl.JUnitTestDaoImpl;

public class JUnitTestDaoImplTest {

	static JUnitTestDao testDao = null;

	// ��ʼ��
	@BeforeClass
	public static void initDao() {
		testDao = new JUnitTestDaoImpl();
	}

	// ����
	@AfterClass
	public static void distoryDao() {
		testDao = null;
	}

	/*
	 * //ÿ�����Է�������ǰִ��
	 * 
	 * @Before public void initMethod() { testDao = new JUnitTestDaoImpl(); }
	 * 
	 * //ÿ�����Է������ú�ִ��
	 * 
	 * @After public void distoryMethod() { testDao = null; }
	 */

	/**
	 * �����ǽ����ȷ��Ч���б�֤
	 */
	@Test(timeout = 10) // ��λ�Ǻ���
	public void testSum() {
		int sunNum = testDao.sum(1, 2);
		Assert.assertEquals(3, sunNum);
	}

	/**
	 * �������׳�ArithmeticException�쳣
	 */
	@Test(expected = ArithmeticException.class)
	public void testDivide() {
		int divideNum = testDao.divide(6, 0);
	}

}

package top.trial.unitTest;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import top.trial.demo.dao.JUnitTestDao;
import top.trial.demo.dao.impl.JUnitTestDaoImpl;

public class JUnitTestDaoImplTest {

	static JUnitTestDao testDao = null;

	// 初始化
	@BeforeClass
	public static void initDao() {
		testDao = new JUnitTestDaoImpl();
	}

	// 销毁
	@AfterClass
	public static void distoryDao() {
		testDao = null;
	}

	/*
	 * //每个测试方法调用前执行
	 * 
	 * @Before public void initMethod() { testDao = new JUnitTestDaoImpl(); }
	 * 
	 * //每个测试方法调用后执行
	 * 
	 * @After public void distoryMethod() { testDao = null; }
	 */

	/**
	 * 期望是结果正确，效率有保证
	 */
	@Test(timeout = 10) // 单位是毫秒
	public void testSum() {
		int sunNum = testDao.sum(1, 2);
		Assert.assertEquals(3, sunNum);
	}

	/**
	 * 期望是抛出ArithmeticException异常
	 */
	@Test(expected = ArithmeticException.class)
	public void testDivide() {
		int divideNum = testDao.divide(6, 0);
	}

}

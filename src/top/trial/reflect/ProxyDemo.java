package top.trial.reflect;

import java.lang.reflect.Proxy;

import org.junit.Test;

import top.trial.demo.dao.UserOperaterDao;
import top.trial.demo.dao.impl.MyInvocationHandler;
import top.trial.demo.dao.impl.UserOperaterDaoImpl;

/**
 * ��̬����ʾ������
 * 
 * @author Gaoyx
 *
 */
public class ProxyDemo {

	@Test
	public void proxyTest() {
		// ���������������
		UserOperaterDao uod = new UserOperaterDaoImpl();
		// ����InvocationHandler
		MyInvocationHandler handler = new MyInvocationHandler(uod);
		// ���ɴ�����
		UserOperaterDao proxy = (UserOperaterDao) Proxy.newProxyInstance(uod.getClass().getClassLoader(),
				uod.getClass().getInterfaces(), handler);
		// ��������ò����෽��
		proxy.addUser();
	}

}

package top.trial.reflect;

import java.lang.reflect.Proxy;

import org.junit.Test;

import top.trial.demo.dao.UserOperaterDao;
import top.trial.demo.dao.impl.MyInvocationHandler;
import top.trial.demo.dao.impl.UserOperaterDaoImpl;

/**
 * 动态代理示例代码
 * 
 * @author Gaoyx
 *
 */
public class ProxyDemo {

	@Test
	public void proxyTest() {
		// 创建被代理操作类
		UserOperaterDao uod = new UserOperaterDaoImpl();
		// 创建InvocationHandler
		MyInvocationHandler handler = new MyInvocationHandler(uod);
		// 生成代理类
		UserOperaterDao proxy = (UserOperaterDao) Proxy.newProxyInstance(uod.getClass().getClassLoader(),
				uod.getClass().getInterfaces(), handler);
		// 代理类调用操作类方法
		proxy.addUser();
	}

}

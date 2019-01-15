package top.trial.reflect;

import java.lang.reflect.Proxy;

import top.trial.demo.dao.UserOperaterDao;
import top.trial.demo.dao.impl.MyInvocationHandler;
import top.trial.demo.dao.impl.UserOperaterDaoImpl;

/**
 * 动态代理示例代码
 * 
 * @author 高宇翔
 *
 */
public class ProxyDemo {

	public static void main(String[] args) {

		UserOperaterDao uod = new UserOperaterDaoImpl();
		MyInvocationHandler handler = new MyInvocationHandler(uod);
		UserOperaterDao proxy = (UserOperaterDao) Proxy.newProxyInstance(uod.getClass().getClassLoader(),
				uod.getClass().getInterfaces(), handler);

		proxy.addUser();

	}

}

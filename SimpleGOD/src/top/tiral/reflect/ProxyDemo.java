package top.tiral.reflect;

import java.lang.reflect.Proxy;

import top.trial.demo.dao.UserOperaterDao;
import top.trial.demo.dao.impl.MyInvocationHandler;
import top.trial.demo.dao.impl.UserOperaterDaoImpl;

public class ProxyDemo {

	public static void main(String[] args) {

		UserOperaterDao uod = new UserOperaterDaoImpl();
		MyInvocationHandler handler = new MyInvocationHandler(uod);
		UserOperaterDao proxy = (UserOperaterDao)Proxy.newProxyInstance(uod.getClass().getClassLoader(), uod.getClass().getInterfaces(), handler);
		
		proxy.addUser();
		
	}

}

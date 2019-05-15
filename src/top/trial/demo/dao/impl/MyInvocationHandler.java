package top.trial.demo.dao.impl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import top.trial.demo.dao.UserOperaterDao;

public class MyInvocationHandler implements InvocationHandler {

	private UserOperaterDao uod;

	public MyInvocationHandler(UserOperaterDao uod) {
		this.uod = uod;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("�˴�����ǰ�÷���");
		Object result = method.invoke(uod, args);
		System.out.println("�˴����ú��÷���");
		return result;
	}

}

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
		System.out.println("此处调用前置方法");
		Object result = method.invoke(uod, args);
		System.out.println("此处调用后置方法");
		return result;
	}

}

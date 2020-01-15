package top.trial.reflect;

import java.lang.reflect.Method;

import org.junit.Test;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * 演示基于子类的动态代理
 * 
 * 依赖cglib包2.2版本，太新了还不行和asm包
 * 
 * 核心接口和类：Enhancer、MethodInterceptor
 * 
 * @author gaoyx
 *
 */
public class ProxyDemo2 {

	@Test
	public void proxyTest() {
		MethodTemp mt = new MethodTemp();

		MethodTemp mtFactory = (MethodTemp) Enhancer.create(mt.getClass(), new MethodInterceptor() {

			@Override
			public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy)
					throws Throwable {

				Object retValue = null;
				System.out.println("调用前");
				float money = (float) args[0];
				money = money - 1000f;
				method.invoke(mt, money);
				System.out.println("调用后");
				return retValue;
			}
		});

		mtFactory.sale(5000f);
		mtFactory.earn(8000f);
	}
}

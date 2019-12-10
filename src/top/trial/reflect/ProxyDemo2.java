package top.trial.reflect;

import java.lang.reflect.Method;

import org.junit.Test;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * ��ʾ��������Ķ�̬����
 * 
 * ����cglib��2.2�汾��̫���˻����к�asm��
 * 
 * ���Ľӿں��ࣺEnhancer��MethodInterceptor
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
				System.out.println("����ǰ");
				float money = (float) args[0];
				money = money - 1000f;
				method.invoke(mt, money);
				System.out.println("���ú�");
				return retValue;
			}
		});

		mtFactory.sale(5000f);
		mtFactory.earn(8000f);
	}
}

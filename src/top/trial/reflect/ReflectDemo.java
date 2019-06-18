package top.trial.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.junit.Test;

import top.trial.demo.entity.GameEntity;

/**
 * 
 * @author Gaoyx
 *
 * ������ָͨ��class�ļ�����ʹ�ø��ļ��еı����ͷ���
 * 
 * Class�ࣺ
 * 		��Ա����Field
 * 		���췽��Constructor
 * 		��Ա����Method
 * 
 * ��ȡclass�ļ�����ķ���
 * 		1:Object���getClass()����
 * 		2:�������͵ľ�̬����class
 * 		3:Class���forName()����
 * 
 */
public class ReflectDemo {

	@Test
	public void reflectTest() throws Exception {

		// ��ȡ�ֽ����ļ�����
		String className = "top.trial.demo.entity.GameEntity";
		Class c = getClassN(className);
		
		//��ȡĬ�Ϲ��췽���������
		c.newInstance();

		// ��ȡ�������췽��
		Constructor[] cons = c.getConstructors();
		for (Constructor con0 : cons) {
			// System.out.println(con);
		}

		// ��ȡ���й��췽��
		Constructor[] consAll = c.getDeclaredConstructors();
		for (Constructor con0 : consAll) {
			// System.out.println(con);
		}

		// ��ȡ�����������췽��
		Constructor conP = c.getConstructor();
		// System.out.println(conP);

		// ��ȡ�������췽��
		Constructor conA = c.getDeclaredConstructor(Double.class);
		// System.out.println(conA);

		// ��ȡ��GameEntity�Ķ���
		Object obj = conP.newInstance();

		// ˽�й��췽������Ҫ������setAccessible������Ϊtrueʱ��ȡ��java�ķ��ʼ�顣
		conA.setAccessible(true);
		Object obj0 = conA.newInstance(1.23);

		// ��ȡ���й�����Ա����/��Ա����
		Field[] fs = c.getFields();
		Field[] fsA = c.getDeclaredFields();

		// ��ȡ����������Ա����/��Ա����
		Field f = c.getField("name");
		Field fA = c.getDeclaredField("grade");

		// ��ֵ����һ������Ϊ���󣬵ڶ�������Ϊֵ
		fA.setAccessible(true);
		fA.set(obj, 12.34);

		// ��ȡ�Լ��İ�������Ĺ�����Ա����
		Method[] ms = c.getMethods();
		// ��ȡ�Լ���ȫ����Ա����
		Method[] msA = c.getDeclaredMethods();

		Method m = c.getMethod("method", String.class);
		m.invoke(obj, "HAHA");

	}

	private static Class getClassN(String className) throws ClassNotFoundException {

		// ����1
		GameEntity gameEntity = new GameEntity();
		Class c1 = gameEntity.getClass();
		// ��ʽ2
		Class c2 = GameEntity.class;
		// ��ʽ3
		Class c3 = Class.forName(className);

		return c3;
	}

}

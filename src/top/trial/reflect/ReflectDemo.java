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
 * 反射是指通过class文件对象，使用该文件中的变量和方法
 * 
 * Class类：
 * 		成员变量Field
 * 		构造方法Constructor
 * 		成员方法Method
 * 
 * 获取class文件对象的方法
 * 		1:Object类的getClass()方法
 * 		2:数据类型的静态属性class
 * 		3:Class类的forName()方法
 * 
 */
public class ReflectDemo {

	@Test
	public void reflectTest() throws Exception {

		// 获取字节码文件对象
		String className = "top.trial.demo.entity.GameEntity";
		Class c = getClassN(className);
		
		//获取默认构造方法构造对象
		c.newInstance();

		// 获取公共构造方法
		Constructor[] cons = c.getConstructors();
		for (Constructor con0 : cons) {
			// System.out.println(con);
		}

		// 获取所有构造方法
		Constructor[] consAll = c.getDeclaredConstructors();
		for (Constructor con0 : consAll) {
			// System.out.println(con);
		}

		// 获取单个公共构造方法
		Constructor conP = c.getConstructor();
		// System.out.println(conP);

		// 获取单个构造方法
		Constructor conA = c.getDeclaredConstructor(Double.class);
		// System.out.println(conA);

		// 获取到GameEntity的对象
		Object obj = conP.newInstance();

		// 私有构造方法，需要先设置setAccessible，参数为true时，取消java的访问检查。
		conA.setAccessible(true);
		Object obj0 = conA.newInstance(1.23);

		// 获取所有公共成员变量/成员变量
		Field[] fs = c.getFields();
		Field[] fsA = c.getDeclaredFields();

		// 获取单个公共成员变量/成员变量
		Field f = c.getField("name");
		Field fA = c.getDeclaredField("grade");

		// 赋值，第一个参数为对象，第二个参数为值
		fA.setAccessible(true);
		fA.set(obj, 12.34);

		// 获取自己的包括父类的公共成员方法
		Method[] ms = c.getMethods();
		// 获取自己的全部成员方法
		Method[] msA = c.getDeclaredMethods();

		Method m = c.getMethod("method", String.class);
		m.invoke(obj, "HAHA");

	}

	private static Class getClassN(String className) throws ClassNotFoundException {

		// 方法1
		GameEntity gameEntity = new GameEntity();
		Class c1 = gameEntity.getClass();
		// 方式2
		Class c2 = GameEntity.class;
		// 方式3
		Class c3 = Class.forName(className);

		return c3;
	}

}

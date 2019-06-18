package top.trial.annotation;

import java.lang.reflect.Method;

/**
 * 单元测试主类，遍历要单元测试的类的成员方法，找出有单元测试注解的方法，利用反射执行方法并计算执行时间，给出反馈。
 * 
 * @author Gaoyx
 *
 */
public class JUnitDemo {
	public static void main(String[] args) throws Exception {
		// 获取要单元测试类的Class
		Class clazz = Class.forName("top.trial.annotation.UnitCase");
		// 获取全部方法
		Method methods[] = clazz.getMethods();
		// 遍历方法
		for (Method method : methods) {
			// 找到有@AnnotationUnitDemo注解的方法
			if (method.isAnnotationPresent(AnnotationUnitDemo.class)) {
				// 取得注解实例
				AnnotationUnitDemo annotationUnitDemo = method.getAnnotation(AnnotationUnitDemo.class);
				// 取得注解属性timeout()
				long timeout = annotationUnitDemo.timeout();
				System.out.println("timeout:"+timeout);

				long start = System.currentTimeMillis();
				// invoke 参数为null
				method.invoke(clazz.newInstance(), null);
				// 取得方法耗时
				long usetime = System.currentTimeMillis() - start;
				System.out.println("usetime:"+usetime);
				if (usetime > timeout) {
					throw new RuntimeException("运行超时");
				}
			}
		}
	}
}

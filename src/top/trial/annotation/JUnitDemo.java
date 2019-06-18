package top.trial.annotation;

import java.lang.reflect.Method;

/**
 * ��Ԫ�������࣬����Ҫ��Ԫ���Ե���ĳ�Ա�������ҳ��е�Ԫ����ע��ķ��������÷���ִ�з���������ִ��ʱ�䣬����������
 * 
 * @author Gaoyx
 *
 */
public class JUnitDemo {
	public static void main(String[] args) throws Exception {
		// ��ȡҪ��Ԫ�������Class
		Class clazz = Class.forName("top.trial.annotation.UnitCase");
		// ��ȡȫ������
		Method methods[] = clazz.getMethods();
		// ��������
		for (Method method : methods) {
			// �ҵ���@AnnotationUnitDemoע��ķ���
			if (method.isAnnotationPresent(AnnotationUnitDemo.class)) {
				// ȡ��ע��ʵ��
				AnnotationUnitDemo annotationUnitDemo = method.getAnnotation(AnnotationUnitDemo.class);
				// ȡ��ע������timeout()
				long timeout = annotationUnitDemo.timeout();
				System.out.println("timeout:"+timeout);

				long start = System.currentTimeMillis();
				// invoke ����Ϊnull
				method.invoke(clazz.newInstance(), null);
				// ȡ�÷�����ʱ
				long usetime = System.currentTimeMillis() - start;
				System.out.println("usetime:"+usetime);
				if (usetime > timeout) {
					throw new RuntimeException("���г�ʱ");
				}
			}
		}
	}
}

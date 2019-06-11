package top.trial.annotation;

import java.io.IOException;
import java.lang.reflect.Method;

import top.util.properties.PropertiesUtil;

public class UnitCase {
	
	/**
	 * ʵ�ִ���ĵ�Ԫ����
	 * 
	 * @throws Exception
	 */
	@AnnotationUnitDemo(timeout=1)
	public void testCase() throws Exception {
		String rootDemo = PropertiesUtil.getPropertiesValueByClassloader("rootDemo.properties", "propertiesName");
		System.out.println(rootDemo);
	}
	
}

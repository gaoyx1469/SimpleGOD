package top.trial.reflect;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;
import org.junit.Test;

import top.trail.demo.entity.GameEntity;
import top.trail.demo.entity.PlayerEntity;

/**
 * 内省测试类
 * 
 * @author 高宇翔
 *
 */
public class IntrospectorDemo {

	// 测试Introspector类的方法
	@Test
	public void test1() throws Exception {

		// 得到GameEntity中的属性，被封装到了BeanInfo中
		BeanInfo bi = Introspector.getBeanInfo(GameEntity.class);

		// 得到类中所有属性描述
		PropertyDescriptor[] ps = bi.getPropertyDescriptors();
		System.out.println(ps.length);

		// 遍历属性名
		for (PropertyDescriptor p : ps) {
			System.out.println(p.getName());
		}
	}

	// 测试PropertyDescriptor类的方法
	@Test
	public void test2() throws Exception {

		// 实例化对象
		GameEntity ge = new GameEntity();

		// 获得某个属性的描述器
		PropertyDescriptor pd = new PropertyDescriptor("name", GameEntity.class);

		Method mw = pd.getWriteMethod();
		mw.invoke(ge, "HAHA~");

		Method mr = pd.getReadMethod();
		String returnValue = (String) mr.invoke(ge, null);

		System.out.println(returnValue);

	}

	// 测试beanutils框架工具包
	@Test
	public void test3() throws Exception {

		// 实例化对象
		GameEntity ge = new GameEntity();

		// 设置属性值(第三个参数可以把String转换成Bean中所需的基本类型，非基本类型的转换看下例)
		BeanUtils.setProperty(ge, "name", "BEANUTILS");

		// 获取属性值
		String name = BeanUtils.getProperty(ge, "name");

		System.out.println(name);
	}

	// 测试beanutils框架工具包setProperty方法设置非基本类型的属性值
	@Test
	public void test4() throws Exception {

		// 实例化对象,对象的birthday属性是Date属性
		PlayerEntity pe = new PlayerEntity();

		// 注册类型转换器(转换器功能等同于Converter的实现类：DateLocaleConverter类,详见test5)
		ConvertUtils.register(new Converter() {

			@Override
			public Object convert(Class type, Object value) {
				// type:目标类型
				// value:当前传入值

				DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				if (value instanceof String) {// 将String类型的value转换为Date类型

					String v = (String) value;
					try {
						Date d = df.parse(v);
						return d;
					} catch (ParseException e) {
						e.printStackTrace();
					}

				} else {// 将Date类型的value转换为String类型

					Date d = (Date) value;
					String s = df.format(d);
					return s;
				}

				return null;
			}

		}, Date.class);

		// 设置属性值
		BeanUtils.setProperty(pe, "birthday", "2019-01-08");
		System.out.println(pe.getBirthday());
	}

	// 测试beanutils框架工具包populate方法将
	@Test
	public void test5() throws Exception {

		// 实例化对象,对象的birthday属性是Date属性
		PlayerEntity pe = new PlayerEntity();

		// 新建Map
		Map map = new HashMap();
		map.put("name", "XXX");
		map.put("age", "27");
		map.put("birthday", "1991-10-01");
		map.put("level", "3");

		System.out.println("处理前：" + pe);

		// 注册类型转换器
		ConvertUtils.register(new DateLocaleConverter(), Date.class);
		BeanUtils.populate(pe, map);

		System.out.println("处理后：" + pe);

	}
}

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
 * ��ʡ������
 * 
 * @author ������
 *
 */
public class IntrospectorDemo {

	// ����Introspector��ķ���
	@Test
	public void test1() throws Exception {

		// �õ�GameEntity�е����ԣ�����װ����BeanInfo��
		BeanInfo bi = Introspector.getBeanInfo(GameEntity.class);

		// �õ�����������������
		PropertyDescriptor[] ps = bi.getPropertyDescriptors();
		System.out.println(ps.length);

		// ����������
		for (PropertyDescriptor p : ps) {
			System.out.println(p.getName());
		}
	}

	// ����PropertyDescriptor��ķ���
	@Test
	public void test2() throws Exception {

		// ʵ��������
		GameEntity ge = new GameEntity();

		// ���ĳ�����Ե�������
		PropertyDescriptor pd = new PropertyDescriptor("name", GameEntity.class);

		Method mw = pd.getWriteMethod();
		mw.invoke(ge, "HAHA~");

		Method mr = pd.getReadMethod();
		String returnValue = (String) mr.invoke(ge, null);

		System.out.println(returnValue);

	}

	// ����beanutils��ܹ��߰�
	@Test
	public void test3() throws Exception {

		// ʵ��������
		GameEntity ge = new GameEntity();

		// ��������ֵ(�������������԰�Stringת����Bean������Ļ������ͣ��ǻ������͵�ת��������)
		BeanUtils.setProperty(ge, "name", "BEANUTILS");

		// ��ȡ����ֵ
		String name = BeanUtils.getProperty(ge, "name");

		System.out.println(name);
	}

	// ����beanutils��ܹ��߰�setProperty�������÷ǻ������͵�����ֵ
	@Test
	public void test4() throws Exception {

		// ʵ��������,�����birthday������Date����
		PlayerEntity pe = new PlayerEntity();

		// ע������ת����(ת�������ܵ�ͬ��Converter��ʵ���ࣺDateLocaleConverter��,���test5)
		ConvertUtils.register(new Converter() {

			@Override
			public Object convert(Class type, Object value) {
				// type:Ŀ������
				// value:��ǰ����ֵ

				DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				if (value instanceof String) {// ��String���͵�valueת��ΪDate����

					String v = (String) value;
					try {
						Date d = df.parse(v);
						return d;
					} catch (ParseException e) {
						e.printStackTrace();
					}

				} else {// ��Date���͵�valueת��ΪString����

					Date d = (Date) value;
					String s = df.format(d);
					return s;
				}

				return null;
			}

		}, Date.class);

		// ��������ֵ
		BeanUtils.setProperty(pe, "birthday", "2019-01-08");
		System.out.println(pe.getBirthday());
	}

	// ����beanutils��ܹ��߰�populate������
	@Test
	public void test5() throws Exception {

		// ʵ��������,�����birthday������Date����
		PlayerEntity pe = new PlayerEntity();

		// �½�Map
		Map map = new HashMap();
		map.put("name", "XXX");
		map.put("age", "27");
		map.put("birthday", "1991-10-01");
		map.put("level", "3");

		System.out.println("����ǰ��" + pe);

		// ע������ת����
		ConvertUtils.register(new DateLocaleConverter(), Date.class);
		BeanUtils.populate(pe, map);

		System.out.println("�����" + pe);

	}
}
